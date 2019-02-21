package com.brs.idm.api;
import com.brs.idm.api.dto.LoginUserInfoRepresentation;
import com.brs.idm.api.dto.LoginUserRepresentation;
import com.brs.idm.api.dto.PrivilegeRepresentation;
import com.brs.idm.api.dto.RoleRepresentation;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/20
 */
public interface IdmIdentityService {
    void saveUser(User user);
    void saveRole(Role role);
    void savePrivilege(Privilege privilege);

    void updateUser(User user);
    void updateRole(Role role);
    void updatePrivilege(Privilege privilege);

    void deleteUser(String userId);
    void deleteRole(String roleId);
    void deletePrivilege(String privilegeId);

    void addUserRoleMapping(String userId,String roleId);
    void addUserRoleMapping(List<String>userIds,String roleId);
    void deleteUserRoleMapping(String userId,String  roleId);
    void addUserPrivilegeMapping(List<String>userIds,String privilegeId);
    void addUserPrivilegeMapping(String userId,String privilegeId);
    void deleteUserPrivilegeMapping(String userId,String privilegeId);
    void addRolePrivilegeMapping(List<String>roleIds,String privilegeId);
    void addRolePrivilegeMapping(String roleId,String privilegeId);
    void deleteRolePrivilegeMapping(String roleId,String privilegeId);

    List<User> getUserWithRole(String roleId);
    List<User> getUserWithPrivilege(String privilegeId);
    List<Role> getRoleWithPrivilege(String privilegeId);

    User getUser(String userId);
    Role  getRole(String roleId);
    Privilege getPrivilege(String privilegeId);

    /**
     * get login user info
     * @param userId
     * @return
     */
    LoginUserInfoRepresentation getLoginUserInfo(String userId);
    List<LoginUserRepresentation> getUserAll();
    List<RoleRepresentation> getRoleAll();
    List<PrivilegeRepresentation> getPrivilegeAll();

    /**
     * get user  privilege
     * @param userId
     * @return
     */
    List<PrivilegeRepresentation> getPrivilegeByUserId(String userId);
  }
