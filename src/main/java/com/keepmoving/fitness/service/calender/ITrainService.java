package com.keepmoving.fitness.service.calender;

import java.util.List;

/**
 * 计划安排service层接口
 */
public interface ITrainService {

    /**
     * 根据计划id获取每个计划对应的所有训练标题
     * @param pid 计划id
     * @return 每日的训练计划标题
     */
    List<String> getTitleByPlanId(Integer pid);
}
