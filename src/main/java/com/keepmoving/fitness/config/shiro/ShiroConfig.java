package com.keepmoving.fitness.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author CYF;
 * @date 2019/10/11.  shiro配置类
 */
//@Configuration
public class ShiroConfig {

    //1.创建ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器，可以实现权限相关的拦截
        //   常用的过滤器
        //   anon:无需认证（登录）可以访问
        //   authc：必须认证才可以访问
        //   user:如果使用rememberMe的功能可以直接访问
        //   perms:该资源必须得到资源权限才可以访问
        //   role:该资源必须得到角色权限才可以访问

        Map<String,String> filterMap = new LinkedHashMap<>();

        //拦截指定请求
//        filterMap.put("/goadd","authc");
//        filterMap.put("/goupdate","authc");

        //不拦截某些请求
        filterMap.put("/gotest","anon");
        filterMap.put("/shiroLogin","anon");

//        授权过滤器   这里授权的位置要放在下面的拦截所有的上面
//        注意：当授权拦截后，shiro会自动跳转到未授权页面
        filterMap.put("/goadd","perms[user:add]"); //此处第二个参数为授权字符串，应与数据库中值保持一致

        //拦截所有请求
        filterMap.put("/*","authc");

        //修改拦截后跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/golanjie");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    //2.创建DefaultWebSecurityManager
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //3.创建Realm
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
