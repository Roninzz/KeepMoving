package com.keepmoving.fitness.service.personcenter;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Reply;
import java.util.List;

/**
 * 回复的service层接口
 */

public interface IReplyService {

    /**
     * 查询所有的回复信息
     * @return 所有的回复
     */
    List<Reply> findAllReply();

    /**
     * 根据回复的用户id查询对应的回复信息
     * @param uid 用户的id
     * @return 用户的回复信息,用户可能会有多条计划,因此使用集合来接受数据
     */
    List<Reply> getReplyByUserId(Long uid);


    /**
     * 根据评论id查询评论下面的回复信息
     * @param cid 用户的id
     * @return 用户的回复信息
     */
    List<Reply> getReplyByCommentId(Integer cid);


    /**
     * 存储用户的回复信息
     */
    void saveUserReply(Reply reply);

    /**
     * 当用户删除自己的回复时,将对应的状态码改成 1
     * @param id 用户id
     */
    void updateUserReply(Reply reply);

}
