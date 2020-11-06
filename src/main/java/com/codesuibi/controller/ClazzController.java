package com.codesuibi.controller;


import com.codesuibi.entity.Clazz;
import com.codesuibi.result.Result;
import com.codesuibi.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @RequestMapping("findAll")
    public String findAllCity(Model model){
        List<Clazz> clazzes = clazzService.findAll();

        model.addAttribute("clazzs",clazzes);

        return "back/clazz/index";
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(Clazz clazz){

        Result result = new Result();

        try{
            clazzService.save(clazz);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false).setMsg("添加失败:"+e.getMessage());
            return result;
        }

        result.setMsg("添加成功").setStatus(true);

        return result;
    }

    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Clazz> findAllClazzJSON(){

        Result result = new Result();

        List<Clazz> clazzs = clazzService.findAll();

        return clazzs;
    }


}
