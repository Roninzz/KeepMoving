package com.keepmoving.fitness.service.impl.login;

import com.keepmoving.fitness.entity.login.UserInfo;
import com.keepmoving.fitness.mapper.login.UserInfoMapper;
import com.keepmoving.fitness.mapper.personInfo.IUserBaseInfoMapper;
import com.keepmoving.fitness.service.login.IUserInfoService;
import com.keepmoving.fitness.util.sendsms.snowflake.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.KrbCryptoException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.UUID;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUserBaseInfoMapper userBaseInfoMapper;

    //查找所有
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }

    //根据手机号查询
    @Override
    public UserInfo findByPhone(String phone) {
        return userInfoMapper.findByPhone(phone);
    }

    //插入一条
    @Override
    public void addUserInfo(UserInfo userInfo) {

        System.out.println("原密码为：" + userInfo.getPassword());
        //密码加密begin
        String password = passwordEncoder.encode(userInfo.getPassword());
        System.out.println("加密后的密码为：" + password);
        userInfo.setPassword(password);//将加密完的密码重新设置到userInfo中
        //密码加密end

//        //该方法判断输入的密码与加密后的密码是否一致
//        passwordEncoder.matches("输入的密码","加密后的密码");

//        雪花算法生成userId
        SnowFlake worker = new SnowFlake(1,1,1);
        userInfo.setUserId(worker.nextId());
//        雪花算法生成userId

        userInfoMapper.addUserInfo(userInfo);
        userBaseInfoMapper.addUserBaseInfo(userInfo);
    }

    @Override
    public int editPwd(String password, String phone) {
        return userInfoMapper.editPwd(password, phone);
    }

    @Override
    public int editVerify(String verify, String phone) {
        // TODO Auto-generated method stub
        return userInfoMapper.editVerify(verify, phone);

    }
}
