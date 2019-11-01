package com.keepmoving.fitness.controller.courseList;


import com.keepmoving.fitness.dto.PlanOfDayDTO;
import com.keepmoving.fitness.entity.courseList.Course;
import com.keepmoving.fitness.service.courseList.ICourseService;
import com.keepmoving.fitness.service.plan.IPlansService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/courselist")
public class CourseListController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IPlansService plansService;


    /**
     * 转发到jsp页面
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, PlanOfDayDTO planOfDayDTO, HttpSession session){
        model.addAttribute("did",planOfDayDTO.getDid());
        List<Course> list1 = courseService.findByDayId(planOfDayDTO.getDid(),planOfDayDTO.getPid());
        String core = plansService.getPlanIntroductionById(planOfDayDTO.getPid());
        String name = plansService.getPlanNameById(planOfDayDTO.getPid());
        //放到session中给视屏页返回使用
        session.setAttribute("pid",planOfDayDTO.getPid());
        session.setAttribute("did",planOfDayDTO.getDid());
        model.addAttribute("core",core);
        model.addAttribute("name",name);


        model.addAttribute("dayTitle",planOfDayDTO.getDayTitle());
        model.addAttribute("courselist",list1);

        return "/plan/course-list";
    }

    @RequestMapping("/courseList")
    public String courseList(){

        return "/plan/course-list";
    }


}