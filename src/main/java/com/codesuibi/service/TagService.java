package com.codesuibi.service;

import com.codesuibi.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    void save(Tag tag);

    List<Tag> findByType(String type);

}
