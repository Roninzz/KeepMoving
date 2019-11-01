package com.keepmoving.fitness.service.impl.personcenter;

import com.keepmoving.fitness.entity.personcenter.UserPlan;
import com.keepmoving.fitness.mapper.personcenter.IUserPlanMapper;
import com.keepmoving.fitness.service.personcenter.IUserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Kenny
 * @version:1.0
 * @description:
 */
@Service
public class UserPlanServiceImpl implements IUserPlanService {

    @Autowired
    private IUserPlanMapper userPlanMapper;

    /**
     * 用户正在参与的所有训练计划 plan_status = 0
     * @param uid 用户id
     * @return
     */
    @Override
    public UserPlan findUserAllPlanByUserId(Long uid) {
        return userPlanMapper.findUserAllPlanByUserId(uid);
    }

    /**
     * 用户参过的所有训练计划记录 plan_status = 1
     * @param uid  用户id
     * @return
     */
    @Override
    public List<UserPlan> findUserPlanRecordByUserId(Long uid) {
        return userPlanMapper.findUserPlanRecordByUserId(uid);
    }

    /**
     *  当用户取消训练计划时,后台将状态码更新为 2
     * @param userPlan 用户计划实体类
     */
    @Override
    public void updateUserCancelPlan(UserPlan userPlan) {
        userPlanMapper.updateUserCancelPlan(userPlan);
    }

    /**
     * 当用户完成训练计划之后,后台将对应的状态码设置为 1
     * @param userPlan 用户计划实体类
     */
    @Override
    public void updateUserCompletePlan(UserPlan userPlan) {
        userPlanMapper.updateUserCompletePlan(userPlan);
    }

    /**
     * 用户添加完训练计划,将计划进行存储
     * @param userPlan 用户的训练计划实体类
     */
    @Override
    public void saveUserPlan(UserPlan userPlan) {
        userPlanMapper.saveUserPlan(userPlan);
    }
}
