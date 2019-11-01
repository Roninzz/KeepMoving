package com.keepmoving.fitness.service.vo;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.vo.CommentVo;

import java.util.List;
import java.util.Map;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 封装计划对应的评论和回复的散列数据的service层接口
 */
public interface IPlanCommentServiceVo {

    /**
     * 获取计划对应的评论和回复信息
     * @param pid 计划id
     * @return
     */

    Map<String,Object> getPlanCommentByPlanId(Integer pid, Integer pageNum, Integer pageSize);
}
