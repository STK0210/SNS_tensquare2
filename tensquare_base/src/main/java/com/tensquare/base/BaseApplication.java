package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @auther likeyu
 * @create 2019-08-30-19:47
 **/
@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    @Bean//让返回值在容器中
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
