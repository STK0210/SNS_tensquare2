package com.tensquare.test.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @auther likeyu
 * @create 2019-09-07-13:50
 **/
public class ParseJwt {

    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("LRKLY").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJhZG1pbiIsImlhdCI6MTU2NzgzNjI1OSwiZXhwIjoxNTY3ODM2MzE5LCJyb2xlIjoiYWRtaW4ifQ.ANAPMuzv_-SIhlcvkjrH1_RY9UdyS6GEpSoXigRbfzQ").getBody();
        System.out.println("用户id:" + claims.getId());
        System.out.println("用户名:" + claims.getSubject());
        System.out.println("登录时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色:" + claims.get("role"));
    }

}
