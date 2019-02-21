package com.brs.idm.service.impl;

import com.brs.idm.api.IdmIdentityService;
import com.brs.idm.api.Privilege;
import com.brs.idm.api.Role;
import com.brs.idm.api.User;
import com.brs.idm.api.dto.LoginUserInfoRepresentation;
import com.brs.idm.api.dto.LoginUserRepresentation;
import com.brs.idm.api.dto.PrivilegeRepresentation;
import com.brs.idm.api.dto.RoleRepresentation;
import com.brs.idm.persistence.dao.PrivilegeDao;
import com.brs.idm.persistence.dao.RoleDao;
import com.brs.idm.persistence.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/20
 */
@Service("idmIdentityServiceImpl")
public class IdmIdentityServiceImpl implements  IdmIdentityService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PrivilegeDao privilegeDao;



    @Override
    public void saveUser(User user) {
       userDao.insertUser( user);
    }

    @Override
    public void saveRole(Role role) {
       roleDao.insertRole( role);
    }

    @Override
    public void savePrivilege(Privilege privilege) {
       privilegeDao.insertPrivilege( privilege);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateRole(Role role) {
             roleDao.updateRole(role);
    }

    @Override
    public void updatePrivilege(Privilege privilege) {
          privilegeDao.updatePrivilege(privilege);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void deleteRole(String roleId) {
           roleDao.deleteRole(roleId);
    }

    @Override
    public void deletePrivilege(String privilegeId) {
              privilegeDao.deletePrivilege(privilegeId);
    }

    @Override
    public void addUserRoleMapping(String userId, String roleId) {

    }

    @Override
    public void deleteUserRoleMapping(String userId, String roleId) {

    }

    @Override
    public void addUserPrivilegeMapping(String userId, String privilegeId) {

    }

    @Override
    public void deleteUserPrivilegeMapping(String userId, String privilegeId) {

    }

    @Override
    public void addRolePrivilegeMapping(String roleId, String privilegeId) {

    }

    @Override
    public void deleteRolePrivilegeMapping(String roleId, String privilegeId) {

    }

    @Override
    public List<User> getUserWithRole(String roleId) {
        return null;
    }

    @Override
    public void addUserRoleMapping(List <String> userIds, String roleId) {
         roleDao.bindUsers(roleId,userIds );
    }

    @Override
    public void addUserPrivilegeMapping(List <String> userIds, String privilegeId) {

    }

    @Override
    public List <LoginUserRepresentation> getUserAll() {
        return userDao.selectUserAll();
    }

    @Override
    public List <RoleRepresentation> getRoleAll() {
        return roleDao.selectRoleAll();
    }

    @Override
    public List <PrivilegeRepresentation> getPrivilegeByUserId(String userId) {
        return privilegeDao.selectPrivilegeByUserId(userId);
    }

    @Override
    public List <PrivilegeRepresentation> getPrivilegeAll() {
        return privilegeDao.selectPrivilegeAll();
    }

    @Override
    public void addRolePrivilegeMapping(List <String> roleIds, String privilegeId) {
          privilegeDao.bindRoles(privilegeId,roleIds );
    }

    @Override
    public List <User> getUserWithPrivilege(String privilegeId) {
        return null;
    }

    @Override
    public List <Role> getRoleWithPrivilege(String privilegeId) {
        return null;
    }

    @Override
    public User getUser(String userId) {
        return null;
    }

    @Override
    public Role getRole(String roleId) {
        return null;
    }

    @Override
    public Privilege getPrivilege(String privilegeId) {
        return null;
    }

    @Override
    public LoginUserInfoRepresentation getLoginUserInfo(String userId) {
        return userDao.selectLoginUserInfo(userId );
    }
}
