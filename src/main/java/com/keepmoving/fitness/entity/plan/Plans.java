package com.keepmoving.fitness.entity.plan;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 计划总表
 */
@Component
public class Plans implements Serializable {
    /**
     *计划id
     */
    private Integer id;

    /**
     *计划名字
     */
    private String planName;

    /**
     *计划说明
     */
    private String planIntroduction;

    /**
     *计划目标
     */
    private Integer planTarget;

    /**
     *计划天数
     */
    private Integer planDay;

    /**
     *计划器材
     */
    private Integer planEquipment;

    /**
     *计划部位
     */
    private Integer planTpoint;

    /**
     *计划难度
     */
    private Integer planDifficult;

    /**
     *计划周数
     */
    private Integer planWeek;

    /**
     *计划图片地址
     */
    private String url;

    /**
     *计划类型, 付费 1 免费 0
     */
    private Integer status;
    /**
     * 参与人数
     */
    private Integer planNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plans() {
    }

    public Plans(Integer id, String planName, String planIntroduction, Integer planTarget, Integer planDay, Integer planEquipment, Integer planTpoint, Integer planDifficult, Integer planWeek, String url, Integer status) {
        this.id = id;
        this.planName = planName;
        this.planIntroduction = planIntroduction;
        this.planTarget = planTarget;
        this.planDay = planDay;
        this.planEquipment = planEquipment;
        this.planTpoint = planTpoint;
        this.planDifficult = planDifficult;
        this.planWeek = planWeek;
        this.url = url;
        this.status = status;
    }

    public Plans(String planName, String planIntroduction, Integer planTarget, Integer planDay, Integer planEquipment, Integer planTpoint) {
        this.planName = planName;
        this.planIntroduction = planIntroduction;
        this.planTarget = planTarget;
        this.planDay = planDay;
        this.planEquipment = planEquipment;
        this.planTpoint = planTpoint;
    }

    public String getPlanName() {
        return planName;
    }


    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }


    public String getPlanIntroduction() {
        return planIntroduction;
    }


    public void setPlanIntroduction(String planIntroduction) {
        this.planIntroduction = planIntroduction == null ? null : planIntroduction.trim();
    }


    public Integer getPlanTarget() {
        return planTarget;
    }


    public void setPlanTarget(Integer planTarget) {
        this.planTarget = planTarget;
    }


    public Integer getPlanDay() {
        return planDay;
    }


    public void setPlanDay(Integer planDay) {
        this.planDay = planDay;
    }


    public Integer getPlanEquipment() {
        return planEquipment;
    }


    public void setPlanEquipment(Integer planEquipment) {
        this.planEquipment = planEquipment;
    }


    public Integer getPlanTpoint() {
        return planTpoint;
    }


    public void setPlanTpoint(Integer planTpoint) {
        this.planTpoint = planTpoint;
    }

    public Integer getPlanDifficult() {
        return planDifficult;
    }


    public void setPlanDifficult(Integer planDifficult) {
        this.planDifficult = planDifficult;
    }


    public Integer getPlanWeek() {
        return planWeek;
    }


    public void setPlanWeek(Integer planWeek) {
        this.planWeek = planWeek;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Integer planNum) {
        this.planNum = planNum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", planName=").append(planName);
        sb.append(", planIntroduction=").append(planIntroduction);
        sb.append(", planTarget=").append(planTarget);
        sb.append(", planDay=").append(planDay);
        sb.append(", planEquipment=").append(planEquipment);
        sb.append(", planTpoint=").append(planTpoint);
        sb.append(", planDifficult=").append(planDifficult);
        sb.append(", planWeek=").append(planWeek);
        sb.append(", url=").append(url);
        sb.append(", status=").append(status);
        sb.append(", planNum=").append(planNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}