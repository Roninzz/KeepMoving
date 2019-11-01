package com.keepmoving.fitness.mapper.personcenter;


import com.keepmoving.fitness.entity.personcenter.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 评论实体类mapper
 */
public interface ICommentMapper {

    /**
     * 查询一个计划的所有的评论信息
     * @param pid 计划id
     * @return 对应计划的所有评论信息
     */
    @Select("select id,user_id,plan_id,content,create_time,status from comment where plan_id = #{pid}")
    List<Comment> findAllComments(Integer pid);

    /**
     * 根据用户id查询对应的评论信息
     * @param id 用户的id
     * @return 用户的评论信息,用户可能会有多条计划,因此使用集合来接受数据
     */
    @Select("select user_id,plan_id,content,create_time,status from comment where user_id=#{uid}")
    List<Comment> getCommentByUserId(Long uid);

    /**
     * 存储用户的评论信息
     */

    @Insert("insert into comment(user_id,plan_id,content,create_time,status) values (#{userId},#{planId},#{content},#{createTime},#{status})")
    void saveUserComment(Comment comment);

    /**
     * 当用户删除自己的评论时,将对应的状态码改成 1
     * @param uid 用户id
     * @param pid 计划id
     */
    @Update("update comment set status = 1 where user_id = #{uid} and plan_id = #{pid}")
    void updateUserComment(Long uid, Integer pid);

    /**
     * 根据评论id获取评论内容
     * @param id 评论表的主键id
     * @return
     */
    @Select("select content from comment where id = #{id}")
    String getCommentById(Integer id);

    /**
     * 根据评论id查询出对应的评论信息
     * @param cid
     * @return
     */
    @Select("select user_id,plan_id,content,create_time,status from comment where id = #{cid}")
    Comment findCommentByCommentId(Integer cid);

    /**
     * 查询用户的单条评论信息
     * @param pid 计划id
     * @param uid 用户id
     * @return 用户对某条计划的评论信息
     */
    @Select("select user_id,plan_id,content,create_time,status from comment where user_id=#{uid} and plan_id = #{pid}")
    Comment getUserCommentByPlanIdAndUserId(Integer pid,Long uid);
}
