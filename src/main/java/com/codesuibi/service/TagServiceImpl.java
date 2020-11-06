package com.codesuibi.service;

import com.codesuibi.dao.TagDAO;
import com.codesuibi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements  TagService{

    @Autowired
    private TagDAO tagDAO;

    @Override
    public List<Tag> findAll() {
        return tagDAO.findAll();
    }

    @Override
    public void save(Tag tag) {
        Tag byName = tagDAO.findByName(tag.getName());
        if (byName == null){
            tag.setCreatetime(new Date());
            tagDAO.save(tag);
        }else{
            throw new RuntimeException("该标签已经存在");
        }
    }

    @Override
    public List<Tag> findByType(String type) {
        return tagDAO.findByType(type);
    }


}
