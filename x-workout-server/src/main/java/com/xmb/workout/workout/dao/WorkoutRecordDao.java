package com.xmb.workout.workout.dao;

import com.xmb.workout.workout.dto.QueryStartOrEndTimeDTO;
import com.xmb.workout.workout.dto.StatisticsDurationAndTimesDTO;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmb.workout.workout.vo.StatisticsDurationAndTimesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 训练记录表
 * 
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Mapper
public interface WorkoutRecordDao extends BaseMapper<WorkoutRecordEntity> {

    List<WorkoutRecordEntity> findAll(@Param("mobile") String mobile);

    StatisticsDurationAndTimesVO statisticsDurationAndTimes(@Param("dto") StatisticsDurationAndTimesDTO statisticsDurationAndTimesDTO);

    Date findStartOrEndTrainTime(@Param("dto") QueryStartOrEndTimeDTO queryStartOrEndTimeDTO);

    List<Date> findTrainTime(@Param("mobile") String mobile);

}
