package com.keepmoving.fitness.service.impl.calender;

import com.keepmoving.fitness.mapper.calender.TrainArangeMapper;
import com.keepmoving.fitness.service.calender.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划安排的service实现类
 */
@Service
public class TrainServiceImpl implements ITrainService {


    @Autowired
    private TrainArangeMapper trainArangeMapper;

    /**
     * 根据计划id查询对应的计划安排
     * @param pid 计划id
     * @return
     */
    @Override
    public List<String> getTitleByPlanId(Integer pid) {
        return trainArangeMapper.getTitleByPlanId(pid);
    }
}
