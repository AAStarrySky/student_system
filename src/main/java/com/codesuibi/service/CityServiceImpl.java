package com.codesuibi.service;

import com.codesuibi.dao.CityDAO;
import com.codesuibi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityDAO cityDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public void save(City city) {

        City cityFindbyName = cityDAO.findByName(city.getName());

        if(cityFindbyName == null){
            city.setCreatetime(new Date());
            city.setNumbers(0);
            cityDAO.save(city);
        }else{
            throw new RuntimeException("该城市已经存在");
        }

    }

}
