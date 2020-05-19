package com.xmb.workout.workout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryDTO;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.vo.ToNowStatisticsVO;
import com.xmb.workout.workout.vo.TodayStatisticsVO;

/**
 * 训练记录表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
public interface WorkoutRecordService extends IService<WorkoutRecordEntity> {

    /**
     * 临时登记
     *
     */
    void enterDailyDataTemporary(WorkoutRecordEnterDailyTemporaryDTO workoutRecordEnterDailyTemporaryDTO, SysUserEntity sysUserEntity);

    TodayStatisticsVO todayStatistics(SysUserEntity sysUserEntity);

    ToNowStatisticsVO toNowStatistics(SysUserEntity sysUserEntity);
}

