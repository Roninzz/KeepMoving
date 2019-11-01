package com.keepmoving.fitness.service.personcenter;


import com.keepmoving.fitness.entity.personcenter.UserScore;

import java.util.List;

/**
 * 用户评价的service层接口
 */
public interface IUserScoreService {

    /**
     * 查询用户对计划的评分信息
     * @param uid 用户的id
     * @return
     */
    UserScore getUserScoreByUserId(Long uid);

    /**
     * 查询一个计划的所有评分信息
     * @param pid 计划id
     * @return
     */
    List<UserScore> findAllUserScoreByPlanId(Integer pid);


    /*
    * 保存用户对计划的评分
    *
    * */
    void savePlanScore(UserScore u);
}
