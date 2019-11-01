package com.keepmoving.fitness.vo;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户回复的第三方实体类,用来封装用户回复的散列的数据
 */
public class ReplyVo {

    // 回复的内容
    private String replyContent;

    // 回复的日期
    private String replyDate;

    // 回复对应的评论内容
    private String replyFromComment;

    // 回复对象的头像
    private String replyUserImg;

    // 回复对象的昵称
    private String replyUserName;

    public ReplyVo(){}

    public ReplyVo(String replyContent, String replyDate, String replyFromComment) {
        this.replyContent = replyContent;
        this.replyDate = replyDate;
        this.replyFromComment = replyFromComment;
    }

    public ReplyVo(String replyContent, String replyDate, String replyFromComment, String replyUserImg, String replyUserName) {
        this.replyContent = replyContent;
        this.replyDate = replyDate;
        this.replyFromComment = replyFromComment;
        this.replyUserImg = replyUserImg;
        this.replyUserName = replyUserName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    public String getReplyFromComment() {
        return replyFromComment;
    }

    public void setReplyFromComment(String replyFromComment) {
        this.replyFromComment = replyFromComment;
    }

    public String getReplyUserImg() {
        return replyUserImg;
    }

    public void setReplyUserImg(String replyUserImg) {
        this.replyUserImg = replyUserImg;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplyVo{");
        sb.append("replyContent='").append(replyContent).append('\'');
        sb.append(", replyDate='").append(replyDate).append('\'');
        sb.append(", replyFromComment='").append(replyFromComment).append('\'');
        sb.append(", replyUserImg='").append(replyUserImg).append('\'');
        sb.append(", replyUserName='").append(replyUserName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
