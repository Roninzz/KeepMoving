package com.keepmoving.fitness.mapper.courseList;

import com.keepmoving.fitness.entity.courseList.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface ICourseMapper {

    /*
    * 通过计划id查询所有课程
    * */

    @Select("select * from course where day_id = #{dayid} and plan_id = #{planid}")
    List<Course> findByDayId(@Param("dayid") String did,@Param("planid") Integer pid);


    //查找所有
    @Select("select * from course")
    List <Course> findAll();

    //根据课程id查
    @Select("select * from course where id = #{value}")
    Course findById(Integer id);

    //根据课程name查
    @Select("select * from course where course_name = #{value}")
    List <Course> findByCourseName(String courseName);

    //根据课程level查
    @Select("select * from course where level = #{value}")
    List <Course> findBylevel(String level);



}
