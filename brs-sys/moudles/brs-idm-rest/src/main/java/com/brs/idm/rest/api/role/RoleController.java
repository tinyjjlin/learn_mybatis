package com.brs.idm.rest.api.role;

import com.brs.idm.api.IdmIdentityService;
import com.brs.idm.api.dto.RoleRepresentation;
import com.brs.idm.persistence.entity.RoleEntity;
import com.brs.idm.rest.dto.RoleUserMappingDto;
import com.brs.sys.common.model.RestResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@RestController
public class RoleController {
    @Autowired
    private IdmIdentityService identityService;


    /**
     * get all role list
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "get all role list")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/idm/role")
    public RestResult getPrivilegeAll(@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        PageHelper.startPage(page,size );
        List<RoleRepresentation> list = identityService.getRoleAll();
        PageInfo pageInfo = new PageInfo(list);
        return new RestResult(200, "get all role list success", pageInfo);
    }

    /**
     * add new role
     * @param role
     * @return
     */
    @ApiOperation(value = "add new role")
    @PostMapping("/api/idm/role")
    public RestResult createNewRole(@RequestBody RoleEntity role) {
        identityService.saveRole(role);
        return new RestResult(2000, "add new role success！");
    }

    /**
     * edit role
     * @param role
     * @return
     */
    @ApiOperation(value = " edit role")
    @PatchMapping("/api/idm/role")
    public RestResult editRole(@RequestBody RoleEntity role){
        identityService.updateRole(role);
        return new RestResult(2000,"edit role success" );
    }

    /**
     *delete role
     * @param roleId
     * @return
     */
    @ApiOperation(value = "delete role")
    @DeleteMapping("/api/idm/role/{roleId}")
    public RestResult deleteRole(@PathVariable("roleId")String  roleId){
        identityService.deleteRole(roleId);
        return new RestResult(2000, "delete role success！");
    }

    @PostMapping("/api/idm/roleBindUsers")
    public RestResult bindUsers(@RequestBody RoleUserMappingDto roleUserMappingDto){
         identityService.addUserRoleMapping(roleUserMappingDto.getUserIds(), roleUserMappingDto.getRoleId());
         return new RestResult(2000,"bind user array success" );
    }

}
