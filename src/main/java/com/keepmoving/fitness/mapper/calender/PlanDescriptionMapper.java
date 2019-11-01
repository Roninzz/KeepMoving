package com.keepmoving.fitness.mapper.calender;


import org.apache.ibatis.annotations.Select;

/**
 * 计划描述mapper
 */
public interface PlanDescriptionMapper {

    /**
     * 查询每个计划的计划描述
     * @param id 计划id
     * @return 计划描述
     */
    @Select("select description from plan_description where plan_id = #{value}")
    String getPlanDescriptionByPlanId(Integer id);

}
