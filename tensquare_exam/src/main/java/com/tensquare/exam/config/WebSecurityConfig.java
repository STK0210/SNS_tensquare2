package com.tensquare.exam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * 使用springSecurity时，不使用其本身的拦截器，放行用的
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests，所有security全注解配置实现的开端，表示开始说明需要的权限
        //需要的权限分2部分，第一部分是拦截的路径，第二部分是访问该路径需要的权限
        //antMatchers表示拦截的路径，permitAll任何权限都可访问，直接全部放行
        //因为拦截方面不需要security来做，只需要security的加盐加密算法。
        //anyRequest()任何的请求，authenticated()认证后可访问
        //and().csrf().disable()固定写法，表示是csrf拦截失效，
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
