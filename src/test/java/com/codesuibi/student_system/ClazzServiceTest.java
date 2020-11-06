package com.codesuibi.student_system;

import com.codesuibi.entity.Clazz;
import com.codesuibi.service.ClazzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClazzServiceTest {
    @Autowired
    private ClazzService clazzService;

    @Test
    public void findAllTest(){
        List<Clazz> all = clazzService.findAll();
        all.forEach(clazz -> {
            System.out.println(clazz);
        });
    }
}
