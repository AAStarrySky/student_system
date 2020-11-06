package com.codesuibi.dao;

import com.codesuibi.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupDAO extends BaseDAO<Group,String> {

    Group findByNameAndClazzid(String name,String clazzID);

    List<Group> findByClazzId(@Param("clazzId") String clazzId);

}
