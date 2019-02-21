package com.brs.idm.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tiny lin
 * @date 2019/2/20
 */

@SpringBootApplication(scanBasePackages = {"com.brs.idm","com.brs.sys.common"})
@MapperScan("com.brs.idm.persistence.dao")
@EnableConfigurationProperties
@EnableTransactionManagement
public class WebApplication {
    public static void main(String[]args){
        SpringApplication.run(WebApplication.class,args);
    }
}
