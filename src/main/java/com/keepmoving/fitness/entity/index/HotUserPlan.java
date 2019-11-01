package com.keepmoving.fitness.entity.index;

public class HotUserPlan {
    private Integer id;

    private Long userId;

    private String userName;

    private String planName;

    private Integer planId;

    private String planImgUrl;

    public HotUserPlan() {
    }

    public HotUserPlan(Integer id, Long userId, String userName, String planName, Integer planId, String planImgUrl) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.planName = planName;
        this.planId = planId;
        this.planImgUrl = planImgUrl;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanImgUrl() {
        return planImgUrl;
    }

    public void setPlanImgUrl(String planImgUrl) {
        this.planImgUrl = planImgUrl;
    }

    @Override
    public String toString() {
        return "HotUserPlan{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", planName='" + planName + '\'' +
                ", planId=" + planId +
                ", planImgUrl='" + planImgUrl + '\'' +
                '}';
    }
}
