package com.keepmoving.fitness.service.impl.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.CourseImg;
import com.keepmoving.fitness.mapper.coursedetail.CourseImgMapper;
import com.keepmoving.fitness.service.coursedetail.ICourseImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
@Service
@Transactional
public class CourseImgServiceImpl implements ICourseImgService {

    @Autowired
    private CourseImgMapper courseImgMapper;

    @Override
    public List<CourseImg> findAll() {
        return courseImgMapper.findAll();
    }

    @Override
    public CourseImg findById(Integer id) {
        return courseImgMapper.findById(id);
    }

    @Override
    public List<CourseImg> findByCourseId(Integer courseId) {
        return courseImgMapper.findByCourseId(courseId);
    }
}
