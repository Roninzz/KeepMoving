package com.keepmoving.fitness.service.calender;

import com.keepmoving.fitness.entity.calender.PlanScore;

import java.util.List;

/**
 * 计划评分service层接口
 */
public interface IPlanScoreService {

    /**
     * 根据计划id查询对应的计划评分
     * @param pid 计划id
     * @return 计划评分
     */
    Double getPlanScoreByPlanId(Integer pid);


    /**
     * 更新评分表
     * 每个计划有默认分数 所以只需要更新分数就行
     * @param
     */
    void updatePlanScore(Double score,Integer planid);


    /**
     * 所有计划的评分信息
     * @return
     */
    List<PlanScore> findAllPlanScore();
}
