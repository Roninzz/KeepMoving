package com.keepmoving.fitness.service.personcenter;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.service.impl.personcenter.ReplyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author:Kenny
 * @version:1.0
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReplyService {

    @Autowired
    private ReplyServiceImpl replyService;

    @Autowired
    private Reply reply;

    /**
     * 查询所有的评论
     */
    @Test
    public void testFindAllReply(){
        replyService.findAllReply().forEach(System.out::println);
    }

    /**
     * 根据用户的id查询回复的内容
     */
    @Test
    public void testGetReplyByUserId(){
        replyService.getReplyByUserId((long) 1).forEach(System.out::println);
    }

    /**
     * 根据评论id来获取回复内容
     */
    @Test
    public void GetReplyByCommentId(){
        replyService.getReplyByCommentId(2).forEach(System.out::println);
    }

    @Test
    public void testSaveUserReply(){
        reply.setCommentId(3);
        reply.setReplyUser((long) 2);
        reply.setReplyContent("人生有梦,各自精彩.");
        reply.setReplyTime(new Date(2019,2,2));
        reply.setStatus(2);
        replyService.saveUserReply(reply);
    }

    @Test
    public void testUpdateUserReply(){
        reply.setReplyUser((long) 4);
        reply.setStatus(1);
        replyService.updateUserReply(reply);
    }



}
