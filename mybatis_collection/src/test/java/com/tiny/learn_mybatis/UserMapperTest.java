package com.tiny.learn_mybatis;

import com.tiny.learn_mybatis.dao.UserDao;
import com.tiny.learn_mybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired(required = false)
    private UserDao userDao;


    @Test
    public void listUser(){
       List<User> userList =  userDao.selectOne(100057);
        for (User user : userList) {
            System.out.println("test----."+user.getEmpNo());
        }
    }
}
