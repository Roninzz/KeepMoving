package com.keepmoving.fitness.login;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.mapper.login.UserInfoMapper;
import com.keepmoving.fitness.service.login.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private IUserInfoService userInfoService;
    @Test
    public void contextLoads() {

//      System.out.println(userInfoMapper.findAll());
//      System.out.println(userInfoMapper.findByPhone("18806203574"));

        System.out.println("======");
//        System.out.println(userInfoService.findAll());
//        System.out.println(userInfoService.findByPhone("18806203574"));
        UserInfo userInfo = new UserInfo();

        userInfo.setUsername("杰克");
        userInfo.setPassword("12345");
        userInfo.setPhone("18002020306");

        userInfoService.addUserInfo(userInfo);

    }

}
