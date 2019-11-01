package com.keepmoving.fitness.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户健身时间接受对象
 */
public class FitTimeDTO {
    /**
     * 用户Id
     */
    @Id
    private Long userId;

    /**
     * 具体日期，精确到天
     */
    @Field("date")
    private String date;

    /**
     * 观看视频时长
     */
    @Field("time")
    private Double time;

    public FitTimeDTO(){

    }

    public FitTimeDTO(Long userId, String date, Double time) {
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FitTimeDTO{");
        sb.append("userId=").append(userId);
        sb.append(", date='").append(date).append('\'');
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
