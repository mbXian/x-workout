package com.xmb.workout.workout.controller;

import java.util.List;
import com.xmb.auth.AuthCenterUserApiService;
import com.xmb.auth.auth.dto.CheckoutPasswordDTO;
import com.xmb.auth.controller.BaseController;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.common.network.PageUtils;
import com.xmb.common.network.Result;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryDTO;
import com.xmb.workout.workout.vo.ToNowStatisticsVO;
import com.xmb.workout.workout.vo.TodayStatisticsVO;
import com.xmb.workout.workout.vo.WorkoutTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api(description = "训练记录模块")
@RestController
@RequestMapping("workout/workoutrecord")
public class WorkoutRecordController extends BaseController {
    @Autowired
    private WorkoutRecordService workoutRecordService;
    @Autowired
    private AuthCenterUserApiService authCenterUserApiService;

    /**
     * 列表
     */
    @ApiOperation(("训练记录列表"))
    @PostMapping("/list")
    public Result list(){
        List<WorkoutRecordEntity> list = workoutRecordService.list();

        CheckoutPasswordDTO dto = new CheckoutPasswordDTO();
        dto.setMobile("18824140606");
        dto.setPassword("123456");
        boolean b = authCenterUserApiService.checkUserMobilePassword(dto);

        return Result.ok(new PageUtils(list, list.size(), 10, 1));
    }

    @ApiOperation(value = "临时登记",notes = "临时登记",consumes = "application/json")
    @PostMapping("/enterDailyDataTemporary")
    public Result<Boolean> enterDailyDataTemporary(@RequestBody @Validated WorkoutRecordEnterDailyTemporaryDTO workoutRecordEnterDailyTemporaryDTO) {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile("18824140606");
        workoutRecordService.enterDailyDataTemporary(workoutRecordEnterDailyTemporaryDTO, sysUserEntity);
        return Result.ok(Boolean.TRUE);
    }

    @ApiOperation(value = "统计今日锻炼数据",notes = "统计今日锻炼数据",consumes = "application/json")
    @PostMapping("/todayStatistics")
    public Result<TodayStatisticsVO> todayStatistics() {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile("18824140606");
        return Result.ok(workoutRecordService.todayStatistics(sysUserEntity));
    }

    @ApiOperation(value = "统计至今锻炼数据",notes = "统计至今锻炼数据",consumes = "application/json")
    @PostMapping("/toNowStatistics")
    public Result<ToNowStatisticsVO> toNowStatistics() {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile("18824140606");
        return Result.ok(workoutRecordService.toNowStatistics(sysUserEntity));
    }

    @ApiOperation(value = "所有的锻炼项目",notes = "所有的锻炼项目",consumes = "application/json")
    @PostMapping("/workoutTypeList")
    public Result<List<WorkoutTypeVO>> workoutTypeList() {

        return Result.ok(workoutRecordService.workoutTypeList());
    }

    @ApiOperation(value = "测试接口",notes = "测试接口",consumes = "application/json")
    @PostMapping("/test")
    public Result test() {
        log.info("dasdj");
        return Result.ok();
    }
}
