package com.codesuibi.dao;

import com.codesuibi.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDAO extends BaseDAO<Student,String> {

    List<Student> find(@Param("searchCol") String searchCol,@Param("searchValue") String searchValue);

    List<Student> findPageAndLike(@Param("start") Integer start, @Param("pageSize") Integer pageSize,
                                  @Param("searchCol") String searchCol,@Param("searchValue") String searchValue);

    Integer totalCounts(@Param("searchCol") String searchCol,@Param("searchValue") String searchValue);

    Integer selectMaxStudentNumber();

    List<Student> findByGroupId(@Param("groupId") String groupId);

}
