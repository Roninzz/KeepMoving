package com.keepmoving.fitness.entity.coursedetail;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Vedios implements Serializable {

    private Integer id;    //视频id

    private Integer courseId;   //课程id

    private String vediosUrl;   //视频url路径

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date vedioTime;     //视频时长

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;    //视频创建日期

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getVediosUrl() {
        return vediosUrl;
    }

    public void setVediosUrl(String vediosUrl) {
        this.vediosUrl = vediosUrl == null ? null : vediosUrl.trim();
    }

    public Date getVedioTime() {
        return vedioTime;
    }

    public void setVedioTime(Date vedioTime) {
        this.vedioTime = vedioTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Vedios(Integer id, Integer courseId, String vediosUrl, Date vedioTime, Date createTime) {
        this.id = id;
        this.courseId = courseId;
        this.vediosUrl = vediosUrl;
        this.vedioTime = vedioTime;
        this.createTime = createTime;
    }

    public Vedios() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", vediosUrl=").append(vediosUrl);
        sb.append(", vedioTime=").append(vedioTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}