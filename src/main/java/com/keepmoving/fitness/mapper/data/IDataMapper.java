package com.keepmoving.fitness.mapper.data;

import com.keepmoving.fitness.dto.FitTimeDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDataMapper extends MongoRepository<FitTimeDTO,String> {
}
