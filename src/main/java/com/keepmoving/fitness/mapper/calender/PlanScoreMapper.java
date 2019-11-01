package com.keepmoving.fitness.mapper.calender;


import com.keepmoving.fitness.entity.calender.PlanScore;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 计划评分mapper层
 */
public interface PlanScoreMapper {

    /**
     * 根据计划id查询对应的计划评分
     * @param pid 计划id
     * @return 计划评分
     */
    @Select("select score from plan_score where plan_id = #{pid}")
    Double getPlanScoreByPlanId(Integer pid);


    /**
     * 更新评分表
     * @param
     */
    @Update("update plan_score set score = #{score} where plan_id = #{planId}")
    void updatePlanScore(@Param("score") Double score,@Param("planId") Integer planid);


    /**
     * 所有计划的评分信息
     * @return
     */
    @Select("select plan_id,score from plan_score order by score desc")
    List<PlanScore> findAllPlanScore();

}
