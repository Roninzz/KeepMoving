package com.keepmoving.fitness.mapper.calender;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 计划每日训练内容标题mapper层
 */
public interface TrainArangeMapper {

    /**
     * 根据计划id获取每个计划对应的所有训练标题
     * @param pid 计划id
     * @return 每日的训练计划标题
     */
    @Select("select day_of_type from train_arange where plan_id = #{pid}")
    List<String> getTitleByPlanId(Integer pid);
}
