package com.keepmoving.fitness.entity.calender;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划详细介绍实体类
 */

@Component
public class PlanDescription implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 对应的计划id
     */
    private Integer planId;

    /**
     * 计划说明
     */
    private String description;

    public PlanDescription() {
    }

    public PlanDescription(Integer id, Integer planId, String description) {
        this.id = id;
        this.planId = planId;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlan_Id() {
        return planId;
    }

    public void setPlan_Id(Integer planId) {
        this.planId = planId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanDescription{");
        sb.append("id=").append(id);
        sb.append(", planId=").append(planId);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
