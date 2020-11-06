package com.codesuibi.student_system;

import com.codesuibi.dao.StudentDAO;
import com.codesuibi.entity.Student;
import com.codesuibi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void findAllTest(){

        List<Student> students = studentService.findAll(1, 6, "s.name", "三");

        students.forEach(student -> {
            System.out.println(student);
        });


        Integer tol = studentService.totalCounts("s.name", "三");
        System.out.println(tol);
    }

    @Test
    public void selectMaxStudentNumber(){
        System.out.println(studentDAO.selectMaxStudentNumber());
    }

    @Test
    public void findByGroupIdTest(){
        List<Student> byGroupId = studentDAO.findByGroupId("1");
        for (Student student : byGroupId) {
            System.out.println(student);
        }
    }
}
