package com.keepmoving.fitness.service.personcenter;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Comment;

import java.util.List;
import java.util.Map;

/**
 * 评论的service层接口
 */
public interface ICommentService {

    /**
     * 查询一个计划的所有的评论信息
     * @param pid 计划id
     * @return 对应计划的所有评论信息
     */
    List<Comment> findAllCommentsByPlanId(Integer pid);

    /**
     * 根据用户id查询对应的评论信息
     * @param uid 用户的id
     * @return 用户的评论信息,用户可能会有多条计划,因此使用集合来接受数据
     */
    List<Comment> getCommentByUserId(Long uid);

    /**
     * 根据用户查询出来的评论信息进行分页
     * @param uid 用户id
     * @param pageNum  当前页
     * @param pageSize 每页显示的条数
     * @return 分页的结果
     */
    Map<String,Object> getCommentByUserId(Long uid, Integer pageNum, Integer pageSize);

//    Map<String,Object>

    /**
     * 存储用户的评论信息
     */
    void saveUserComment(Comment comment);

    /**
     * 当用户删除自己的评论时,将对应的状态码改成 1
     * @param uid 用户id
     * @param pid 计划id
     */
    void updateUserComment(Long uid, Integer pid);

    /**
     * 根据id查询对应的评论信息
     * @param id 评论表的主键id
     * @return
     */
    String getCommentById(Integer id);

    /**
     * 查询用户的单条评论信息
     * @param pid 计划id
     * @param uid 用户id
     * @return 用户对某条计划的评论信息
     */
    Comment getUserCommentByPlanIdAndUserId(Integer pid,Long uid);


    /**
     * 根据评论id查询出对应的评论信息
     * @param cid
     * @return
     */
    Comment findCommentByCommentId(Integer cid);
}
