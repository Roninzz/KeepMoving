package com.keepmoving.fitness.controller.index;

import com.keepmoving.fitness.entity.index.HotUserPlan;
import com.keepmoving.fitness.service.index.IHotUserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller

/**
 * 首页入口     /index
 */
@RequestMapping("/index")
public class HotUserPlanController {

    @Autowired
    private IHotUserPlanService hotUserPlanService;

    /**
     * 展示首页下部 li标签循环的内容
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String plan(Model model){

        List<HotUserPlan> list3 = hotUserPlanService.findAll();

        /**
         * 中部取计划的图片
         * 下部取计划的用户名和计划名
         */
        model.addAttribute("hotplan",list3);

        return "index";
    }
}
