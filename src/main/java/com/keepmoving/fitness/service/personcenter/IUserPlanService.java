package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.entity.personcenter.UserPlan;

import java.util.List;

/**
 * 用户计划的service层
 */
public interface IUserPlanService {

    /**
     * 用户正在参与的所有训练计划 plan_status = 0
     * @param uid 用户id
     * @return
     */
    UserPlan findUserAllPlanByUserId(Long uid);

    /**
     * 用户参过的所有训练计划记录 plan_status = 1
     * @param uid  用户id
     * @return
     */

    List<UserPlan> findUserPlanRecordByUserId(Long uid);

    /**
     *  当用户取消训练计划时,后台将状态码更新为 2
     * @param userPlan 用户计划实体类
     */
    void updateUserCancelPlan(UserPlan userPlan);

    /**
     * 当用户完成训练计划之后,后台将对应的状态码设置为 1
     * @param userPlan 用户计划实体类
     */
    void updateUserCompletePlan(UserPlan userPlan);

    /**
     * 用户添加完训练计划,将计划进行存储
     * @param userPlan 用户的训练计划实体类
     */
    void saveUserPlan(UserPlan userPlan);


}
