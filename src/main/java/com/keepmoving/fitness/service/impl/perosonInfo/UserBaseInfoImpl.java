package com.keepmoving.fitness.service.impl.perosonInfo;

import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import com.keepmoving.fitness.mapper.personInfo.IUserBaseInfoMapper;
import com.keepmoving.fitness.service.personInfo.IUserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserBaseInfoImpl implements IUserBaseInfoService {
    @Autowired
    private IUserBaseInfoMapper userBaseInfoMapper;

    @Override
    public UserBaseInfo findByUserId(Long userid) {

        return userBaseInfoMapper.findByUserId(userid);
    }

    @Override
    public Long editUserByUserId(UserBaseInfo userBaseInfo) {
        return userBaseInfoMapper.editUserByUserId(userBaseInfo);
    }

    @Override
    public Long editAllByUserId(UserBaseInfo userBaseInfo) {
        return userBaseInfoMapper.editAllByUserId(userBaseInfo);
    }

    @Override
    public Long editByUserId(UserBaseInfo userBaseInfo) {
        return userBaseInfoMapper.editByUserId(userBaseInfo);
    }
}
