package com.keepmoving.fitness.controller.userInfo;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.plan.CodeStatus;
import com.keepmoving.fitness.entity.plan.Result;
import com.keepmoving.fitness.service.login.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:Kenny
 * @version:1.0
 * @description:用户密码登录
 */
@Controller
@RequestMapping("/user")
public class PasswordLoginController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @RequestMapping("/login")
    public String passwordLogin(){
        return "/user/loginpassword";
    }

    @ResponseBody
    @RequestMapping("/checkLogins")
    public Result checkLogin(@RequestParam String tel, @RequestParam String pwd){
        UserInfo userInfo = userInfoService.findByPhone(tel);
        if (userInfo != null){
            //获取其数据库中加密的密码
            String password1 = userInfo.getPassword();
            //判断前台输入密码与加密后的密码是否匹配
            if (passwordEncoder.matches(pwd,password1)){
                return new Result(CodeStatus.OK,true,"密码验证成功");
            }else {
                //否则返回登录页面
                return new Result(CodeStatus.OK,false,"密码验证失败");
            }
        }
        return new Result(CodeStatus.OK,false,"密码验证失败");
    }



}
