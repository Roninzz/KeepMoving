package com.keepmoving.fitness.interceptor.config;

import com.keepmoving.fitness.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CYF;
 * @date 2019/10/12.   拦截器配置类
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer{


    //    将自定义拦截器注入
    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
    * 方法实现说明    用来配置静态资源
    * @author
    * @return
    * @exception
    * @date        2019/10/12 8:57
    */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    /**
    * 方法实现说明  用来注册拦截器
    * @author
    * @return
    * @exception
    * @date        2019/10/12 8:58
    */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加需要拦截的路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/person/**");
                //添加不需要拦截的路径
//                .excludePathPatterns(Arrays.asList("/registerAct","/loginAct","/goMap","/index/hello"))
//                .excludePathPatterns("/static/**");
    }
}
