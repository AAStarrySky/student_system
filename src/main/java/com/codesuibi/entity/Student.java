package com.codesuibi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Student {

    private String id;
    private String name;
    private Integer age;
    private Date bir;
    private String phone;
    private String qq;
    private String attr;
    private String starts;
    private String mark;
    private Integer studentNumber;//学号


    private String cityid;
    private String clazzid;
    private  String groupid;

    private City city;
    private Clazz clazz;
    private Group group;

    private List<Tag> tags;
}
