package com.tensquare.friend.controller;

import com.tensquare.friend.client.UserClient;
import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther likeyu
 * @create 2019-09-08-14:00
 **/
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserClient userClient;

    /**
     * 添加好友或者添加非好友
     *
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}", method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        //验证是否登录，并拿到当前登录的id
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null) {
            //没有user角色的令牌
            return new Result(false, StatusCode.LOGINERROR, "没有user权限");
        }
        String userid = claims.getId();
        //判断是添加好友还是非好友
        if (type != null) {
            if (type.equals("1")) {
                //添加好友
                int flag = friendService.addFriend(userid, friendid);
                if (flag == 0) {
                    return new Result(false, StatusCode.ERROR, "不能重复添加好友");
                }
                if (flag == 1) {
                    userClient.updateFollowcountAndFanscount(userid, friendid, 1);
                    return new Result(true, StatusCode.OK, "添加好友成功");
                }
            } else if (type.equals("2")) {
                //添加非好友
                int flag = friendService.addNoFriend(userid, friendid);
                if (flag == 0) {
                    return new Result(false, StatusCode.ERROR, "不能重复添加不感兴趣好友");
                }
                if (flag == 1) {
                    return new Result(true, StatusCode.OK, "添加不感兴趣好友成功");
                }
            } else {
                return new Result(false, StatusCode.ERROR, "参数异常");
            }
        } else {
            return new Result(false, StatusCode.ERROR, "缺乏参数");
        }
        return new Result(false, StatusCode.ERROR, "格式错误");
    }

    /**
     * 删除好友
     * @return
     */
    @RequestMapping(value = "/{friendid}", method = RequestMethod.DELETE)
    public Result deleteFriend(@PathVariable String friendid){
        //验证是否登录，并拿到当前登录的id
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null) {
            //没有user角色的令牌
            return new Result(false, StatusCode.LOGINERROR, "没有user权限");
        }
        //得到当前登录的用户的id
        String userid = claims.getId();
        friendService.deleteFriend(userid,friendid);//从好友表中删除数据
        userClient.updateFollowcountAndFanscount(userid,friendid,-1);//关注和粉丝都减1
        return new Result(true,StatusCode.OK,"删除好友成功");
    }

}
