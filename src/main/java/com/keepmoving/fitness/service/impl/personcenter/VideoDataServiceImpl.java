package com.keepmoving.fitness.service.impl.personcenter;

import com.keepmoving.fitness.dto.FitTimeDTO;
import com.keepmoving.fitness.mapper.data.IDataMapper;
import com.keepmoving.fitness.service.personcenter.IVideoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author:Kenny
 * @version:1.0
 * @description:存储用户观看视频数据实现类
 */
@Service
public class VideoDataServiceImpl implements IVideoDataService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveData(FitTimeDTO fitTimeDTO) {
        mongoTemplate.insert(fitTimeDTO);
    }



    @Override
    public List<FitTimeDTO> getDataByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return  mongoTemplate.find(query,FitTimeDTO.class);
    }

    @Override
    public void updateDate(FitTimeDTO fitTimeDTO) {
        mongoTemplate.upsert(new Query(Criteria.where("userId").is(fitTimeDTO.getUserId())), new Update().set("date", fitTimeDTO.getTime()),FitTimeDTO.class);

    }
}
