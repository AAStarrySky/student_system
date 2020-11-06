package com.codesuibi.service;

import com.codesuibi.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    void save(Group group);

    List<Group> findByClazzId(String clazzId);
}
