package com.xmb.workout.workout.dao;

import com.xmb.workout.workout.dto.StatisticsEachTypeDTO;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmb.workout.workout.vo.StatisticsEachTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 训练项目表
 * 
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Mapper
public interface WorkoutRecordDetailDao extends BaseMapper<WorkoutRecordDetailEntity> {

    List<StatisticsEachTypeVO> statisticsByTimeAndType(@Param("dto") StatisticsEachTypeDTO statisticsEachTypeDTO);
}
