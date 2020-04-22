package com.xmb.workout.workout.service.impl;

import com.xmb.workout.workout.dto.StatisticsEachTypeDTO;
import com.xmb.workout.workout.vo.StatisticsEachTypeVO;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmb.workout.workout.dao.WorkoutRecordDetailDao;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.xmb.workout.workout.service.WorkoutRecordDetailService;


@Service("workoutRecordDetailService")
public class WorkoutRecordDetailServiceImpl extends ServiceImpl<WorkoutRecordDetailDao, WorkoutRecordDetailEntity> implements WorkoutRecordDetailService {

    @Override
    public List<StatisticsEachTypeVO> statisticsByTimeAndType(StatisticsEachTypeDTO statisticsEachTypeDTO) {
        return this.baseMapper.statisticsByTimeAndType(statisticsEachTypeDTO);
    }
}