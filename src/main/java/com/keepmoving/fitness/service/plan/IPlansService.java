package com.keepmoving.fitness.service.plan;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.plan.Plans;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ray
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/9/27  21:47
 */
public interface IPlansService {
    /**
     * 动态查询 全是null 则查询所有
     * @param planName 计划名称
     * @param planTarget 计划介绍
     * @param planDay 天数
     * @param planEquipment 器材
     * @param planTpoint 部位
     * @param planDifficult 难度
     * @return
     */
    PageInfo<Plans> findAll (String planName,Integer planTarget,Integer planDay,Integer planEquipment,Integer planTpoint,Integer planDifficult,Integer pageNum, Integer pageSize);

    /**
     * 根据参与人数查出计划排行榜
     * @param
     * @return
     */
    List<Plans> findByPlanNum();

    /**
     * 查询所有计划
     * @return
     */
    List<Plans> findByAll();

    /**
     * 根据计划id查询计划
     * @param id 计划id
     * @return 详细计划
     */
    Plans findById(Integer id);

    /**
     * 根据计划id查计划说明
     * @param id 计划id
     * @return  介绍说明
     */
    String getPlanIntroductionById(Integer id);

    /**
     * 根据计划id查计划名字
     * @param id
     * @return
     */
    String getPlanNameById(Integer id);

    /**
     * 根据计划id查计划周数
     * @param id 计划id
     * @return 计划名字
     */
    Integer getPlanWeekById(Integer id);

    /**
     * 根据计划id查计划天数
     * @param id 计划id
     * @return 计划天数
     */
    Integer getPlanDayById(Integer id);

    /**
     * 根据计划id查计划器材
     * @param id 计划id
     * @return 计划器材
     */
    Integer getPlanEquipmentById(Integer id);

    /**
     * 根据计划id查计划难度
     * @param id 计划id
     * @return 计划难度
     */
    Integer getPlanDifficultById(Integer id);

    /**
     * 根据计划id查计划参与人数
     * @param id 计划id
     * @return 计划参与人数
     */
    Integer getPlanNumById(Integer id);

    /**
     * 根据计划id查计划图片
     * @param id 计划id
     * @return 计划图片
     */
    @Select("select url plans where id = #{value} ")
    String getUrlById(Integer id);
}
