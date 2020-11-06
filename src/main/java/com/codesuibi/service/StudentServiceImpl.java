package com.codesuibi.service;

import com.codesuibi.dao.CityDAO;
import com.codesuibi.dao.StudentDAO;
import com.codesuibi.dao.StudentTagDAO;
import com.codesuibi.entity.City;
import com.codesuibi.entity.Student;
import com.codesuibi.entity.StudentTag;
import com.codesuibi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentTagDAO studentTagDAO;

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findAll(String searchCol, String searchValue) {
        return studentDAO.find(searchCol,searchValue);
    }

    @Override
    public List<Student> findAll(Integer pageNow, Integer pageSize, String searchCol, String searchValue) {

        int start = (pageNow - 1) * pageSize;

        return studentDAO.findPageAndLike(start, pageSize, searchCol, searchValue);
    }

    @Override
    public Integer totalCounts(String searchCol, String searchValue) {
        return studentDAO.totalCounts(searchCol,searchValue);
    }

    @Override
    public void save(Student student, String[] tagIds) {

        //计算年龄
        int age = DateUtil.getAge(student.getBir());
        student.setAge(age);
        //计算生肖和星座
        String attr = DateUtil.getYear(Integer.valueOf(new SimpleDateFormat("yyyy").format(student.getBir())));
        student.setAttr(attr);
        String starts = DateUtil.getConstellation(student.getBir());
        student.setStarts(starts);

        //学号
        Integer maxStudentNumber = studentDAO.selectMaxStudentNumber();
        student.setStudentNumber(maxStudentNumber + 1);
        //保存学生
        studentDAO.save(student);

        //保存标签
        for (String tagId : tagIds) {
            StudentTag stuTag = new StudentTag();
            stuTag.setStudentid(student.getId());
            stuTag.setTagid(tagId);

            studentTagDAO.save(stuTag);

        }


        City cityFindById = cityDAO.findById(student.getCityid());
        Integer num = cityFindById.getNumbers();
        cityFindById.setNumbers(num + 1);

        cityDAO.update(cityFindById);

    }
}
