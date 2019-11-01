package com.keepmoving.fitness.vo;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:Kenny
 * @description:用户评论
 * @version 1.0
 */
@Component
public class CommentCopy implements Serializable {
    /**
     * 评论主键id
     */

    @Id
    private String id;

    /**
     * 评论的用户id
     */
    private Long userId;

    /**
     * 评论对应的计划id
     */
    private Integer planId;

    /**
     * 评论的内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date createTime;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 重写Object的toString方法
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", planId=").append(planId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}