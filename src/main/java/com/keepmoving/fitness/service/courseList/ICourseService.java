package com.keepmoving.fitness.service.courseList;

import com.keepmoving.fitness.entity.courseList.Course;

import java.util.List;

public interface ICourseService {


    List<Course> findByDayId(String did, Integer pid);

    //查找所有
    List<Course> findAll();

    //根据课程id查
    Course findById(Integer id);

    //根据课程name查
    List <Course> findByCourseName(String courseName);

    //根据课程level查
    List <Course> findBylevel(String level);


}
