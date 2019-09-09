package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @auther likeyu
 * @create 2019-09-09-9:03
 **/
@Component
public class BaseClientImpl implements BaseClient {

    @Override
    public Result findById(String labelId) {

        return new Result(false, StatusCode.ERROR, "熔断器触发");
    }
}
