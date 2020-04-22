package com.xmb.workout.workout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmb.workout.workout.dto.StatisticsEachTypeDTO;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.xmb.workout.workout.vo.StatisticsEachTypeVO;

import java.util.List;

/**
 * 训练项目表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
public interface WorkoutRecordDetailService extends IService<WorkoutRecordDetailEntity> {

    List<StatisticsEachTypeVO> statisticsByTimeAndType(StatisticsEachTypeDTO statisticsEachTypeDTO);
}

