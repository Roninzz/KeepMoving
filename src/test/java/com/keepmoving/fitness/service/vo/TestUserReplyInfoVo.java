package com.keepmoving.fitness.service.vo;

import com.github.pagehelper.PageInfo;
import com.keepmoving.fitness.entity.personcenter.Reply;
import com.keepmoving.fitness.vo.ReplyVo;
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
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserReplyInfoVo {

    @Autowired
    private IUserReplyServiceVo userReplyServiceVo;


    /**
     * 测试封装回复数据的第三方实体类
     */
    @Test
    public void testgetUserReplyInfoByUserId(){
        Map<String,Object> map = userReplyServiceVo.getUserReplyInfoByUserId((long) 1,1,2);
        List<ReplyVo> replyVoList = (List<ReplyVo>) map.get("replyVoList");
        replyVoList.forEach(System.out::println);
    }

    /**
     * 测试回复的第三方实体类的分页功能
     */
    @Test
    public void testgetUserReplyInfoByUserIdPage(){

        Map<String,Object> map = userReplyServiceVo.getUserReplyInfoByUserId((long) 1,1,2);
        PageInfo<Reply> replyPageInfo = (PageInfo<Reply>) map.get("replyPageInfo");
        // 当前页
        System.out.println(replyPageInfo.getPageNum());
        // 每页显示的条数
        System.out.println(replyPageInfo.getPageSize());
        // 总的条数
        System.out.println(replyPageInfo.getPages());
    }
}
