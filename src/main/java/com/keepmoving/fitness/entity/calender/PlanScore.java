package com.keepmoving.fitness.entity.calender;

import org.springframework.stereotype.Component;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划评分表
 */
@Component
public class PlanScore {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 计划id
     */
    private Integer planId;

    /**
     * 对应的评分信息
     */
    private Double score;

    public PlanScore(){}

    public PlanScore(Integer id, Integer planId, Double score) {
        this.id = id;
        this.planId = planId;
        this.score = score;
    }

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanScore{");
        sb.append("id=").append(id);
        sb.append(", planId=").append(planId);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
