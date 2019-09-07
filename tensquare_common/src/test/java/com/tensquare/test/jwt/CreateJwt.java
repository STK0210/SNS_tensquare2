package com.tensquare.test.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @auther likeyu
 * @create 2019-09-07-12:19
 **/
public class CreateJwt {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("admin")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"LRKLY")
                .setExpiration(new Date(new Date().getTime()+60000))//1分钟的过期时间
                .claim("role","admin");
        System.out.println(jwtBuilder.compact());
    }

}
