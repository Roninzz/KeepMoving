package com.keepmoving.fitness.service.impl.coursedetail;

import com.keepmoving.fitness.entity.coursedetail.Vedios;
import com.keepmoving.fitness.mapper.coursedetail.VediosMapper;
import com.keepmoving.fitness.service.coursedetail.IVediosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CYF;
 * @date 2019/9/28.
 */
@Service
@Transactional
public class VediosServiceImpl implements IVediosService {

    @Autowired
    private VediosMapper vediosMapper;

    @Override
    public List<Vedios> findAll() {
        return vediosMapper.findAll();
    }

    @Override
    public Vedios findById(Integer id) {
        return vediosMapper.findById(id);
    }

    @Override
    public Vedios findBycourseId(Integer courseId) {
        return vediosMapper.findBycourseId(courseId);
    }
}
