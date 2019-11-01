package com.keepmoving.fitness.service.calender;

import com.keepmoving.fitness.service.impl.calender.TrainServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划安排测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTrainArangerService {

    @Autowired
    private TrainServiceImpl trainService;

    /**
     * 测试根据计划id查询具体的计划安排
     */
    @Test
    public void testGetTitleByPlanId(){
        System.out.println(trainService.getTitleByPlanId(2));
    }
}
