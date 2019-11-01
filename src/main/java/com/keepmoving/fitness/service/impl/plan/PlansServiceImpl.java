package com.keepmoving.fitness.service.impl.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.plan.Plans;
import com.keepmoving.fitness.mapper.plan.PlansMapper;
import com.keepmoving.fitness.service.plan.IPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ray
 * @version 1.0
 * @description:本类用来演示:根据条件筛选并实现分页功能
 * @date 2019/9/27  22:45
 */
@Service
@Transactional
public class PlansServiceImpl implements IPlansService {
    @Autowired
    private PlansMapper plansMapper;

    /**
     * 多条件组合查询
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
    @Override
    public PageInfo<Plans> findAll(String planName, Integer planTarget, Integer planDay, Integer planEquipment, Integer planTpoint, Integer planDifficult, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Plans> plansList = plansMapper.findAll(planName,planTarget,planDay,planEquipment,planTpoint,planDifficult);
        PageInfo<Plans> pageInfo = new PageInfo<>(plansList);
        return pageInfo;
    }

    /**
     * 根据参与人数查出计划排行榜
     * @param
     * @return
     */
    @Override
    public List<Plans> findByPlanNum() {
        List<Plans> plans = plansMapper.findByPlanNum();
        return plans;
    }

    /**
     * 查询所有计划
     * @return
     */
    @Override
    public List<Plans> findByAll() {
        List<Plans> plans = plansMapper.findByAll();
        return plans;
    }

    /**
     * 根据id查计划
     * @param id
     * @return
     */
    @Override
    public Plans findById(Integer id) {
        Plans plans = plansMapper.findById(id);
        return plans;
    }

    /**
     * 根据计划id查计划说明
     * @param id 计划id
     * @return  介绍说明
     */
    @Override
    public String getPlanIntroductionById(Integer id) {
        String planIntroduction = plansMapper.getPlanIntroductionById(id);
        return planIntroduction;
    }

    /**
     * 根据计划id查计划名字
     * @param id
     * @return
     */
    @Override
    public String getPlanNameById(Integer id) {
        String planName = plansMapper.getPlanNameById(id);
        return planName;
    }

    /**
     * 根据计划id查计划周数
     * @param id 计划id
     * @return 计划名字
     */
    @Override
    public Integer getPlanWeekById(Integer id) {
        Integer planWeek = plansMapper.getPlanWeekById(id);
        return planWeek;
    }

    /**
     * 根据计划id查计划天数
     * @param id 计划id
     * @return 计划天数
     */
    @Override
    public Integer getPlanDayById(Integer id) {
        Integer planDay = plansMapper.getPlanDayById(id);
        return planDay;
    }

    /**
     * 根据计划id查计划器材
     * @param id 计划id
     * @return 计划器材
     */
    @Override
    public Integer getPlanEquipmentById(Integer id) {
        Integer planEquipment = plansMapper.getPlanEquipmentById(id);
        return planEquipment;
    }

    /**
     * 根据计划id查计划难度
     * @param id 计划id
     * @return 计划难度
     */
    @Override
    public Integer getPlanDifficultById(Integer id) {
        Integer planDifficult = plansMapper.getPlanDifficultById(id);
        return planDifficult;
    }

    /**
     * 根据计划id查计划参与人数
     * @param id 计划id
     * @return 计划参与人数
     */
    @Override
    public Integer getPlanNumById(Integer id) {
        Integer planNum = plansMapper.getPlanNumById(id);
        return planNum;
    }

    /**
     * 根据计划id查计划图片
     * @param id 计划id
     * @return 计划图片
     */
    @Override
    public String getUrlById(Integer id) {
        String url = plansMapper.getUrlById(id);
        return url;
    }
}
