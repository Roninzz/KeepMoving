package com.keepmoving.fitness.service.login;

import com.keepmoving.fitness.entity.login.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface IUserInfoService {
    //查找所有
    List<UserInfo> findAll();

    //根据手机号查询
    UserInfo findByPhone(String phone);

    //插入一条
    void addUserInfo(UserInfo userInfo);

    int editPwd(String password,String phone);

    int editVerify(String verify,String phone);
}
