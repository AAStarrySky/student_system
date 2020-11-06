package com.codesuibi.service;

import com.codesuibi.dao.GroupDAO;
import com.codesuibi.dao.StudentDAO;
import com.codesuibi.entity.Group;
import com.codesuibi.entity.Student;
import com.codesuibi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Group> findAll() {
        List<Group> groups = groupDAO.findAll();

        //遍历每一个组，找每一个组的标签
        groups.forEach(group -> {

            List<Student> students = studentDAO.findByGroupId(group.getId());
            Map<String,Integer> tagsMap = new HashMap<>();
            //对每一个学生进行遍历，将它门的标签取出来
            students.forEach(student -> {

                List<Tag> tags = student.getTags();
                tags.forEach(tag -> {
                    if(!tagsMap.containsKey(tag.getName())){
                        tagsMap.put(tag.getName(),1);
                    }else{
                        tagsMap.put(tag.getName(),tagsMap.get(tag.getName()) + 1);
                    }
                });

            });

            tagsMap.forEach((k,v)->{
                if(v == students.size()){
                    group.getTags().add(k);
                }
            });

        });

        return groups;
    }

    @Override
    public void save(Group group) {
        Group groupDB = groupDAO.findByNameAndClazzid(group.getName(),group.getClazzid());

        if(groupDB == null){
            groupDAO.save(group);
        }else{
            throw  new RuntimeException("该班级已经存在这个小组");
        }
    }

    @Override
    public List<Group> findByClazzId(String clazzId) {
        return groupDAO.findByClazzId(clazzId);
    }


}
