package com.keepmoving.fitness.service.index;

import com.keepmoving.fitness.entity.index.HotUserPlan;
import com.keepmoving.fitness.mapper.index.IHotUserPlanMapper;

import java.util.List;

public interface IHotUserPlanService {

    List<HotUserPlan> findAll();

    HotUserPlan findByUserId(Long userid);
}
