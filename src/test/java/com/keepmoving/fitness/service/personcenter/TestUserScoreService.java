package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.service.impl.personcenter.UserScoreServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户评分的service层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserScoreService {

    @Autowired
    private UserScoreServiceImpl userScoreService;

    /**
     * 测试根据用户id查询用户的评分信息
     */
    @Test
    public void testGetUserScoreByUserId(){
        System.out.println(userScoreService.getUserScoreByUserId((long) 1));
    }

    @Test
    public void testFindAllUserScore(){
        System.out.println(userScoreService.findAllUserScoreByPlanId(1));
    }
}
