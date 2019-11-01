package com.keepmoving.fitness.service.impl.vo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.service.personcenter.ICommentService;
import com.keepmoving.fitness.service.personcenter.IReplyService;
import com.keepmoving.fitness.service.vo.IUserReplyServiceVo;
import com.keepmoving.fitness.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户回复内容的第三方实体类
 */
@Service
public class UserReplyServiceVoImpl implements IUserReplyServiceVo {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IReplyService replyService;


    @Override
    public Map<String,Object> getUserReplyInfoByUserId(Long uid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Reply> replies= replyService.getReplyByUserId(uid);
        PageInfo<Reply> replyPageInfo = new PageInfo<>(replies);

        // 存储回复的第三方实体类散列数据的集合
        List<ReplyVo> replyVoList = new ArrayList<>();

        ReplyVo replyVo = null;
        /**
         * 根据用户id获取回复的service层的相关信息
         */

        List<Reply> replyList = replyPageInfo.getList();

        // 初始化日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Reply r : replyList) {
            replyVo = new ReplyVo();
            // 获取对应的评论id
            Integer cid = r.getCommentId();
            // 根据评论id查询相关的评论内容
            String replyFromComment = commentService.getCommentById(cid);
            // 将获取的评论内容封装到第三方实体类中
            replyVo.setReplyFromComment(replyFromComment);
            // 获取回复的内容
            replyVo.setReplyContent(r.getReplyContent());
            // 获取回复的时间
            Date date = r.getReplyTime();
            String replyTime = sdf.format(date);
            // 封装回复的时间
            replyVo.setReplyDate(replyTime);
            // 将封装的数据存储到集合中
            replyVoList.add(replyVo);
        }

        // 使用map集合来封装回复的第三方实体类数据集合和分页集合;
        Map<String,Object> maps = new HashMap<>();
        maps.put("replyPageInfo",replyPageInfo);
        maps.put("replyVoList",replyVoList);

        return maps;
    }
}
