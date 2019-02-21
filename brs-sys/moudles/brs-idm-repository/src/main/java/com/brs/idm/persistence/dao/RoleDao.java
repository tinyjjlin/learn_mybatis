package com.brs.idm.persistence.dao;

import com.brs.idm.api.Role;
import com.brs.idm.api.dto.RoleRepresentation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/20
 */
public interface RoleDao {

    @Select("select id_ as roleId,name_ as roleName from brs_idm_role")
    List<RoleRepresentation> selectRoleAll();

    /**
     * add new role
     * @param roleEntity
     */
    @Insert("insert into brs_idm_role(id_,name_,type_)values(#{role.roleId},#{role.roleName},#{role.roleType})")
    void insertRole(@Param("role") Role roleEntity);

    @Delete("delete from brs_idm_role where id_ = #{roleId}")
    void deleteRole(@Param("roleId")String roleId);

    @Update("update brs_idm_role set name_ = #{role.roleName} where id_ = #{role.roleId}")
    void updateRole(@Param("role")Role role);


    @Insert({
            "<script>",
            "insert into brs_idm_membership(user_id_,role_id_)values",
            "<foreach collection='userIds' item='userId' index='index' separator=','>",
            "(#{userId},#{roleId})",
            "</foreach>",
            "</script>"
    })
    void bindUsers(@Param("roleId")String roleId, @Param("userIds")List<String> userIds);




    @Delete({
            "<script>",
            "insert into brs_idm_membership(user_id_,role_id_)values",
            "<foreach collection='userIds' item='userId' index='index' separator=','>",
            "(#{userId},#{roleId})",
            "</foreach>",
            "</script>"
    })
    void unbindUsers(@Param("roleId")String roleId, @Param("userIds")List<String> userIds);
}
