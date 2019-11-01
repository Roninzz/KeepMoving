package com.keepmoving.fitness.service.personcenter;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Comment;
import com.keepmoving.fitness.service.impl.personcenter.CommentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 用户评论的service层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommentService {

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private Comment comment;

    /**
     * 测试查询一个计划的所有评论
     */
    @Test
    public void testFindAllCommentsByPlanId(){
        commentService.findAllCommentsByPlanId(2).forEach(System.out::println);
    }

    /**
     * 测试根据用户id对一个用户的评论信息
     */
    @Test
    public void testGetCommentByUserId(){
        commentService.getCommentByUserId(1184456049227337700L).forEach(System.out::println);
    }

    /**
     * 测试存储用户的评论信息
     */
    @Test
    public void testSaveUserComment(){
        comment.setUserId((long) 7);
        comment.setPlanId(2);
        comment.setContent("人们大多都对苗条匀称的身材抱有好感，想必也是因为他们能从对方身上感受到健康的活力和积极的态度。");
        comment.setCreateTime(new Date(1023,2,2));
        comment.setStatus(0);
        commentService.saveUserComment(comment);
    }

    /**
     * 测试当用户删除评论时,后天将对应的状态码改为1
     */
    @Test
    public void testUpdateUserComment(){
        commentService.updateUserComment((long) 1,1);
    }

    /**
     * 对分页进行测试
     */
    @Test
    public void testGetCommentByIdPage(){
        Map<String,Object> map = commentService.getCommentByUserId((long) 1,1,2);
        PageInfo<Comment> pageInfo = (PageInfo<Comment>) map.get("pageInfo");
        // 获取当前页
        System.out.println(pageInfo.getPageNum());
        // 每页显示的条数
        System.out.println(pageInfo.getPageSize());
        // 总的页数
        System.out.println(pageInfo.getPages());
    }


    /**
     * 测试根据评论的id查询对应的评论信息
     */
    @Test
    public void testFindCommentByCommentId(){
        System.out.println(commentService.findCommentByCommentId(1));
    }
}
