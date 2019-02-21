package com.brs.order.rest.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tiny lin
 * @date 2019/2/20
 */

@SpringBootApplication(scanBasePackages = {"com.brs.order","com.brs.sys.common"})
@MapperScan("com.brs.order.persistence.mapper")
@EnableConfigurationProperties
@EnableTransactionManagement
public class WebApplication {
    public static void main(String[]args){
        SpringApplication.run(WebApplication.class,args);
    }
}
