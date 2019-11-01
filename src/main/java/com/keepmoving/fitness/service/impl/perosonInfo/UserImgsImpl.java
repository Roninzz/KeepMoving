package com.keepmoving.fitness.service.impl.perosonInfo;

import com.keepmoving.fitness.entity.personInfo.UserImgs;
import com.keepmoving.fitness.mapper.personInfo.IUserImgsMapper;
import com.keepmoving.fitness.service.personInfo.IUserImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserImgsImpl implements IUserImgsService {
    @Autowired
    private IUserImgsMapper userImgsMapper;

    @Override
    public UserImgs getPhotoByUserId(Long userid) {
        return userImgsMapper.getPhotoByUserId(userid);
    }

    @Override
    public void UpdateByUserId(UserImgs u) {
        userImgsMapper.UpdateByUserId(u);
    }

    @Override
    public void addByImg(UserImgs u) {
        userImgsMapper.addByImg(u);
    }

    @Override
    public Long getCount(Long userid) {
        return userImgsMapper.getCount(userid);
    }


}
