package com.keepmoving.fitness.service.impl.personcenter;

import com.keepmoving.fitness.entity.personcenter.UserScore;
import com.keepmoving.fitness.mapper.personcenter.IUserScoreMapper;
import com.keepmoving.fitness.service.personcenter.IUserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户评分的service层实现类
 */
@Service
public class UserScoreServiceImpl implements IUserScoreService {

    @Autowired
    private IUserScoreMapper userScoreMapper;

    /**
     * 根据用户id查询用户对计划的评分信息
     * @param uid 用户id
     * @return 用户对计划的评分,对应的计划id
     */
    @Override
    public UserScore getUserScoreByUserId(Long uid){
        return userScoreMapper.getUserScoreByUserId(uid);
    }

    /**
     * 所有用户对该计划的评分
     * @param pid 计划id
     * @return 某一个计划的所有评分
     */
    @Override
    public List<UserScore> findAllUserScoreByPlanId(Integer pid){
        return userScoreMapper.findAllUserScoreByPlanId(pid);
    }


    /*
     * 保存用户对计划的评分
     *
     */
    @Override
    public void savePlanScore(UserScore u) {
        userScoreMapper.savePlanScore(u);
    }


}
