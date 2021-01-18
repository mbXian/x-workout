package com.xmb.workout.log.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.log.entity.ApiLogEntity;
import com.xmb.workout.workout.dto.QueryStartOrEndTimeDTO;
import com.xmb.workout.workout.dto.StatisticsDurationAndTimesDTO;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.vo.StatisticsDurationAndTimesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Api日志记录记录表
 * 
 * @author Ben
 * @email 
 * @date 2021-01-18 15:30:30
 */
@Mapper
public interface ApiLogDao extends BaseMapper<ApiLogEntity> {


}
