package com.keepmoving.fitness.entity.personcenter;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kenny
 * @version 1.0
 * @description 用户计划实体类
 */

@Component
public class UserPlan implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 计划id
     */
    private Integer planId;

    /**
     * 添加计划的时间
     */
    private Date addTime;

    /**
     * 计划结束时间
     */
    private Date endTime;


    /**
     * 计划状态 0 - 正在进行的训练计划  1 - 完成的计划  2- 用户取消的训练计划
     */
    private Integer planStatus;

    /**
     * 计划类型 0 - 免费计划 1- 付费计划
     */
    private Integer planType;


    public UserPlan() {
    }

    public UserPlan(Integer id, Long userId, Integer planId, Date addTime, Date endTime, Integer planStatus, Integer planType) {
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.addTime = addTime;
        this.endTime = endTime;
        this.planStatus = planStatus;
        this.planType = planType;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Integer getPlanId() {
        return planId;
    }


    public void setPlanId(Integer planId) {
        this.planId = planId;
    }


    public Date getAddTime() {
        return addTime;
    }


    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public Integer getPlanStatus() {
        return planStatus;
    }


    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public Integer getPlanType() {
        return planType;
    }


    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPlan{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", planId=").append(planId);
        sb.append(", addTime=").append(addTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", planStatus=").append(planStatus);
        sb.append(", planType=").append(planType);
        sb.append('}');
        return sb.toString();
    }
}