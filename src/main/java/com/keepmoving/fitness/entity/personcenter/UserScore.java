package com.keepmoving.fitness.entity.personcenter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:Kenny
 * @description:用户对计划的评分表
 * @version 1.0
 */
public class UserScore implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 对应的用户id
     */
    private Long userId;

    /**
     * 对应的计划id
     */
    private Integer planId;

    /**
     * 计划评分
     */
    private Double score;

    public UserScore() {
    }

    public UserScore(Integer id, Long userId, Integer planId, Double score) {
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.score = score;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "id=" + id +
                ", userId=" + userId +
                ", planId=" + planId +
                ", score=" + score +
                '}';
    }
}