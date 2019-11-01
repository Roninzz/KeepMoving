package com.keepmoving.fitness.service.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.Vedios;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface IVediosService {

    //查询所有
    List<Vedios> findAll();

    //根据Id查
    Vedios findById(Integer id);

    //根据courseId查询
    Vedios findBycourseId(Integer courseId);
}
