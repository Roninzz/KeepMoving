package com.keepmoving.fitness.coursedetail;

import com.keepmoving.fitness.service.coursedetail.IVediosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VediosTests {

    @Autowired
    private IVediosService vediosService;

    @Test
    public void contextLoads() {

//      System.out.println(userInfoMapper.findAll());
//      System.out.println(userInfoMapper.findByPhone("18806203574"));

        System.out.println("======");
//        System.out.println(courseService.findAll());
        System.out.println("======");
        System.out.println(vediosService.findAll());
        System.out.println("======");
        System.out.println(vediosService.findBycourseId(2));
    }

}
