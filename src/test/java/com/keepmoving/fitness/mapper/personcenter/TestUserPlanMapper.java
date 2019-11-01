package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personcenter.UserPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户计划的mapper层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserPlanMapper {

    @Autowired
    private IUserPlanMapper userPlanMapper;

    @Autowired
    private UserPlan userPlan;

    /**
     * 测试用户正在参加的训练计划
     */
    @Test
    public void testFindUserAllPlanByUserId(){
        System.out.println(userPlanMapper.findUserAllPlanByUserId(1L));
    }

    /**
     * 测试用户已经参加过的训练计划
     */
    @Test
    public void testFindUserPlanRecordByUserId(){
        userPlanMapper.findUserPlanRecordByUserId(1L).forEach(System.out::println);
    }

    /**
     * 测试用户取消的训练计划
     */
    @Test
    public void testUpdateUserCancelPlan(){
        userPlan.setUserId((long) 1);
        userPlan.setAddTime(new Date(2019,2,3));
        userPlanMapper.updateUserCancelPlan(userPlan);
    }

    /**
     * 测试用户完成的训练计划
     */
    @Test
    public void testUpdateUserCompletePlan(){
        userPlan.setUserId((long) 1);
        userPlan.setAddTime(new Date(2019,2,3));
        userPlanMapper.updateUserCompletePlan(userPlan);
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
        userPlanMapper.updateUserCancelPlan(userPlan);
    }


}
