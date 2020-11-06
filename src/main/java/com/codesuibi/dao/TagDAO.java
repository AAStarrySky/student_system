package com.codesuibi.dao;

import com.codesuibi.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDAO extends BaseDAO<Tag,String> {

    Tag findByName(String name);

    List<Tag> findByType(String type);
}
