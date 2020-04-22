package com.xmb.workout.workout.controller;

import java.util.List;

import com.xmb.workout.network.BaseController;
import com.xmb.workout.network.PageUtils;
import com.xmb.workout.network.Result;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryDTO;
import com.xmb.workout.workout.vo.ToNowStatisticsVO;
import com.xmb.workout.workout.vo.TodayStatisticsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.xmb.workout.workout.entity.WorkoutRecordEntity;
import com.xmb.workout.workout.service.WorkoutRecordService;

/**
 * 训练记录表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Api(description = "训练记录模块")
@RestController
@RequestMapping("workout/workoutrecord")
public class WorkoutRecordController extends BaseController {
    @Autowired
    private WorkoutRecordService workoutRecordService;

    /**
     * 列表
     */
    @ApiOperation(("训练记录列表"))
    @PostMapping("/list")
    public Result list(){
        List<WorkoutRecordEntity> list = workoutRecordService.list();

        return Result.ok(new PageUtils(list, list.size(), 10, 1));
    }

    @ApiOperation(value = "临时登记",notes = "临时登记",consumes = "application/json")
    @PostMapping("/enterDailyDataTemporary")
    public Result<Boolean> enterDailyDataTemporary(@RequestBody @Validated WorkoutRecordEnterDailyTemporaryDTO workoutRecordEnterDailyTemporaryDTO) {
        try {
            workoutRecordService.enterDailyDataTemporary(workoutRecordEnterDailyTemporaryDTO, getCurrentUser());
        } catch (Exception e) {
            return Result.fail();
        }
        return Result.ok(Boolean.TRUE);
    }

    @ApiOperation(value = "统计今日锻炼数据",notes = "统计今日锻炼数据",consumes = "application/json")
    @PostMapping("/todayStatistics")
    public Result<TodayStatisticsVO> todayStatistics() {

        return Result.ok(workoutRecordService.todayStatistics(getCurrentUser()));
    }

    @ApiOperation(value = "统计至今锻炼数据",notes = "统计至今锻炼数据",consumes = "application/json")
    @PostMapping("/toNowStatistics")
    public Result<ToNowStatisticsVO> toNowStatistics() {

        return Result.ok(workoutRecordService.toNowStatistics(getCurrentUser()));
    }
}
