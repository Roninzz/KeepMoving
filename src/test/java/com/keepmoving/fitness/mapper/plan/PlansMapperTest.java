package com.keepmoving.fitness.mapper.plan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlansMapperTest {
    @Autowired
    private PlansMapper plansMapper;

    @Test
    public void testFindAll() {
        System.out.println(plansMapper.findAll(null,null,null,null,null,null));
    }

    @Test
    public void testFindById(){
        System.out.println(plansMapper.findById(1));
    }

    @Test
    public void testGetIntroductionById(){
        System.out.println(plansMapper.getPlanIntroductionById(1));
    }

    @Test
    public void testFindByPlanNum(){
        System.out.println(plansMapper.findByPlanNum());
    }

    @Test void testFindByAll(){
        System.out.println(plansMapper.findByAll());
    }
}
