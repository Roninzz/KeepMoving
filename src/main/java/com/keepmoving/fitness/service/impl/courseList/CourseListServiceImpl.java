package com.keepmoving.fitness.service.impl.courseList;

import com.keepmoving.fitness.entity.courseList.Course;
import com.keepmoving.fitness.mapper.courseList.ICourseMapper;
import com.keepmoving.fitness.service.courseList.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseListServiceImpl implements ICourseService {

    @Autowired
    private ICourseMapper courseMapper;


    @Override
    public List<Course> findByDayId(String did, Integer pid) {
        return courseMapper.findByDayId(did,pid);
    }


    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.findById(id);
    }

    @Override
    public List<Course> findByCourseName(String courseName) {
        return courseMapper.findByCourseName(courseName);
    }

    @Override
    public List<Course> findBylevel(String level) {
        return courseMapper.findBylevel(level);
    }
}
