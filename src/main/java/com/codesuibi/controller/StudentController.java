package com.codesuibi.controller;

import com.codesuibi.entity.Student;
import com.codesuibi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("save")
    public String save(Student student, String[] tagIds){

        studentService.save(student,tagIds);

        return "redirect:/student/findAll";

    }

    @RequestMapping("findAll")
    public String findAll(Integer pageNow, Integer pageSize, String searchCol, String searchValue, Model model){

        pageNow = pageNow==null?1:pageNow;
        pageSize = pageSize == null?4:pageSize;

        List<Student> students = studentService.findAll(pageNow,pageSize,searchCol,searchValue);

        Integer tot = studentService.totalCounts(searchCol,searchValue);

        int totalPage = tot % pageSize == 0?tot/pageSize:tot/pageSize + 1;

        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageNow",pageNow);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("searchCol",searchCol);
        model.addAttribute("searchValue",searchValue);
        model.addAttribute("students",students);
        return "back/student/index";

    }
}
