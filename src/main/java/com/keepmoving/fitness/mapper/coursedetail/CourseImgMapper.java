package com.keepmoving.fitness.mapper.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.CourseImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface CourseImgMapper {

    //查找所有
    @Select("select * from course_img")
    List<CourseImg> findAll();

    //根据图片id查
    @Select("select * from course_img where id = #{value}")
    CourseImg findById(Integer id);

    //根据课程id查
    @Select("select * from course_img where course_id = #{value}")
    List <CourseImg> findByCourseId(Integer courseId);

}
