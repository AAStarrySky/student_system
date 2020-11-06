package com.codesuibi.student_system;

import com.codesuibi.entity.Tag;
import com.codesuibi.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    public void findByTypeTest(){
        List<Tag> findByTypes = tagService.findByType("学生");
        findByTypes.forEach(tag -> {
            System.out.println(tag);
        });
    }
}
