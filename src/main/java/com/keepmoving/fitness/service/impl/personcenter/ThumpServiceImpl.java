package com.keepmoving.fitness.service.impl.personcenter;

import com.keepmoving.fitness.entity.personcenter.Thump;
import com.keepmoving.fitness.mapper.personcenter.IThumpMapper;
import com.keepmoving.fitness.service.personcenter.IThumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 点赞的service层接口的实现类
 */
@Service
@Transactional
public class ThumpServiceImpl implements IThumpService {
    @Autowired
    private IThumpMapper thumpMapper;

    /**
     * 获取计划的点赞数量
     * @param pid 计划id
     * @return 对应计划的点赞数
     */
    @Override
    public Integer getThumpNumByPlanId(Integer pid){
        return thumpMapper.findThumpNumByPlanIdMapper(pid);
    }

    /**
     * 当用户点赞之后,对应的计划点赞数量加 1
     * @param pid 计划的id
     */
    @Override
    public void addThumpNum(Integer pid){
        thumpMapper.addThumpNum(pid);
    }

    /**
     * 方法实现说明  根据planId查询对应的点赞信息
     * @author      cyf
     * @param planId
     * @return
     */
    @Override
    public Thump findByPlanId(Integer planId) {
        return thumpMapper.findByPlanId(planId);
    }

    @Override
    public void subThumpNum(Integer pid) {
        thumpMapper.subThumpNum(pid);
    }

}
