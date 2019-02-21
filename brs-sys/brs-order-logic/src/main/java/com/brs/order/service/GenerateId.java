package com.brs.order.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@Service
public class GenerateId {

    public String generate(){
        return "njbrs"+new Random().nextInt(1000000)+1;
    }
    public static void main(String[]args){
       String id = new GenerateId().generate();
       System.out.println(id);
    }
}
