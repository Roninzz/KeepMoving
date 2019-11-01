package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personcenter.Thump;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 点赞mapper
 */
public interface IThumpMapper {

    /**
     * 查询计划的点赞数量
     * @param id 计划id
     * @return 计划总的点赞数量
     */
    @Select("select thump_num from thump where plan_id = #{id}")
    Integer findThumpNumByPlanIdMapper(Integer id);

    /**
     * 当用户点赞之后,对应的计划点赞数加 1
     * @param pid
     */
    @Update("update thump set thump_num = thump_num + 1 where plan_id = #{pid}")
    void addThumpNum(Integer pid);

    /**
     * 当用户再次点赞之后,对应的计划点赞数加 -1
     * @param pid
     */
    @Update("update thump set thump_num = thump_num - 1 where plan_id = #{pid}")
    void subThumpNum(Integer pid);

    /**
     * 方法实现说明  根据planId查询对应的点赞信息
     * @author      cyf
     * @param planId
     * @return
     */
    @Select("select * from thump where plan_id = #{value}")
    Thump findByPlanId(Integer planId);

}
