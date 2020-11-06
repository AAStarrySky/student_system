package com.codesuibi.service;

import com.codesuibi.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    List<Student> findAll(String searchCol,String searchValue);

    List<Student> findAll(Integer pageNow, Integer pageSize, String searchCol, String searchValue);

    Integer totalCounts(String searchCol, String searchValue);

    void save(Student student,String[] tagIds);

}
