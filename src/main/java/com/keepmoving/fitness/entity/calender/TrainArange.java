package com.keepmoving.fitness.entity.calender;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划每日健身内容标题
 */
@Component
public class TrainArange implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 对应的计划id
     */
    private Integer planId;

    /**
     * 每天健身内容
     */
    private String dayOfType;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPlanId() {
        return planId;
    }


    public void setPlanId(Integer planId) {
        this.planId = planId;
    }


    public String getDayOfType() {
        return dayOfType;
    }


    public void setDayOfType(String dayOfType) {
        this.dayOfType = dayOfType == null ? null : dayOfType.trim();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrainArange{");
        sb.append("id=").append(id);
        sb.append(", planId=").append(planId);
        sb.append(", dayOfType='").append(dayOfType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}