package com.brs.sys.common.service;

import com.brs.idm.api.dto.LoginUserDto;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
public interface AdService {
    /**
     * 登录用户认证
     * @param loginUserDto
     * @return
     * @throws Exception
     */
    public Boolean authentication(LoginUserDto loginUserDto)throws Exception;

    /**
     * ldap 检验用户名密码
     * @param userDn
     * @param password
     * @return
     */
    public Boolean loginVerify(String userDn, String password);
}
