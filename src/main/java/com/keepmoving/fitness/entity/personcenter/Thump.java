package com.keepmoving.fitness.entity.personcenter;

import java.io.Serializable;

/**
 * @author:Kenny
 * @description:用户点赞实体类
 * @version 1.0
 */

public class Thump implements Serializable {
    /**
     * 对应的主键id
     */
    private Integer id;


    /**
     * 对应点赞的计划id
     */
    private Integer planId;

    /**
     * 点赞数量
     */
    private Integer thumpNum;

    /**
     * 点赞状态 0-取消点赞 1-点赞
     */
    private Integer status;

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

    public void setThumpNum(Integer thumpNum) {
        this.thumpNum = thumpNum;
    }

    public Integer getThumpNum() {
        return thumpNum;
    }

    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Thump{");
        sb.append("id=").append(id);
        sb.append(", planId=").append(planId);
        sb.append(", thumpNum=").append(thumpNum);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}