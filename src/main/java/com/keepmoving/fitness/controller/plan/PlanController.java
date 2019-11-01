package com.keepmoving.fitness.controller.plan;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.calender.PlanScore;
import com.keepmoving.fitness.entity.personInfo.UserImgs;
import com.keepmoving.fitness.entity.plan.CodeStatus;
import com.keepmoving.fitness.entity.plan.Plans;
import com.keepmoving.fitness.entity.plan.Result;
import com.keepmoving.fitness.service.calender.IPlanScoreService;
import com.keepmoving.fitness.service.plan.IPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Ray
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/10/1  12:49
 */
@RestController
public class PlanController {
    @Autowired
    private IPlansService plansService;
    @Autowired
    private IPlanScoreService planScoreService;


//    @GetMapping("/plans")
//    public Result plans(){
//        PageInfo<Plans> pageInfo = plansService.findAll(null,null,null,null,null,null,1,4);
////        Plans plans = plansService.findById(1);
//        return new Result(CodeStatus.OK,true,"成功",pageInfo);
//    }

    /**
     * 获取总计划和分页信息
     * @param planName
     * @param planTarget
     * @param planDay
     * @param planEquipment
     * @param planTpoint
     * @param planDifficult
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/plans")
    public Result plan(@RequestParam(defaultValue = "") String planName,@RequestParam(defaultValue = "") Integer planTarget,
                       @RequestParam(defaultValue = "") Integer planDay,@RequestParam(defaultValue = "") Integer planEquipment,
                       @RequestParam(defaultValue = "") Integer planTpoint,@RequestParam(defaultValue = "") Integer planDifficult,
                       @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "4") Integer pageSize){
        PageInfo<Plans> pageInfo = plansService.findAll(planName,planTarget,planDay,planEquipment,planTpoint,planDifficult,pageNum,pageSize);
        return new Result(CodeStatus.OK,true,"成功",pageInfo);
    }

    /**
     * 返回按参与人数排行的计划
     * @return
     */
    @GetMapping("/hot")
    public Result hot(){
        List<Plans> plans = plansService.findByPlanNum();
        return new Result(CodeStatus.OK,true,"成功",plans);
    }

    /**
     * 返回按评分排行的计划信息
     * @return
     */
    @GetMapping("/score")
    public Result score(){
        List<PlanScore> planScore = planScoreService.findAllPlanScore();
        return new Result(CodeStatus.OK,true,"成功",planScore);
    }

    @GetMapping("/all")
    public Result all(){
        List<Plans> plans = plansService.findByAll();
        return new Result(CodeStatus.OK,true,"成功",plans);
    }

    @GetMapping("/pic")
    public Result pic(HttpServletRequest req){
//        System.out.println(req.getSession().getId());
//        System.out.println(req.getSession().getAttribute("userImg"));
        return new Result(CodeStatus.OK,true,"成功",req.getSession().getAttribute("userImg"));
    }

    @GetMapping("/user")
    public Result user(HttpServletRequest req){
//        System.out.println(req.getSession().getId());
//        System.out.println(req.getSession().getAttribute("userImg"));
        return new Result(CodeStatus.OK,true,"成功",req.getSession().getAttribute("userBaseInfo"));
    }
}
