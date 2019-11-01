package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.service.impl.personcenter.ThumpServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:Kenny
 * @version:1.0
 * @description:测试点赞的service层
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThumpService {

    @Autowired
    private ThumpServiceImpl thumpService;

    /**
     * 测试从mapper层获取计划的点赞数量
     */
    @Test
    public void testGetThumpNum(){
        System.out.println(thumpService.getThumpNumByPlanId(2));
    }

    /**
     * 测试当用户点赞之后,数据库中的对应计划点赞数量加 1
     */
    @Test
    public void testAddThumpNum(){
        thumpService.addThumpNum(1);
        // 查看点赞数量是否变化
        System.out.println(thumpService.getThumpNumByPlanId(1));
    }

}
