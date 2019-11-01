package com.keepmoving.fitness.entity.personcenter;

import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

/**
 * @author:Kenny
 * @description:用户回复实体类
 * @version 1.0
 */
@Component
public class Reply implements Serializable {
    /**
     * 主键id
     */
    private Integer id;


    /**
     * 回复对应的评论id
     */
    private Integer commentId;

    /**
     * 回复的用户id
     */
    private Long replyUser;

    /**
     * 回复的内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 标记状态 默认设为0,当用户删除评论时更新为1
     */
    private Integer status;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }


    public Long getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(Long replyUser) {
        this.replyUser = replyUser;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }


    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reply{");
        sb.append("id=").append(id);
        sb.append(", commentId=").append(commentId);
        sb.append(", replyUser=").append(replyUser);
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", replyTime=").append(replyTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}