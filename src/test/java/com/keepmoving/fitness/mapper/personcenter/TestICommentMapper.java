package com.keepmoving.fitness.mapper.personcenter;

import com.keepmoving.fitness.entity.personcenter.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 测试评论mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestICommentMapper {

    @Autowired
    private ICommentMapper commentMapper;

    @Autowired
    private Comment comment;

    /**
     * 测试所有评论
     */
    @Test
    public void testFindAllComments(){
        commentMapper.findAllComments(1).forEach(System.out::println);
    }

    /**
     * 测试每个用户对不同计划的评论
     */
    @Test
    public void testGetCommentByUserId(){
        commentMapper.getCommentByUserId((long) 1).forEach(System.out::println);
    }

    /**
     * 测试存储用户的评论
     */
    @Test
    public void testSaveUserComment(){
        comment.setUserId((long) 4);
        comment.setPlanId(2);
        comment.setContent("打造背部宽度最经典动作，一起来看看学习吧。");
        comment.setCreateTime(new Date(2019,3,12));
        comment.setStatus(0);
        commentMapper.saveUserComment(comment);
    }

    /**
     * 测试--当用户删除评分时,将对应的状态码改为1
     */
    @Test
    public void testUpdateUserComment(){
        commentMapper.updateUserComment((long) 1,5);
    }

    /**
     * 根据评论表的主键id获取对应的评论信息
     */
    @Test
    public void testGetCommentById(){
        System.out.println(commentMapper.getCommentById(1));
    }

    /**
     * 测试根据评论的id查询对应的评论内容
     */
    @Test
    public void testGetUserCommentByPlanIdAndUserId(){
        System.out.println(commentMapper.getUserCommentByPlanIdAndUserId(2, (long) 2));
    }

    /**
     * 测试根据评论的id查询对应的评论信息
     */
    @Test
    public void testFindCommentByCommentId(){
        System.out.println(commentMapper.findCommentByCommentId(1));
    }





}
