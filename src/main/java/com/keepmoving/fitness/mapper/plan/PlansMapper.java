package com.keepmoving.fitness.mapper.plan;

import com.keepmoving.fitness.entity.plan.Plans;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ray
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/9/27  19:53
 */

public interface PlansMapper {
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
    List<Plans> findAll(@Param("planName") String planName,@Param("planTarget") Integer planTarget,@Param("planDay") Integer planDay,@Param("planEquipment") Integer planEquipment,@Param("planTpoint") Integer planTpoint,@Param("planDifficult") Integer planDifficult);

    @Select("select * from plans")
    List<Plans> findByAll();
    /**
     * 根据参与人数查出计划排行榜
     * @param
     * @return
     */
    @Select("select * from plans order by plan_num desc limit 5")
    List<Plans> findByPlanNum();
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
    @Select("select plan_introduction from plans where id = #{value}")
    String getPlanIntroductionById(Integer id);

    /**
     * 根据计划id查计划名字
     * @param id 计划id
     * @return 计划名字
     */
    @Select("select plan_name from plans where id = #{value} ")
    String getPlanNameById(Integer id);

    /**
     * 根据计划id查计划周数
     * @param id 计划id
     * @return 计划名字
     */
    @Select("select plan_week from plans where id = #{value} ")
    Integer getPlanWeekById(Integer id);

    /**
     * 根据计划id查计划天数
     * @param id 计划id
     * @return 计划天数
     */
    @Select("select plan_day from plans where id = #{value} ")
    Integer getPlanDayById(Integer id);

    /**
     * 根据计划id查计划目标
     * @param id 计划id
     * @return 计划目标
     */
    @Select("select plan_target from plans where id = #{value} ")
    Integer getPlanTargetById(Integer id);

    /**
     * 根据计划id查计划器材
     * @param id 计划id
     * @return 计划器材
     */
    @Select("select plan_equipment plans where id = #{value} ")
    Integer getPlanEquipmentById(Integer id);

    /**
     * 根据计划id查计划部位
     * @param id 计划id
     * @return 计划部位
     */
    @Select("select plan_tpoint plans where id = #{value} ")
    Integer getPlanTpointById(Integer id);

    /**
     * 根据计划id查计划难度
     * @param id 计划id
     * @return 计划难度
     */
    @Select("select plan_difficult plans where id = #{value} ")
    Integer getPlanDifficultById(Integer id);

    /**
     * 根据计划id查计划参与人数
     * @param id 计划id
     * @return 计划参与人数
     */
    @Select("select plan_num plans where id = #{value} ")
    Integer getPlanNumById(Integer id);

    /**
     * 根据计划id查计划图片
     * @param id 计划id
     * @return 计划图片
     */
    @Select("select url plans where id = #{value} ")
    String getUrlById(Integer id);
}
