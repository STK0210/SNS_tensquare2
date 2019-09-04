package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @auther likeyu
 * @create 2019-09-03-21:11
 **/
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    //用自定义id生成器
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

}
