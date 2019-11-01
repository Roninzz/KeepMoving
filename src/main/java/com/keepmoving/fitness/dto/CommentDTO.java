package com.keepmoving.fitness.dto;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 接受评论传输到后台的数据
 */
public class CommentDTO {
    /**
     * 回复的用户id
     */
    private Long userId;
    /**
     * 回复的内容
     */
    private String content;
    /**
     * 回复的计划id
     */
    private Integer planId;

    private CommentDTO(){}

    public CommentDTO(Long userId, String content, Integer planId) {
        this.userId = userId;
        this.content = content;
        this.planId = planId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentDTO{");
        sb.append("userId=").append(userId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", planId='").append(planId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
