package com.keepmoving.fitness.service.vo;

import com.keepmoving.fitness.vo.CommentVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author:Kenny
 * @version:1.0
 * @description: 每个计划对应评论和回复信息
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlanCommentServiceImplVo {

    @Autowired
    private IPlanCommentServiceVo planCommentServiceVo;

    @Test
    public void testGetPlanCommentByPlanId(){
        Map<String,Object> commentMap = planCommentServiceVo.getPlanCommentByPlanId(1,1,2);
        List<CommentVo> commentVoList = (List<CommentVo>) commentMap.get("commentVoList");
        commentVoList.forEach(System.out::println);
    }
}
