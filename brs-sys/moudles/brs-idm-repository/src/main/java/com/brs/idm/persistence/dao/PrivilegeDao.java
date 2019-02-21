package com.brs.idm.persistence.dao;

import com.brs.idm.api.Privilege;
import com.brs.idm.api.dto.PrivilegeRepresentation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/20
 */
public interface PrivilegeDao {

    @Select("select id_ as privId, name_ as privName from brs_idm_priv")
    List<PrivilegeRepresentation> selectPrivilegeAll();

    @Select("SELECT brs_idm_priv.id_ as privId,brs_idm_priv.name_ as privName FROM brs_idm.brs_idm_priv\n" +
            "LEFT JOIN\n" +
            "brs_idm_priv_mapping as bpm\n" +
            "on  bpm.priv_id_ = brs_idm_priv.id_\n" +
            "LEFT JOIN\n" +
            "brs_idm_role as bir\n" +
            "on bpm.role_id_ = bir.id_\n" +
            "LEFT JOIN\n" +
            "brs_idm_membership as bim\n" +
            "on bir.id_ = bim.role_id_\n" +
            "where bim.user_id_ = #{userId}")
    List<PrivilegeRepresentation> selectPrivilegeByUserId(@Param("userId")String userId);
    /**
     * add new privilege
     * @param privilege
     */
    @Insert("insert into brs_idm_priv(id_,name_)values(#{privilege.privId},#{privilege.privName})")
    void insertPrivilege(@Param("privilege") Privilege privilege);

    @Delete("delete from brs_idm_priv where id_ =#{privId}")
    void deletePrivilege(@Param("privId")String privId);

    @Update("update brs_idm_priv set name_ = #{privilege.privName} where id_ =#{privilege.privId}")
    void updatePrivilege(@Param("privilege") Privilege privilege);

    @Insert({
            "<script>",
            "insert into brs_idm_priv_mapping(priv_id_,role_id_)values",
            "<foreach collection='roleIds' item='roleId' index='index' separator=','>",
            "(#{privId},#{roleId})",
            "</foreach>",
            "</script>"
    })
    void bindRoles(@Param("privId")String privId, @Param("roleIds")List<String>roleIds);


}
