package com.keepmoving.fitness.service.vo;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.vo.ReplyVo;

import java.util.List;
import java.util.Map;

/**
 * 用户回复的第三方service层
 * 用来连接评论表和回复表之间的关系
 */
public interface IUserReplyServiceVo {


    /**
     * 根据回复的用户id查询对应的回复信息并进行分页
     * @param uid 用户id
     * @param pageNum 当前页
     * @param pageSize 每页显示的条数
     * @return 分页的结果
     */
    // PageInfo<Reply> getUserReplyInfoByUserId(Integer uid, Integer pageNum, Integer pageSize);

    Map<String,Object> getUserReplyInfoByUserId(Long uid, Integer pageNum, Integer pageSize);
}
