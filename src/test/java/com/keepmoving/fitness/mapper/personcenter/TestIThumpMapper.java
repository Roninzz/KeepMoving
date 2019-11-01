package com.keepmoving.fitness.mapper.personcenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 测试点赞的mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIThumpMapper {

    @Autowired
    private IThumpMapper thumpMapper;

    /**
     * 测试所有的点赞信息
     */
    @Test
    public void testFindThumpNum(){
        System.out.println(thumpMapper.findThumpNumByPlanIdMapper(2));
    }


    /**
     * 测试当用户点赞计划之后,对应的点赞数加1
     */
    @Test
    public void testAddThumpNum(){
        thumpMapper.addThumpNum(1);
        // 查看点赞数量是否变化
        System.out.println(thumpMapper.findThumpNumByPlanIdMapper(1));
    }

}
