package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.entity.personcenter.Thump;
import org.apache.ibatis.annotations.Update;

/**
 * 点赞的service层接口
 */

public interface IThumpService {

    /**
     * 查询计划的点赞数量
     * @param id 计划id
     * @return 计划总的点赞数量
     */
    Integer getThumpNumByPlanId(Integer id);

    /**
     * 当用户点赞之后,对应的计划点赞数加 1
     * @param pid
     */
    void addThumpNum(Integer pid);

    /**
    * 方法实现说明  根据planId查询对应的点赞信息
    * @author      cyf
    * @param planId
    * @return
    */
    Thump findByPlanId(Integer planId);


    /**
     * 当用户再次点赞之后,对应的计划点赞数加 -1
     * @param pid
     */
    void subThumpNum(Integer pid);
}
