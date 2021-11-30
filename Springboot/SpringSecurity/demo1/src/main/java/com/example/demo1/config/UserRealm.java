package com.example.demo1.config;

import com.example.demo1.pojo.Use;
import com.example.demo1.service.UseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 昊洋
 * @date:2020-07-19 13:12
 * @description: UserRealm
 * @version: 1.0
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UseService useService;
   //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权 doGetAuthorizationInfo");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //获取当前用户的对象
        Subject subject= SecurityUtils.getSubject();
        Use user = (Use)subject.getPrincipal();//获取用户信息
        //设置当前用户的权限
        info.addStringPermission(user.getPerms());
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //System.out.println("执行了认证 doGetAuthorizationInfo");
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        Use use = useService.queryUserByName(token.getUsername());
        if(use==null){
            //UnknownAccountException抛出异常
            return  null;
        }
        //获取用户的session
        Session session=subject.getSession();
        session.setAttribute("loginuser",use);
        //密码认证，shiro做
        return new SimpleAuthenticationInfo(use,use.getPassword(),"");
    }
}
