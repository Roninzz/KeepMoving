package com.keepmoving.fitness.service.impl.personcenter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Comment;
import com.keepmoving.fitness.mapper.personcenter.ICommentMapper;
import com.keepmoving.fitness.service.personcenter.ICommentService;
import com.keepmoving.fitness.service.plan.IPlansService;
import com.keepmoving.fitness.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 评论的service接口实现类
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentMapper commentMapper;

    @Autowired
    private IPlansService plansService;

    /**
     * 获取对应计划的id的所有评论信息
     * @param pid 计划id
     * @return
     */
    @Override
    public List<Comment> findAllCommentsByPlanId(Integer pid){
        return commentMapper.findAllComments(pid);
    }

    /**
     * 根据用户id查询对应的评论信息
     * @param uid 用户的id
     * @return 用户的评论信息,用户可能会有多条计划,因此使用集合来接受数据
     */
    @Override
    public List<Comment> getCommentByUserId(Long uid){
        return commentMapper.getCommentByUserId(uid);
    }

    @Override
    public Map<String,Object> getCommentByUserId(Long uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> comments = commentMapper.getCommentByUserId(uid);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);

        // 获取用户的评论信息
        List<Comment> commentList = pageInfo.getList();
        List<CommentVo> commentVoList = new ArrayList<>();

        // 创建封装数据的第三方实体类
        CommentVo commentVo = null;

        // 创建一个日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 遍历集合并将数据封装到第三方实体类中
        for (Comment c : commentList) {
            commentVo = new CommentVo();
            commentVo.setContent(c.getContent());
            Date date = c.getCreateTime();
            String time = sdf.format(date);
            commentVo.setDate(time);
            String pName = plansService.getPlanNameById(c.getPlanId());
            commentVo.setPlanName(pName);
            commentVoList.add(commentVo);
        }

        Map<String,Object> map = new HashMap<>();
        map.put("commentVoList",commentVoList);
        map.put("pageInfo",pageInfo);

        return map;
    }

    /**
     * 存储用户的评论信息
     * @param comment 用户实体类
     */
    @Override
    public void saveUserComment(Comment comment){
        commentMapper.saveUserComment(comment);
    }

    /**
     * 当用户删除自己的评论时,将对应的状态码改成 1
     * @param uid 用户id
     * @param pid 计划id
     */
    @Override
    public void updateUserComment(Long uid, Integer pid){
        commentMapper.updateUserComment(uid,pid);
    }

    @Override
    public String getCommentById(Integer id) {
        return commentMapper.getCommentById(id);
    }

    @Override
    public Comment getUserCommentByPlanIdAndUserId(Integer pid, Long uid) {
        return commentMapper.getUserCommentByPlanIdAndUserId(pid,uid);
    }

    @Override
    public Comment findCommentByCommentId(Integer cid) {
        return commentMapper.findCommentByCommentId(cid);
    }
}
