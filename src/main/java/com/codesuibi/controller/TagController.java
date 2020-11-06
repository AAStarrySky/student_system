package com.codesuibi.controller;

import com.codesuibi.entity.City;
import com.codesuibi.entity.Tag;
import com.codesuibi.result.Result;
import com.codesuibi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tag")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping("findAll")
    public String findAllCity(Model model){
        List<Tag> tags = tagService.findAll();

        model.addAttribute("tags",tags);

        return "back/tag/index";
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(Tag tag){
        Result result = new Result();

        try{
            tagService.save(tag);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false).setMsg("添加失败:"+e.getMessage());

            return result;
        }

        result.setMsg("添加成功").setStatus(true);

        return result;
    }

    @RequestMapping("findByType")
    @ResponseBody
    public List<Tag> findByType(String type){
        return tagService.findByType(type);
    }


}
