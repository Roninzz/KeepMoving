package com.keepmoving.fitness.entity.action;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 健身动作说明
 */

@Component
public class FitAction {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 对应的用户id
     */
    private Long userId;

    /**
     * 动作名称
     */
    private String actionName;

    /**
     * 动作图片
     */
    private String actionImg;

    public FitAction(){}

    public FitAction(Integer id, Long userId, String actionName, String actionImg) {
        this.id = id;
        this.userId = userId;
        this.actionName = actionName;
        this.actionImg = actionImg;
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

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionImg() {
        return actionImg;
    }

    public void setActionImg(String actionImg) {
        this.actionImg = actionImg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FitAction{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", actionName='").append(actionName).append('\'');
        sb.append(", actionImg='").append(actionImg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
