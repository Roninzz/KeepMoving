package com.keepmoving.fitness.service.calender;

import com.keepmoving.fitness.service.impl.calender.PlanDescriptionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanDescriptionService {

    @Autowired
    private PlanDescriptionServiceImpl descriptionService;

    /**
     * 测试service成从mapper层获取根据计划id查询出来的计划描述
     */
    @Test
    public void testPlanDescriptionImpl(){
        System.out.println(descriptionService.getPlanDescriptionByPlanId(2));
    }
}
