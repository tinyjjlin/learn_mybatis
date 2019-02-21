package com.brs.idm.rest.api.login;
import com.brs.idm.api.IdmIdentityService;
import com.brs.idm.api.dto.LoginUserDto;
import com.brs.idm.api.dto.LoginUserInfoRepresentation;
import com.brs.sys.common.annotation.Authentication;
import com.brs.sys.common.jwt.JwtSupport;
import com.brs.sys.common.model.RestResult;
import com.brs.sys.common.model.TokenModel;
import com.brs.sys.common.service.AdService;
import com.brs.sys.common.service.ITokenService;
import com.brs.sys.common.util.CommonUtil;
import com.brs.sys.common.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tiny lin
 * @date 2018/11/29
 */
@RestController
@Api
public class LoginController {
    private final static String USER_TYPE_CLIENT ="client";
    private final static String USER_TYPE_STAFF = "staff";
    static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AdService ldapService;
    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IdmIdentityService identityService;


    @PostMapping("/api/idm/client/login")
    @ApiOperation(value = "client login")
    public RestResult clientLogin(HttpServletRequest request, @RequestBody  LoginUserDto loginUserDto){
        LoginUserInfoRepresentation loginUserInfo = identityService.getLoginUserInfo(loginUserDto.getLoginName());
       if(loginUserInfo != null){
           return new RestResult(2000,"client login success" );
       }else{
           return new RestResult(40001,"client login failed" );
       }
    }

    @PostMapping("/api/idm/staff/login")
    @ApiOperation(value = "brs staff login")
    public RestResult login(HttpServletRequest request, @RequestBody  LoginUserDto loginUserDto){
        try {
            // step1: ldap 用户认证
            ldapService.authentication(loginUserDto);
            //step2 :验证工号存在
            Integer empNo = CommonUtil.getEmpNo(loginUserDto.getLoginName());
            if(empNo == null){
                return new RestResult(4001, "登录账号必须是姓名首字母+工号！", null);
            }
            //step3:验证mysql用户是否创建
            if( identityService.getLoginUserInfo(empNo+"") == null){
                return new RestResult(4001, "新员工没有在系统中注册！", null);
            }
            //step4:生成token
            TokenModel tokenModel = tokenService.generateToken(loginUserDto.getLoginName(),empNo);
            //step5:保持用户的登录ip地址

            return new RestResult(200, "登录成功!", tokenModel);
        } catch (Exception e) {
            return new RestResult(4001, e.getMessage(),null);
        }
    }

    @GetMapping("/api/idm/logout")
    @ApiOperation(value = "logout")
    @Authentication
    public RestResult logout(@RequestHeader("Authorization")String token){
        String loginName = JwtSupport.getLoginName(token);
        tokenService.deleteToken(loginName);
        return new RestResult(2000, "退出操作成功!");
    }

    /**
     * login user info
     * @param userId
     * @return
     */
    @ApiOperation("get login user info")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "登录账号", dataType = "string")
    })
    @GetMapping("/api/idm/userInfo")
    public RestResult  getLoginUserInfo(@RequestParam("userId")String userId){
        LoginUserInfoRepresentation loginUserDto = identityService.getLoginUserInfo(userId);
        if(loginUserDto != null){
            return new RestResult(2000,"get login user inf success",loginUserDto );
        }else{
            return new RestResult(4001, "get login user inf failed");
        }
    }

    @PostMapping("/api/idm/loginValidation")
    @ApiOperation("login validation")
    public RestResult loginValidation(HttpServletRequest request, @RequestBody LoginUserDto loginDto){
        if(loginDto == null || StrUtil.isNUll(loginDto.getLoginName())){
            return new RestResult(250, "该账号没有登录！",null);
        }
        if(!tokenService.loginValidation(loginDto.getLoginName())){
            return new RestResult(250, "该账号没有登录", null);
        }else{
            Integer empNo = CommonUtil.getEmpNo(loginDto.getLoginName());
            String loginAddress = "";
            return new RestResult(451, "该账号"+loginDto.getLoginName()+"已经在"+loginAddress+"登录,是否继续登录？", null);
        }
    }

}