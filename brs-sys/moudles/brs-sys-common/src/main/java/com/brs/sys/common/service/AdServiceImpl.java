package com.brs.sys.common.service;


import com.brs.idm.api.dto.LoginUserDto;
import com.brs.sys.common.service.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.naming.directory.DirContext;


/**
 * @author tiny lin
 * @date 2018/12/4
 */
@Service
public class AdServiceImpl implements AdService {

    @Value("${ldap.domainName}")
    private String ldapDomainName;

    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public Boolean authentication(LoginUserDto loginUserDto) throws Exception {
        String userDn = loginUserDto.getLoginName() + ldapDomainName;
        //step 1: 请求字段不为空
        if (StringUtils.isEmpty(loginUserDto.getLoginName()) || StringUtils.isEmpty(loginUserDto.getLoginPwd())) {
            throw new CustomException("用户名或密码为空！");
        }
        //step 2: ldap 验证
        if( !loginVerify(userDn, loginUserDto.getLoginPwd())){
            throw new CustomException("用户名或密码错误！");
        }
        return true;
    }

    @Override
    public Boolean loginVerify(String userDn, String password) {
        System.out.println("ldapLoginVerify -->userDn:.........."+userDn);
        System.out.println("ldapLoginVerify -->password:.........."+password);
        DirContext dirContext = null;
        try {
            dirContext = ldapTemplate.getContextSource().getContext(userDn, password);
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        } finally {
            LdapUtils.closeContext(dirContext);
        }
    }
}
