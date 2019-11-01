package com.keepmoving.fitness.mapper.index;

import com.keepmoving.fitness.entity.index.HotUserPlan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IHotUserPlanMapper {


    @Select("select * from hot_user_plan")
    List<HotUserPlan> findAll();


    @Select("select * from hot_user_plan where user_id = #{value}")
    HotUserPlan findByUserId(Long userid);
}
