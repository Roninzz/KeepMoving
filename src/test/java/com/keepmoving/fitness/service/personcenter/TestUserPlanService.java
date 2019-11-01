package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.entity.personcenter.UserPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户计划service层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserPlanService {
    @Autowired
    private IUserPlanService userPlanService;

    @Autowired
    private UserPlan userPlan;

    /**
     * 测试用户正在参加的训练计划
     */
    @Test
    public void testFindUserAllPlanByUserId(){
        System.out.println(userPlanService.findUserAllPlanByUserId((long) 2));
    }

    /**
     * 测试用户已经参加过的训练计划
     */
    @Test
    public void testFindUserPlanRecordByUserId(){
        userPlanService.findUserPlanRecordByUserId(1184456049227337728L).forEach(System.out::println);
    }

    /**
     * 测试用户取消的训练计划
     */
    @Test
    public void testUpdateUserCancelPlan(){
        userPlan.setUserId((long) 1);
        userPlan.setAddTime(new Date(2019,2,3));
        userPlanService.updateUserCancelPlan(userPlan);
    }

    /**
     * 测试用户完成的训练计划
     */
    @Test
    public void testUpdateUserCompletePlan(){
        userPlan.setUserId((long) 1);
        userPlan.setAddTime(new Date(2019,2,3));
        userPlanService.updateUserCompletePlan(userPlan);
    }

    /**
     * 测试添加用户的训练计划
     */
    @Test
    public void testSaveUserPlan(){
        userPlan.setUserId((long) 1);
        userPlan.setPlanId(4);
        userPlan.setAddTime(new Date(2019,2,3));
        userPlan.setPlanType(1);
        userPlanService.saveUserPlan(userPlan);
    }




}
