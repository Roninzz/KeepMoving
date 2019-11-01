package com.keepmoving.fitness.mapper.personInfo;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IUserBaseInfoMapper {

    //查询用户信息
    @Select("select * from user_base_info where user_id = #{value}")
    UserBaseInfo findByUserId(Long userid);


    //更新用户信息 除id
    @Update("update user_base_info set username = #{u.username},gender = #{u.gender},birthday=#{u.birthday},city=#{u.city},height=#{u.height},weight=#{u.weight},signature=#{u.signature} where user_id = #{userid}")
    void updateByUserId( @Param("userid") Long userid, @Param("u") UserBaseInfo userBaseInfo);


    //   <if test='record.moviename!= null'>and moviename like #{record.moviename}</if>
    @Update("update user_base_info set height=#{u.height}, weight=#{u.weight} where user_id = #{u.userId}")
    Long editUserByUserId(@Param("u") UserBaseInfo userBaseInfo);

    @Update("update user_base_info set username = #{u.username},gender = #{u.gender},birthday=#{u.birthday},city=#{u.city} where user_id = #{u.userId}")
    Long editAllByUserId(@Param("u") UserBaseInfo userBaseInfo);

    @Update("update user_info set username = #{u.username} where user_id = #{u.userId}")
    Long editByUserId(@Param("u") UserBaseInfo userBaseInfo);


    //插入一条
    @Insert("insert into user_base_info(user_id,username) values(#{user.userId},#{user.username})")
    void addUserBaseInfo(@Param("user") UserInfo userInfo);
}
