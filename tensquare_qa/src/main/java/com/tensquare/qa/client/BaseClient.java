package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 服务间相互调用
 * 主动调用方提供此接口
 *
 * @auther likeyu
 * @create 2019-09-08-11:09
 **/
@FeignClient(value = "tensquare-base", fallback = BaseClientImpl.class)//不支持下划线_,出问题回来执行实现类
public interface BaseClient {

    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)//注意添加controller层前缀
    public Result findById(@PathVariable("labelId") String labelId);//必须确保Pathvariable和value占位符内内容一致

}
