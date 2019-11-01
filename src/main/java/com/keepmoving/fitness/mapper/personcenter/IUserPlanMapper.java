package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personcenter.UserPlan;
import com.keepmoving.fitness.entity.plan.Plans;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户参与的计划mapper
 */
public interface IUserPlanMapper {

    /**
     * 用户正在参与的所有训练计划 plan_status = 1
     * @param uid 用户id
     * @return
     */
    @Select("select user_id,plan_id,add_time,plan_status,plan_type,end_time from user_plan " +
            "where user_id = #{uid} and plan_status = 1")
    UserPlan findUserAllPlanByUserId(Long uid);

    /**
     * 用户参过的所有训练计划记录 plan_status = 2
     * @param uid  用户id
     * @return
     */
    @Select("select user_id,plan_id,add_time,plan_status,plan_type,end_time from user_plan " +
            "where user_id = #{uid} and plan_status = 2")
    List<UserPlan> findUserPlanRecordByUserId(Long uid);

    /**
     *  当用户取消训练计划时,后台将状态码更新为 2
     * @param userPlan 用户计划实体类
     */
    @Update("update user_plan set plan_status = 0 where user_id = #{userId}")
    void updateUserCancelPlan(UserPlan userPlan);

    /**
     * 当用户完成训练计划之后,后台将对应的状态码设置为 1
     * @param userPlan 用户计划实体类
     */
    @Update("update user_plan set plan_status = 1 where user_id = #{userId}")
    void updateUserCompletePlan(UserPlan userPlan);

    /**
     * 用户添加完训练计划,将计划进行存储
     * @param userPlan 用户的训练计划实体类
     */
    @Insert("insert into user_plan(user_id,plan_id,add_time,plan_status,plan_type,end_time) values (" +
            "#{userId},#{planId},#{addTime},#{planStatus},#{planType},#{endTime})")
    void saveUserPlan(UserPlan userPlan);





}
