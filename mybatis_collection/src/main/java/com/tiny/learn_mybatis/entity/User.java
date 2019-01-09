package com.tiny.learn_mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class User {
    private Integer id;
    private Integer empNo;
    private String name;
    private List<EducationExp> educationExpList;
}
