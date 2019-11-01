package com.keepmoving.fitness;

import com.keepmoving.fitness.mapper.login.UserInfoMapper;
import com.keepmoving.fitness.service.login.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FitnessApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private IUserInfoService userInfoService;
    @Test
    public void contextLoads() {

//        System.out.println(userInfoMapper.findAll());
//        System.out.println(userInfoMapper.findByPhone("18806203574"));
        System.out.println(userInfoService.findAll());
        System.out.println("======");
        System.out.println(userInfoService.findByPhone("18806203574"));
    }

}
