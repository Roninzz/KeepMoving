package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personcenter.UserScore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户评分mapper
 */
public interface IUserScoreMapper {

    /**
     * 查询用户对计划的评分信息
     * @param id 用户的id
     * @return
     */
    @Select("select user_id,plan_id,score,create_time from user_score where user_id = #{uid}")
    UserScore getUserScoreByUserId(Long uid);

    /**
     * 查询一个计划的所有评分信息
     * @param id 计划id
     * @return
     */
    @Select("select * from user_score where plan_id = #{pid} ")
    List<UserScore> findAllUserScoreByPlanId(Integer pid);

   // @Insert("insert into user_score (user_id,plan_id,score,create_time) values (#{userid},#{planid},#{score})")
   // void savePlanScore(@Param("userid") Integer userid, @Param("planid")  Integer planid, @Param("score")  Double score);

    @Insert("insert into user_score (user_id,plan_id,score) values (#{userId},#{planId},#{score})")
    void savePlanScore(UserScore u);
}
