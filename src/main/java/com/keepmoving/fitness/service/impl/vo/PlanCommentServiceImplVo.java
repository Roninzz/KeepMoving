package com.keepmoving.fitness.service.impl.vo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personInfo.UserImgs;
import com.keepmoving.fitness.entity.personcenter.Comment;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import com.keepmoving.fitness.service.personInfo.IUserImgsService;
import com.keepmoving.fitness.service.personcenter.ICommentService;
import com.keepmoving.fitness.service.personcenter.IReplyService;
import com.keepmoving.fitness.service.vo.IPlanCommentServiceVo;
import com.keepmoving.fitness.vo.CommentVo;
import com.keepmoving.fitness.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用来封装评论和回复信息的service层接口实现类
 */
@Service
public class PlanCommentServiceImplVo implements IPlanCommentServiceVo {

    /**
     * 评论的service层实现类
     */
    @Autowired
    private ICommentService commentService;

    /**
     * 回复的service层实现类
     */
    @Autowired
    private IReplyService replyService;

    /**
     * 用户图片的service层实现类
     */
    @Autowired
    private IUserImgsService userImgsService;

    /**
     * 用户基本信息的service层实现类
     */
    @Autowired
    private IUserBaseInfoService userBaseInfoService;

    /**
     * 用户基本信息
     */
    @Autowired
    private UserBaseInfo userBaseInfo;

    /**
     * 评论的第三方实体类
     */
    private CommentVo commentVo;

    /**
     * 回复的第三方实体类
     */
    private ReplyVo replyVo;

    /**
     * 用户头像信息
     */
    @Autowired
    private UserImgs userImgs;

    /**
     * 格式化日期
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Map<String,Object> getPlanCommentByPlanId(Integer pid, Integer pageNum, Integer pageSize) {
        // 对评论进行分页
        PageHelper.startPage(pageNum,pageSize);
        // 获取计划的所有评论信息
        List<Comment> comments = commentService.findAllCommentsByPlanId(pid);
        PageInfo<Comment> commentPageInfo = new PageInfo<>(comments);

        List<CommentVo> commentVoList = new ArrayList<>();

        List<Comment> commentList = commentPageInfo.getList();

        if (null != commentList){
            for (Comment comment : commentList) {
                commentVo = new CommentVo();
                // 评论id
                commentVo.setCid(comment.getId());
                // 用户的评论信息
                commentVo.setContent(comment.getContent());
                // 用户的评论时间
                Date date = comment.getCreateTime();
                String timeFormat = sdf.format(date);
                commentVo.setDate(timeFormat);
                // 用户的名称
                Long userId = comment.getUserId();
                // 从用户信息中查询出用户的名称
                userBaseInfo = userBaseInfoService.findByUserId(userId);
                commentVo.setCommentUserName(userBaseInfo.getUsername());
                // 从用户头像表中获取用户头像
                userImgs = userImgsService.getPhotoByUserId(userId);
                commentVo.setCommentUserImg(userImgs.getImgUrl());
                // 获取相关的回复信息
                commentVo.setReplyVoList(getReplyVoList(comment.getId()));
                commentVoList.add(commentVo);
            }
        }
        Map<String,Object> map = new HashMap<>(16);
        map.put("commentVoList",commentVoList);
        map.put("commentPageInfo",commentPageInfo);

        return map;
    }

    /**
     * 根据评论用户id获取相关的回复信息
     * @param commentId 用户id
     * @return
     */
    public List<ReplyVo> getReplyVoList(Integer commentId){
        List<ReplyVo> replyVoList = new ArrayList<>();

        // 根据评论id查询相关的回复信息
        List<Reply> replyList = replyService.getReplyByCommentId(commentId);
        // 遍历回复的数据
       if (replyList != null){
           for (Reply reply : replyList) {
               // 创建第三方回复实体类对象
               replyVo = new ReplyVo();
               // 获取回复时间
               replyVo.setReplyDate(sdf.format(reply.getReplyTime()));
               // 获取回复内容
               replyVo.setReplyContent(reply.getReplyContent());
               // 获取回复的用户信息
               userBaseInfo = userBaseInfoService.findByUserId(reply.getReplyUser());
               replyVo.setReplyUserName(userBaseInfo.getUsername());
               // 获取回复的用户头像
               userImgs = userImgsService.getPhotoByUserId(reply.getReplyUser());
               replyVo.setReplyUserImg(userImgs.getImgUrl());
               replyVoList.add(replyVo);
           }
       }
       return replyVoList;
    }
}
