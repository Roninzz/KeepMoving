package com.keepmoving.fitness.controller.userInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.service.impl.login.UserInfoServiceImpl;
import com.keepmoving.fitness.service.login.IUserInfoService;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;

@Controller
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IUserBaseInfoService baseInfoService;
    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserBaseInfo")
    @ResponseBody
    public UserBaseInfo getUserBaseInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        return baseInfoService.findByUserId(userInfo.getUserId());
    }
    /**
     * 修改基础信息(个人信息)
     * @param baseInfo
     * @return
     */
    @RequestMapping("/editUserByUserId")
    @ResponseBody
    public Long editUserByUserId(UserBaseInfo baseInfo){
        return baseInfoService.editUserByUserId(baseInfo);
    }

    /**
     * 修改基础信息(身体素质)
     * @param baseInfo
     * @return
     */
    @RequestMapping("/editAllByUserId")
    @ResponseBody
    public Long editAllByUserId(UserBaseInfo baseInfo){
        return baseInfoService.editAllByUserId(baseInfo);
    }

    /**
     * 修改userinfo表中信息
     * @param baseInfo
     * @return
     */

    @RequestMapping("/editByUserId")
    @ResponseBody
    public Long ediByUserId(UserBaseInfo baseInfo){
        return baseInfoService.editByUserId(baseInfo);
    }

}
