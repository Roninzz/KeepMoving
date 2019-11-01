package com.keepmoving.fitness.vo;

import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author:Kenny
 * @version:1.0
 * @description: 评论的第三方实体类,用来封装评论的散列数据
 */
public class CommentVo {

    /**
     * 评论id
     */
    private Integer cid;

    /**
     * 评论的计划名称
     */
    private String planName;

    /**
     * 评论的内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String date;

    /**
     * 回复人的头像
     */
    private String commentUserImg;

    /**
     * 回复人的昵称
     */
    private String commentUserName;

    /**
     * 评论对应的回复信息
     */
    private List<ReplyVo> replyVoList;



    public CommentVo() {
    }

    public CommentVo(String planName, String content, String date, String commentUserImg, String commentUserName, List<ReplyVo> replyVoList) {
        this.planName = planName;
        this.content = content;
        this.date = date;
        this.commentUserImg = commentUserImg;
        this.commentUserName = commentUserName;
        this.replyVoList = replyVoList;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentUserImg() {
        return commentUserImg;
    }

    public void setCommentUserImg(String commentUserImg) {
        this.commentUserImg = commentUserImg;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public List<ReplyVo> getReplyVoList() {
        return replyVoList;
    }

    public void setReplyVoList(List<ReplyVo> replyVoList) {
        this.replyVoList = replyVoList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentVo{");
        sb.append("cid=").append(cid);
        sb.append(", planName='").append(planName).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", commentUserImg='").append(commentUserImg).append('\'');
        sb.append(", commentUserName='").append(commentUserName).append('\'');
        sb.append(", replyVoList=").append(replyVoList);
        sb.append('}');
        return sb.toString();
    }
}
