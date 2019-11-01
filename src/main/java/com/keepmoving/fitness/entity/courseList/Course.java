package com.keepmoving.fitness.entity.courseList;

import java.io.Serializable;

public class Course implements Serializable {

    private Integer id;

    private Integer courseId; //课程id


    private String courseName;  //课程名


    private String level;//课程级别


    private String catetory;//课程类型


    private String courseIntroduction;//课程介绍


    private String courseDescription;//课程描述


    private String dayId;


    private Integer planId;

    private String imgUrl;


    private static final long serialVersionUID = 1L;

    public Course() {
    }

    public Course(Integer id, Integer courseId, String courseName, String level, String catetory, String courseIntroduction, String courseDescription, String dayId, Integer planId, String imgUrl) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.level = level;
        this.catetory = catetory;
        this.courseIntroduction = courseIntroduction;
        this.courseDescription = courseDescription;
        this.dayId = dayId;
        this.planId = planId;
        this.imgUrl = imgUrl;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCatetory() {
        return catetory;
    }

    public void setCatetory(String catetory) {
        this.catetory = catetory;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", level='" + level + '\'' +
                ", catetory='" + catetory + '\'' +
                ", courseIntroduction='" + courseIntroduction + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", dayId=" + dayId +
                ", planId=" + planId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}