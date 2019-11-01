package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personcenter.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author:Kenny
 * @version:1.0
 * @description:测试回复mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIReplyMapper {

    @Autowired
    private IReplyMapper replyMapper;

    @Autowired
    private Reply reply;

    /**
     * 查询所有的回复
     */
    @Test
    public void testFindAllReply(){
        replyMapper.findAllReply().forEach(System.out::println);
    }

    /**
     * 根据用户id查询对应的回复
     */
    @Test
    public void testGetReplyByUserId(){
        replyMapper.getReplyByUserId((long) 2).forEach(System.out::println);
    }

    /**
     * 根据计划id查询对应的回复
     */
    @Test
    public void testGetReplyByCommentId(){
        replyMapper.getReplyByCommentId(1).forEach(System.out::println);
    }


    /**
     * 添加用户回复
     */
    @Test
    public void testSaveUserReply(){
        reply.setCommentId(3);
        reply.setReplyUser((long) 2);
        reply.setReplyContent("人生有梦,各自精彩.");
        reply.setReplyTime(new Date(2019,2,2));
        reply.setStatus(2);
        replyMapper.saveUserReply(reply);
    }

    @Test
    public void testUpdateUserReply(){
        reply.setReplyUser((long) 2);
        reply.setStatus(1);
        replyMapper.updateUserReply(reply);
        replyMapper.getReplyByUserId((long) 2).forEach(System.out::println);
    }


}
