package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personcenter.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 回复mapper
 */
public interface IReplyMapper {
    /**
     * 查询所有的回复信息
     * @return 所有的回复
     */
    @Select("select comment_id,reply_user,reply_content,reply_time,status from reply")
    List<Reply> findAllReply();

    /**
     * 根据回复的用户id查询对应的回复信息
     * @param uid 用户的id
     * @return 用户的回复信息,用户可能会有多条计划,因此使用集合来接受数据
     */
    @Select("select comment_id,reply_user,reply_content,reply_time,status from reply where reply_user = #{uid}")
    List<Reply> getReplyByUserId(Long uid);

    /**
     * 根据评论id查询评论下面的回复信息
     * @param cid 用户的id
     * @return 用户的回复信息
     */
    @Select("select comment_id,reply_user,reply_content,reply_time,status from reply where comment_id = #{cid}")
    List<Reply> getReplyByCommentId(Integer cid);


    /**
     * 存储用户的回复信息
     */
    @Insert("insert into reply(comment_id,reply_user,reply_content,reply_time,status) values (#{commentId},#{replyUser},#{replyContent},#{replyTime},#{status})")
    void saveUserReply(Reply reply);

    /**
     * 当用户删除自己的回复时,将对应的状态码改成 1
     * @param id 用户id
     */
    @Update("update reply set status = 1 where reply_user = #{replyUser}")
    void updateUserReply(Reply reply);

}
