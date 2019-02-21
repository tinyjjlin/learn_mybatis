package com.brs.idm.service;

import com.brs.idm.api.IdmIdentityService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tiny lin
 * @date 2019/2/20
 */

public class AbstractIdmService {
    @Autowired
    protected IdmIdentityService identityService;
}
