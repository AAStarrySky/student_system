package com.codesuibi.service;

import com.codesuibi.entity.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    void save(City city);

}
