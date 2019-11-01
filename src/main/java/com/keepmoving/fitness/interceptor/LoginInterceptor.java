package com.keepmoving.fitness.interceptor;

import com.keepmoving.fitness.entity.login.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CYF;
 * @date 2019/10/12.     自定义登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //在Controller方法执行前被执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

        //如果用户为登录，拦截
        if (userInfo == null){
            //重定向到登录action
            response.sendRedirect(request.getContextPath() + "/loginAct");
            return false;
        }else {
            //如果登录了，放行
            return true;
        }

    }

}
