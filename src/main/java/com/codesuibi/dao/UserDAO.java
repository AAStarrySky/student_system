package com.codesuibi.dao;

import com.codesuibi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    void save(User user);
}
