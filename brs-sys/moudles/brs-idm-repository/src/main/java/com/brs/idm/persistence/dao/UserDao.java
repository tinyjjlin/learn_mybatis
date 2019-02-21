package com.brs.idm.persistence.dao;

import com.brs.idm.api.dto.LoginUserInfoRepresentation;
import com.brs.idm.api.User;
import com.brs.idm.api.dto.LoginUserRepresentation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author tiny lin
 * @date 2019/2/20
 */
public interface UserDao {
    /**
     * add new user
     * @param user
     */
     void insertUser(@Param("user") User user);

    /**
     * loing user info
     * @param userId
     * @return
     */
     LoginUserInfoRepresentation selectLoginUserInfo(@Param("userId") String userId);

    /**
     * idm all user
     * @return
     */
     List<LoginUserRepresentation> selectUserAll();




}
