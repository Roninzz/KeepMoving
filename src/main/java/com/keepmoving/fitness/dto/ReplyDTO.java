package com.keepmoving.fitness.dto;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 接受前台传输的数据
 */
public class ReplyDTO {
    /**
     * 回复id
     */
    private Integer commentId;
    /**
     * 回复的用户id
     */
    private String replyUserId;
    /**
     * 回复的内容
     */
    private String replyContent;
    /**
     * 对应的计划id
     */
    private Integer planId;

    private ReplyDTO(){}

    public ReplyDTO(Integer commentId, String replyUserId, String replyContent, Integer planId) {
        this.commentId = commentId;
        this.replyUserId = replyUserId;
        this.replyContent = replyContent;
        this.planId = planId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplyDTO{");
        sb.append("commentId=").append(commentId);
        sb.append(", replyUserId=").append(replyUserId);
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", planId=").append(planId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
}
