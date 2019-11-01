package com.keepmoving.fitness.service.calender;

import com.keepmoving.fitness.entity.calender.PlanScore;
import com.keepmoving.fitness.service.impl.calender.PlanScoreServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 测试计划评分service层
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanScoreService {

    @Autowired
    private PlanScoreServiceImpl scoreService;

    @Autowired
    private PlanScore planScore;

    @Test
    public void testGetPlanScoreByPlanId(){
        System.out.println(scoreService.getPlanScoreByPlanId(1));
    }

//    @Test
//    public void testUpdatePlanScore(){
//        planScore.setPlanId(1);
//        scoreService.updatePlanScore(planScore);
//    }

    @Test
    public void testFindAllPlanScore(){
        scoreService.findAllPlanScore().forEach(System.out::println);
        System.out.println(scoreService.findAllPlanScore());

    }

}
