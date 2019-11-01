package com.keepmoving.fitness.controller.userInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController{

//    /**
//     * 课程列表的入口    /plan
//     * @return
//     */
//    @RequestMapping("/plan")
//    public String course(){
//        return "plan/course-list";
//    }


    /**
     * 基本信息修改入口   /per1
     * @return
     */
    @RequestMapping("/per2")
    public String per1(){
        return "person/person-info-profile";
    }

    /**
     * 身高体重入口    /per2
     * @return
     */
    @RequestMapping("/per1")
    public String per2(){
        return "person/person-info-fitness";
    }

    /**
     * 账号设置 更改密码入口    /per3
     * @return
     */
    @RequestMapping("/per3")
    public String per3(){
        return "person/person-info-settings";
    }


}
