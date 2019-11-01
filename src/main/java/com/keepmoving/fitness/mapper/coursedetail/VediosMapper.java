package com.keepmoving.fitness.mapper.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.Vedios;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
public interface VediosMapper {

    //查询所有
    @Select("select * from vedios")
    List <Vedios> findAll();

    //根据Id查
    @Select("select * from vedios where id = #{value}")
    Vedios findById(Integer id);

    //根据courseId查询
    @Select("select * from vedios where course_id = #{value}")
    Vedios findBycourseId(Integer courseId);
}
