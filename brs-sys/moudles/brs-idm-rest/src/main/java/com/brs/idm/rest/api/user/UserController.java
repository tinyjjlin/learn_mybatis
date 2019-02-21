package com.brs.idm.rest.api.user;

import com.brs.idm.api.IdmIdentityService;
import com.brs.idm.api.dto.LoginUserInfoRepresentation;
import com.brs.idm.api.dto.LoginUserRepresentation;
import com.brs.idm.persistence.entity.UserEntity;
import com.brs.sys.common.model.RestResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/20
 */
@RestController
@Api
public class UserController {

    @Autowired
    private IdmIdentityService identityService;


    /**
     * get all user list
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "get all user list")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页显示的数据行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/api/idm/user")
    public RestResult getUserAll(@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "limit",required = false, defaultValue = "10") Integer size) {
        PageHelper.startPage(page,size );
        List<LoginUserRepresentation> list = identityService.getUserAll();
        PageInfo pageInfo = new PageInfo(list);
        return new RestResult(2000, "get all user list success", pageInfo);
    }

    /**
     * add new user
     * @param userEntity
     * @return
     */
    @ApiOperation("add new user")
    @PostMapping("/api/idm/user")
    public RestResult  createNewUser(@RequestBody UserEntity userEntity){
        identityService.saveUser(userEntity);
        return new RestResult(2000, "add new user",null);
    }




}
