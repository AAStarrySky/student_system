package com.codesuibi.service;

import com.codesuibi.entity.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> findAll();

    void save(Clazz clazz);

}
