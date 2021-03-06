package com.xmb.workout.workout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryBaseDTO;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.vo.*;

import java.util.List;

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
    Boolean enterDailyDataTemporary(WorkoutRecordEnterDailyTemporaryBaseDTO workoutRecordEnterDailyTemporaryDTO, SysUserEntity sysUserEntity) throws Exception;

    /**
     * 今日数据统计
     * @param sysUserEntity
     * @return
     */
    TodayStatisticsVO todayStatistics(SysUserEntity sysUserEntity);

    /**
     * 目前数据统计
     * @param sysUserEntity
     * @return
     */
    ToNowStatisticsVO toNowStatistics(SysUserEntity sysUserEntity);

    /**
     * 所有的锻炼项目
     * @return
     */
    List<WorkoutTypeVO> workoutTypeList();

    /**
     * 过期n天训练饱和率
     * @param sysUserEntity
     * @param days
     */
    WorkoutDaysSaturationVO daysSaturation(SysUserEntity sysUserEntity, Integer days);

    /**
     * 已连续锻炼天数
     * @param sysUserEntity
     * @return
     */
    WorkoutKeepOnDaysVO keepOnDays(SysUserEntity sysUserEntity);

}

