package com.keepmoving.fitness.service.calender;

/**
 * 计划描述的service层接口
 */
public interface IPlanDescriptionService {

    /**
     * 根据计划id查询对应的计划描述
     * @param pid
     * @return
     */
    String getPlanDescriptionByPlanId(Integer pid);
}
