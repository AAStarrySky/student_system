package com.codesuibi.student_system;

import com.codesuibi.dao.GroupDAO;
import com.codesuibi.entity.Group;
import com.codesuibi.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupDAO groupDAO;

    @Test
    void findAllTest() {
        List<Group> groupAll = groupService.findAll();
        groupAll.forEach(group -> {
            System.out.println(group);
        });
    }

    @Test
    void findByNameAndClazzidTest() {
        Group group = groupDAO.findByNameAndClazzid("一组", "1");
        System.out.println(group);
    }
    @Test
    void findByClazzId() {
        List<Group> groups = groupService.findByClazzId("1");
        groups.forEach(group -> {
            System.out.println(group);
        });

    }

}
