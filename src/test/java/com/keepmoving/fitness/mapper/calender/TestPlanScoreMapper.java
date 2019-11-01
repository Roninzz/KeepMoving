package com.keepmoving.fitness.mapper.calender;

import com.keepmoving.fitness.entity.calender.PlanScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 测试计划评分mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanScoreMapper {

    @Autowired
    private PlanScoreMapper scoreMapper;

    @Autowired
    private PlanScore planScore;

    @Test
    public void testGetPlanScoreByPlanId(){
        System.out.println(scoreMapper.getPlanScoreByPlanId(1));
    }

//    @Test
//    public void testUpdatePlanScore(){
//        planScore.setId(2);
//        planScore.setScore(4.9);
//        scoreMapper.updatePlanScore(planScore);
//    }

    @Test
    public void testFindAllPlanScore(){
        scoreMapper.findAllPlanScore().forEach(System.out::println);
    }

}
