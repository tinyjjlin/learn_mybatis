package com.brs.idm.api.dto;

import lombok.Data;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@Data
public class LoginUserDto {
    private String loginName;
    private String loginPwd;
}
