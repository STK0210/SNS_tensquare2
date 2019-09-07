package com.tensquare.test.jwt;

/**
 * @auther likeyu
 * @create 2019-09-07-16:00
 **/
public class ContainsTest {

    public static void main(String[] args) {
        String source = "admin,user,visitor";
        System.out.println(source.contains("usrr"));
        System.out.println(source.contentEquals("user"));
    }

}
