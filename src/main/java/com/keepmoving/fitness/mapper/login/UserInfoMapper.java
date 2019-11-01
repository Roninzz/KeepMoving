package com.keepmoving.fitness.mapper.login;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface UserInfoMapper {

    //查找所有
    @Select("select * from user_info")
    List<UserInfo> findAll();

    //根据手机号查询
    @Select("select * from user_info where phone = #{value}")
    UserInfo findByPhone(String phone);

    //插入一条
    @Insert("insert into user_info(user_id,username,phone,password) values(#{userInfo.userId},#{userInfo.username},#{userInfo.phone},#{userInfo.password})")
    void addUserInfo(@Param("userInfo") UserInfo userInfo);

    //修改密码
    @Update("update user_info set password = #{password} where phone = #{phone}")
    int editPwd(@Param("password")String password,@Param("phone")String phone);

    //开通验证
    @Update("update user_info set verify = #{verify} where phone = #{phone}")
    int editVerify(@Param("verify")String verify,@Param("phone")String phone);




}
