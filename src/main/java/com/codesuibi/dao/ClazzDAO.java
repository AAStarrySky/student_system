package com.codesuibi.dao;

import com.codesuibi.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzDAO extends BaseDAO<Clazz,String>{
    Clazz findByName(String name);
}
