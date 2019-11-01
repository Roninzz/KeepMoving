package com.keepmoving.fitness.mapper.personInfo;

import com.keepmoving.fitness.entity.personInfo.UserImgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface IUserImgsMapper {


    //查询用户头像
    @Select("select * from user_imgs where user_id = #{userid}")
    UserImgs getPhotoByUserId(Long userid);

    @Select("select count(*) from user_imgs where user_id = #{userid}")
    Long getCount(Long userid);

    @Update("update user_imgs set img_url = #{u.imgUrl} where user_id = #{u.userId}")
    void UpdateByUserId(@Param("u") UserImgs u);

    @Insert("insert into user_imgs (img_url, create_time, user_id) values (u.imgUrl,now(),u.userId)")
    void addByImg(@Param("u") UserImgs u);


}
