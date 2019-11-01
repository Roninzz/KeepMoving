package com.keepmoving.fitness.service.impl.calender;

import com.keepmoving.fitness.entity.calender.PlanScore;
import com.keepmoving.fitness.entity.personcenter.UserScore;
import com.keepmoving.fitness.mapper.calender.PlanScoreMapper;
import com.keepmoving.fitness.mapper.personcenter.IUserScoreMapper;
import com.keepmoving.fitness.service.calender.IPlanScoreService;
import com.keepmoving.fitness.service.personcenter.IUserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 计划评分service层实现类
 */
@Service
public class PlanScoreServiceImpl implements IPlanScoreService {

    @Autowired
    private PlanScoreMapper planScoreMapper;

    /**
     * 获取用户计划的评分
     */
    @Autowired
    private IUserScoreService userScoreService;

    @Autowired
    private PlanScoreMapper scoreMapper;

    /**
     * 根据计划id查询对应的计划评分
     * @param pid 计划id
     * @return 计划评分实体类
     */
    @Override
    public Double getPlanScoreByPlanId(Integer pid) {
        return planScoreMapper.getPlanScoreByPlanId(pid);
    }

    /**
     * 更新计划评分
     * @param score 分数
     * @param planid 计划id
     */
    @Override
    public void updatePlanScore(Double score, Integer planid) {

        //获取所有用户对一个计划的所有评分
        List<UserScore> userscore = userScoreService.findAllUserScoreByPlanId(2);

        //初始化计划的分
        Double scoreplan = 0.0;

        //对所求出的集合对用户所有分数求和
        Double sum= userscore .stream().collect(Collectors.summingDouble(UserScore::getScore));

        //求出计划的平均分
        scoreplan = sum/userscore.size();

        //保留一位小数
        scoreplan = Double.valueOf(String.format("%.1f",score));

        planScoreMapper.updatePlanScore(scoreplan, 2);
    }

//    /**
//     * 更新计划评分
//     * @param planScore 计划评分实体类
//     */

//    @Override
//    public void updatePlanScore(PlanScore planScore) {
//        List<Double> scores = userScoreService.findAllUserScoreByPlanId(planScore.getPlanId());
//        // 初始化总的评分
//        Double scorePlan = 0.0;
//        // 获取每个用户对该计划的评分,并进行求和
//        for (Double score : scores) {
//            scorePlan += score;
//        }
//        // 计划评分 = 评分总和除以人数
//        scorePlan = scorePlan / scores.size();
//        scorePlan = Double.valueOf(String.format("%.1f",scorePlan));
//
//        // 将分数添加到数据库中
//        planScore.setScore(scorePlan);
//        System.out.println(planScore);
//        scoreMapper.updatePlanScore(planScore);
//    }

    /**
     * 按评分排序计划
     * @return
     */
    @Override
    public List<PlanScore> findAllPlanScore() {
        return scoreMapper.findAllPlanScore();
    }

}
