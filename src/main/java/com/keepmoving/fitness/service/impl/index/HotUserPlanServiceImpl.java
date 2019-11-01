package com.keepmoving.fitness.service.impl.index;

import com.keepmoving.fitness.entity.index.HotUserPlan;
import com.keepmoving.fitness.mapper.index.IHotUserPlanMapper;
import com.keepmoving.fitness.service.index.IHotUserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotUserPlanServiceImpl implements IHotUserPlanService {

    @Autowired
    private IHotUserPlanMapper hotUserPlanMapper;


    @Override
    public List<HotUserPlan> findAll() {
        return hotUserPlanMapper.findAll();
    }

    @Override
    public HotUserPlan findByUserId(Long userid) {
        return hotUserPlanMapper.findByUserId(userid);
    }
}
