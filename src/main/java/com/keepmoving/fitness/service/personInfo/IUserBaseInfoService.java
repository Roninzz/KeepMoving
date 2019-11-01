package com.keepmoving.fitness.service.personInfo;

import com.keepmoving.fitness.entity.personInfo.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

public interface IUserBaseInfoService {


    UserBaseInfo findByUserId(Long userid);


    Long editUserByUserId(UserBaseInfo userBaseInfo);

    Long editAllByUserId(UserBaseInfo userBaseInfo);

    Long editByUserId(UserBaseInfo userBaseInfo);

}
