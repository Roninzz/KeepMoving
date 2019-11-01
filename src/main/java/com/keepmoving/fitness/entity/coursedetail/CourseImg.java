package com.keepmoving.fitness.entity.coursedetail;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class CourseImg implements Serializable {

    private Integer id;    //课程图片id

    private Integer courseId;   //课程id

//    private String courseUrl; //课程图片url

    private String imgUrl; //课程图片url

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;   //图片创建时间

    private static final long serialVersionUID = 1L;

    public CourseImg(Integer id, Integer courseId, String imgUrl, Date createTime) {
        this.id = id;
        this.courseId = courseId;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
    }

    public CourseImg() {
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CourseImg{");
        sb.append("id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}