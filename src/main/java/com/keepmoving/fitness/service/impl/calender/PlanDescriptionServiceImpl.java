package com.keepmoving.fitness.service.impl.calender;

import com.keepmoving.fitness.mapper.calender.PlanDescriptionMapper;
import com.keepmoving.fitness.service.calender.IPlanDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划描述的service层接口的实现类
 */
@Service
public class PlanDescriptionServiceImpl implements IPlanDescriptionService {

    @Autowired
    private PlanDescriptionMapper planDescriptionMapper;

    /**
     * 根据id查询计划描述
     * @param pid
     * @return
     */
    @Override
    public String getPlanDescriptionByPlanId(Integer pid){
        return planDescriptionMapper.getPlanDescriptionByPlanId(pid);
    }


}
