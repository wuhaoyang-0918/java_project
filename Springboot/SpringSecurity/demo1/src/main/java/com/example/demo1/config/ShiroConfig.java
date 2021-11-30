package com.example.demo1.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 昊洋
 * @date:2020-07-19 13:00
 * @description: ShiroConfig
 * @version: 1.0
 */
@Controller
public class ShiroConfig {
    //3. shiroFilterfactaryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean Bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        Bean.setSecurityManager(defaultWebSecurityManager);
        /**
         * shiro的内置过滤器
         anon：无需认证就可以访问 默认
         authc：必须认证了才能访问
         user：必须拥有记住我功能才能访问
         perms：必须拥有对某个的权限才能访问
         role：拥有某个角色权限才能访问
         */
        //添加shiro的内置过滤器  设置要拦截的url
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();//拦截
        //filterChainDefinitionMap.put("/user/add","authc");// /add请求必须认证才能访问
        //filterChainDefinitionMap.put("/user/update","authc");//del必须认证才能访问
        filterChainDefinitionMap.put("/user/add","perms[user:add]");
        filterChainDefinitionMap.put("/user/update","perms[user:update]");
        filterChainDefinitionMap.put("/user/*","authc");
        Bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        Bean.setLoginUrl("/toLogin");//没有认证后跳到的页面 设置登录的请求
        //未授权页面
        Bean.setUnauthorizedUrl("/nouth");
        //注销


        return  Bean;
    }
    //2. DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm对象  userRealm
        securityManager.setRealm(userRealm);
        return  securityManager;
    }
    //1. 创建realm对象 自定义的·类
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    /*
     * @Author  昊洋
     * @Description使用阿里巴巴数据源
     * @Date   2020/7/19 15:07
     * @Param
     * @return
     **/

  /*  @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }*/
  //整合shiroDialect：用来整合shiro-thymeleaf
  @Bean
  public ShiroDialect getshiroDialect(){
      return new  ShiroDialect();
  }
}
