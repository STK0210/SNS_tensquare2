package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther likeyu
 * @create 2019-09-09-19:45
 **/
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    //过滤器类型，在请求pre先，post后执行
    @Override
    public String filterType() {
        return "pre";//之前进行过滤
    }

    //过滤器的级别，数字越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //当前过滤器是否开启，true为开启
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器内执行的操作，return object的值都表示继续执行，只有遇到setsendzullResponse(false)才不执行
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过后台Zuul过滤器");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //转发的请求有2次，第一次的路径选择直接放行
        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }

        //如果本身就是登陆操作，那么也直接放行，允许其获取令牌
        String url = request.getRequestURI();
        if (url.indexOf("/admin/login") > 0) {
            System.out.println("登陆操作" + url);
            return null;
        }

        String header = request.getHeader("Authorization");
        if (header != null && !"".equals(header)) {
            if (header.startsWith("Bearer ")) {
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null) {
                        if (roles.contains("admin")) {
                            //双层验证，更加安全
                            currentContext.addZuulRequestHeader("Authorization", header);
                            return null;
                        }
                    }
                } catch (Exception e) {
                    //终止运行
                    currentContext.setSendZuulResponse(false);
                    throw new RuntimeException("后台网关令牌错误\n" + e.getMessage());
                }
            }
        }
        //任何非正常情况都会执行到这里，终止运行
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(403);//401，403都属于权限不足，但403属于springSecurity
        currentContext.setResponseBody("后台网关：权限不足！");
        currentContext.getResponse().setContentType("text/html;charset=utf-8");
        return null;
    }
}
