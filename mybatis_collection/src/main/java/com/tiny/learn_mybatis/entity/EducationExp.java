package com.tiny.learn_mybatis.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class EducationExp {

   // private Integer id;
    private Integer educationExpNo;
    private String school;
    private String degree;
    private Date fromEndTime;
  // private Integer empNo;
}
