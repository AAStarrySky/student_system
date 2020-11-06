package com.codesuibi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

//第一个泛型是实体类型，第二个泛型是主键类型
public interface BaseDAO<T,K> {

    void save(T t);

    void update(T t,K k);

    void delete(T t, K k);

    List<T> findAll();

    T findById(K k);

    List<T> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    Long findCounts();

}
