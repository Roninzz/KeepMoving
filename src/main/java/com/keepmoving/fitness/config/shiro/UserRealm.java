package com.keepmoving.fitness.config.shiro;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.service.login.IUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author CYF;
 * @date 2019/10/11.   自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserInfoService userInfoService;

    /**
    * 方法实现说明  执行授权逻辑
    * @author      cyf
    * @return
    * @exception
    * @date        2019/10/11 13:43
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串,与前面配置的字符串保持一致
        info.addStringPermission("user:add");

        //到数据库查询当前登录用户的授权字符串----用户表中要有授权字符串字段
        //1.获取当前登录用户
//        Subject subject = SecurityUtils.getSubject();
//        UserInfo userInfo = (UserInfo) subject.getPrincipal();
//        //从数据库中查找
//        UserInfo dbuser = userInfoService.findByPhone(userInfo.getPhone());
//
//        //获取数据库中对象的授权字符串字段
//        info.addStringPermission(dbuser.getPerms());
//        return info;
        return null;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");


        //编写shiro判断逻辑，判断用户名和密码
//        模拟数据库中的数据
        String name = "eric";
        String password = "123456";

        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

//        UserInfo userInfo = userInfoService.findByPhone(token.getUsername());
        if (!token.getUsername().equals(name)){
//        if (userInfo == null){
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }

        //2.判断密码    第二个参数为数据库中的密码
        return new SimpleAuthenticationInfo("",password,"");
//        return new SimpleAuthenticationInfo("userInfo",userInfo.getPassword(),"");
    }
}
