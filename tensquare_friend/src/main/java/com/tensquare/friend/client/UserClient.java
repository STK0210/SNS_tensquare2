package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther likeyu
 * @create 2019-09-08-17:00
 **/
@FeignClient("tensquare-user")
public interface UserClient {

    @RequestMapping(value = "/user/{userid}/{friendid}/{change}", method = RequestMethod.PUT)
    public void updateFollowcountAndFanscount(@PathVariable("userid") String userid, @PathVariable("friendid") String friendid, @PathVariable("change") int change);

}
