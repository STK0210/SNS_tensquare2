package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther likeyu
 * @create 2019-08-31-9:23
 **/
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        System.out.println("BaseExceptionHandler："+e.getMessage());
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
