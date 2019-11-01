package com.keepmoving.fitness.mapper.calender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 测试计划安排
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTrainArangeMapper {

    @Autowired
    private TrainArangeMapper trainArangeMapper;

    @Test
    public void testGetTitleByPlanId(){
        System.out.println(trainArangeMapper.getTitleByPlanId(1));
    }

}
