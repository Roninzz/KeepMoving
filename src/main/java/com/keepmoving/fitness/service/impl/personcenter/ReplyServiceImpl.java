package com.keepmoving.fitness.service.impl.personcenter;

import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.mapper.personcenter.IReplyMapper;
import com.keepmoving.fitness.service.personcenter.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 回复的service层实现类
 */
@Service
public class ReplyServiceImpl implements IReplyService {

    @Autowired
    private IReplyMapper replyMapper;

    /**
     * 查询所有的回复
     * @return
     */
    @Override
    public List<Reply> findAllReply() {
        return replyMapper.findAllReply();
    }

    /**
     * 根据用户的id查询对应的回复内容
     * @param uid 用户的id
     * @return
     */
    @Override
    public List<Reply> getReplyByUserId(Long uid) {
        return replyMapper.getReplyByUserId(uid);
    }

    /**
     * 查询一个评论下面的所有回复信息
     * @param cid 用户的id
     * @return
     */
    @Override
    public List<Reply> getReplyByCommentId(Integer cid) {
        return replyMapper.getReplyByCommentId(cid);
    }

    /**
     * 存储用户的回复内容
     * @param reply
     */
    @Override
    public void saveUserReply(Reply reply) {
        replyMapper.saveUserReply(reply);
    }

    /**
     * 当用户在页面执行删除评分操作之后,在后台执行更新操作,将对应的状态码改为 1
     * @param reply
     */
    @Override
    public void updateUserReply(Reply reply) {
        replyMapper.updateUserReply(reply);
    }
}
