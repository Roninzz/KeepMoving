package com.keepmoving.fitness.service.plans;

import com.keepmoving.fitness.service.plan.IPlansService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlansServiceTests {

    @Autowired
    private IPlansService plansService;

    @Test
    public void contextLoads() {
        System.out.println(plansService.findAll(null,null,null,null,null,null,2,1));
    }

    @Test
    public void testFindById(){
        System.out.println(plansService.findById(1));
    }

}
