package com.keepmoving.fitness.service.personInfo;

import com.keepmoving.fitness.entity.personInfo.UserImgs;

public interface IUserImgsService {
    UserImgs getPhotoByUserId(Long userid);

    Long getCount(Long userid);

    void UpdateByUserId(UserImgs u);

    void addByImg(UserImgs u);
}
