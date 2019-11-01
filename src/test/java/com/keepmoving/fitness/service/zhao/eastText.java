package com.keepmoving.fitness.service.zhao;


import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.entity.personcenter.UserScore;
import com.keepmoving.fitness.mapper.courseList.ICourseMapper;
import com.keepmoving.fitness.mapper.coursedetail.CourseImgMapper;
import com.keepmoving.fitness.mapper.personInfo.IUserBaseInfoMapper;
import com.keepmoving.fitness.mapper.personInfo.IUserImgsMapper;
import com.keepmoving.fitness.mapper.personcenter.IUserScoreMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class eastText {

    @Autowired

    private IUserImgsMapper userImgs;
    @Test
    public void contextLoads1() {
//        userImgs.UpdateByUserId(1,"222222222222");
    }

    @Autowired

    private IUserBaseInfoMapper userBaseInfo;
    @Test
    public void contextLoads2() {
        System.out.println(userBaseInfo.findByUserId((long) 1));

    }


    @Test

    public void contextLoad3(){
        UserBaseInfo u= new UserBaseInfo();
        u.setBirthday(new Date(20190101L));
        u.setUsername("jack");
        u.setCity("苏州");
        u.setGender("女");
        u.setHeight((float) 11);
        u.setWeight((float) 111);
        u.setSignature("jdskjdhskdjghashdgjk");

        userBaseInfo.updateByUserId((long) 1,u);
    }

    @Autowired
    private ICourseMapper course;

    @Test
    public void contextLoad4(){
        course.findByDayId("1",1).forEach(System.out::println);
    }

    @Autowired
    private CourseImgMapper courseImgsMapper;

    @Test
    public void contextLoad5(){
        System.out.println(courseImgsMapper.findByCourseId(2));
    }


    @Autowired
    private IUserScoreMapper userScoreMapper;

    @Test
    public void savescore(){
        UserScore u = new UserScore();

        u.setUserId((long) 8);
        u.setPlanId(2);
        u.setScore(5.0);

        userScoreMapper.savePlanScore(u);
    }


}
