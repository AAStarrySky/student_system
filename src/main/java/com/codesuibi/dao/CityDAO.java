package com.codesuibi.dao;

import com.codesuibi.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityDAO extends BaseDAO<City,String>{

    City findByName(String name);

    void update(City city);

    City findById(@Param("id") String id);

}
