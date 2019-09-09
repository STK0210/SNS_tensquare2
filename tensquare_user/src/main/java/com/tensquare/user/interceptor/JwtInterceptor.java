package com.tensquare.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther likeyu
 * @create 2019-09-07-16:31
 **/

@Component//注入容器
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    //校验权限是在操作执行前进行拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了JwtInterceptor拦截器");
        //无论如何都放行，具体的操作放到具体的操作中判断
        //拦截器只负责把请求头中包含token的令牌进行解析。
        //并把相关的role存入request中
        String header = request.getHeader("Authorization");//约定存放到头的key
        if (header != null && !"".equals(header)) {
            //如果有header,就解析
            if (header.startsWith("Bearer ")) {
                //如果有前缀，就解析
                String token = header.substring(7);
                //对令牌进行验证
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null) {
                        if (roles.indexOf("admin") > 0) {
                            //判别角色直接从request中取claims_admin，拿到了就有该角色
                            request.setAttribute("claims_admin", token);
                        }
                        if (roles.indexOf("user") > 0) {
                            request.setAttribute("claims_user", token);
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("令牌错误！");
                }
            }
        }
        return true;
    }

}
