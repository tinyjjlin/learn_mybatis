package com.tiny.learn_mybatis.dao;

import com.tiny.learn_mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
public interface UserDao {
    List<User> selectOne(@Param("empNo")Integer empNo);



}
