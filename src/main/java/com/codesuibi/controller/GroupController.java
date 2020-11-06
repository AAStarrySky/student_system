package com.codesuibi.controller;

import com.codesuibi.entity.Group;
import com.codesuibi.result.Result;
import com.codesuibi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups",groups);

        return "back/group/index";
    }


    @RequestMapping("findByClazzId")
    @ResponseBody
    public List<Group> findByClazzId(String id){
        System.out.println("进入了findByClazzId");
        System.out.println("id" + id);
        List<Group> groups = groupService.findByClazzId(id);
        System.out.println(groups);
        return groupService.findByClazzId(id);
    }


    @RequestMapping("save")
    @ResponseBody
    public Result save(Group group){

        Result result = new Result();

        try {
            groupService.save(group);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false).setMsg("添加失败:"+e.getMessage());

            return result;
        }

        result.setMsg("添加成功").setStatus(true);

        return result;
    }
}
