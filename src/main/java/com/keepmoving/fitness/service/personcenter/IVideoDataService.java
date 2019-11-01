package com.keepmoving.fitness.service.personcenter;

import com.keepmoving.fitness.dto.FitTimeDTO;

import java.util.List;

/**
 * @author Kenny
 * @description 存储用户观看视频数据接口
 */
public interface IVideoDataService {

    /**
     * 存储用户的视频数据
     * @param fitTimeDTO
     */
    void saveData(FitTimeDTO fitTimeDTO);

    /**
     * 根据用户id查询用户观看视频的数据
     * @param uid
     * @return
     */
    List<FitTimeDTO> getDataByUserId(String uid);

    /**
     * 更新每天的计划时间
     * @param fitTimeDTO
     */
    void updateDate(FitTimeDTO fitTimeDTO);
}
