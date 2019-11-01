package com.keepmoving.fitness.mapper.personcenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description:测试用户评分的mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIUserScoreMapper {

    @Autowired
    private IUserScoreMapper userScoreMapper;

    /**
     * 测试每个用户对计划的评分
     */
    @Test
    public void testGetUserScoreByUserId(){
        System.out.println(userScoreMapper.getUserScoreByUserId((long) 1));
    }

    /**
     * 测试每个计划的用户评分
     */
    @Test
    public void testFindAllUserScore(){
        userScoreMapper.findAllUserScoreByPlanId(1).forEach(System.out::println);
    }
}
