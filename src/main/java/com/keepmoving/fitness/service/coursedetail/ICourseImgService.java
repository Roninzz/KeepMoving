package com.keepmoving.fitness.service.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.CourseImg;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface ICourseImgService {

    //查找所有
    List<CourseImg> findAll();

    //根据图片id查
    CourseImg findById(Integer id);

    //根据课程id查
    List <CourseImg> findByCourseId(Integer courseId);
}
