package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 昊洋
 * @date:2020-07-18 0:49
 * @description: SecurityConfig
 * @version: 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   //定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页可访问，功能页需要权限才可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
         //没有权限就到登录页面
        //用户名 和密码默认是  username  password
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd")
                                              .loginProcessingUrl("/login");
        //开启自动配置的注销的功能
        // .logoutSuccessUrl("/"); 注销成功来到首页
        http.csrf().disable();  //没有这一句 http.logout().logoutSuccessUrl("/");就报错
        http.logout().logoutSuccessUrl("/");
        //登录记住我
        http.rememberMe().rememberMeParameter("remember");
    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中定义，也可以在jdbc中去拿....
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");
    }
}
