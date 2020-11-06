package com.codesuibi.controller;

import com.codesuibi.entity.City;
import com.codesuibi.result.Result;
import com.codesuibi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("findAll")
    public String findAllCity(Model model){
        List<City> cities = cityService.findAll();

        model.addAttribute("citys",cities);

        return "back/city/index";
    }

    @RequestMapping("findAllJSON")
    @ResponseBody
    public List<City> findAllJSON(){
       return cityService.findAll();
    }



    @RequestMapping("save")
    @ResponseBody
    public Result save(City city){

        Result result = new Result();

        try{
            cityService.save(city);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false).setMsg(e.getMessage());

            return result;
        }

        result.setMsg("添加成功").setStatus(true);

        return result;
    }


}
