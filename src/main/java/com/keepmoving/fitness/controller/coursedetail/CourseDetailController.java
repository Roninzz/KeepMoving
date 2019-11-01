package com.keepmoving.fitness.controller.coursedetail;

import com.keepmoving.fitness.entity.courseList.Course;
import com.keepmoving.fitness.entity.coursedetail.CourseImg;
import com.keepmoving.fitness.entity.coursedetail.Vedios;
import com.keepmoving.fitness.service.courseList.ICourseService;
import com.keepmoving.fitness.service.coursedetail.ICourseImgService;
import com.keepmoving.fitness.service.coursedetail.IVediosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/10/2.
 */
@Controller
@RequestMapping("/coursedetail")
public class CourseDetailController {


    /**
     * 课程
     */
    @Autowired
    private ICourseService courseService;

    /**
     * 课程图片
     */
    @Autowired
    private ICourseImgService courseImgService;

    /**
     * 课程视频
     */
    @Autowired
    private IVediosService vediosService;

    /**
     * 去课程详情页面
     * @param model
     * @param courseId
     * @return
     */
    @RequestMapping("/goCourseDetail")
    public String goCourseDetail(Model model, Integer courseId) {

        //查询课程
        Course c = courseService.findById(courseId);

        //课程对应的图片
        List<CourseImg> courseImgs = courseImgService.findByCourseId(courseId);

        //课程对应的视频
        Vedios vs = vediosService.findBycourseId(courseId);

        //放入作用域
        model.addAttribute("courseImgs", courseImgs);
        model.addAttribute("vs", vs);
        model.addAttribute("course", c);


        return "/plan/course-detail";
    }
}
