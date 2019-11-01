package com.keepmoving.fitness.mapper.calender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划描述mapper层测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanDescriptionMapper {

    @Autowired
    private PlanDescriptionMapper descriptionMapper;

    /**
     * 测试每个计划的描述
     */
    @Test
    public void testGetPlanDescription(){
        System.out.println(descriptionMapper.getPlanDescriptionByPlanId(1));
    }

}
