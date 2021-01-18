package com.xmb.workout.workout.controller;

import java.util.Date;
import java.util.List;
import com.xmb.auth.AuthCenterUserApiService;
import com.xmb.auth.auth.dto.CheckoutPasswordDTO;
import com.xmb.auth.controller.BaseController;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.common.network.PageUtils;
import com.xmb.common.network.Result;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.workout.dto.WorkoutRequestBaseDTO;
import com.xmb.workout.workout.dto.WorkoutDaysSaturationDTO;
import com.xmb.workout.workout.dto.WorkoutRecordEnterDailyTemporaryBaseDTO;
import com.xmb.workout.workout.vo.*;
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
    public Result list(@RequestBody @Validated WorkoutRequestBaseDTO workoutRequestBaseDTO){
        List<WorkoutRecordEntity> list = workoutRecordService.list();

        CheckoutPasswordDTO dto = new CheckoutPasswordDTO();
        dto.setMobile(workoutRequestBaseDTO.getUserMobile());
        dto.setPassword("123456");
        boolean b = authCenterUserApiService.checkUserMobilePassword(dto);

        return Result.ok(new PageUtils(list, list.size(), 10, 1));
    }

    @ApiOperation(value = "临时登记",notes = "临时登记",consumes = "application/json")
    @PostMapping("/enterDailyDataTemporary")
    public Result<Boolean> enterDailyDataTemporary(@RequestBody @Validated WorkoutRecordEnterDailyTemporaryBaseDTO workoutRecordEnterDailyTemporaryDTO) throws Exception {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile(workoutRecordEnterDailyTemporaryDTO.getUserMobile());
        return Result.ok(workoutRecordService.enterDailyDataTemporary(workoutRecordEnterDailyTemporaryDTO, sysUserEntity));
    }

    @ApiOperation(value = "统计今日锻炼数据",notes = "统计今日锻炼数据",consumes = "application/json")
    @PostMapping("/todayStatistics")
    public Result<TodayStatisticsVO> todayStatistics(@RequestBody @Validated WorkoutRequestBaseDTO workoutRequestBaseDTO) {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile(workoutRequestBaseDTO.getUserMobile());
        return Result.ok(workoutRecordService.todayStatistics(sysUserEntity));
    }

    @ApiLog(title = "统计至今锻炼数据")
    @ApiOperation(value = "统计至今锻炼数据",notes = "统计至今锻炼数据",consumes = "application/json")
    @PostMapping("/toNowStatistics")
    public Result<ToNowStatisticsVO> toNowStatistics(@RequestBody @Validated WorkoutRequestBaseDTO workoutRequestBaseDTO) {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile(workoutRequestBaseDTO.getUserMobile());
        return Result.ok(workoutRecordService.toNowStatistics(sysUserEntity));
    }

    @ApiOperation(value = "所有的锻炼项目",notes = "所有的锻炼项目",consumes = "application/json")
    @PostMapping("/workoutTypeList")
    public Result<List<WorkoutTypeVO>> workoutTypeList() {

        return Result.ok(workoutRecordService.workoutTypeList());
    }

    @ApiOperation(value = "过期n天训练饱和率",notes = "过期n天训练饱和率",consumes = "application/json")
    @PostMapping("/daysSaturation")
    public Result<WorkoutDaysSaturationVO> daysSaturation(@RequestBody @Validated WorkoutDaysSaturationDTO workoutDaysSaturationDTO) {
        if (workoutDaysSaturationDTO.getDays() <= 0) {
            return Result.fail("参数错误!");
        }
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile(workoutDaysSaturationDTO.getUserMobile());
        return Result.ok(workoutRecordService.daysSaturation(sysUserEntity, workoutDaysSaturationDTO.getDays()));
    }

    @ApiOperation(value = "已连续锻炼天数",notes = "已连续锻炼天数",consumes = "application/json")
    @PostMapping("/keepOnDays")
    public Result<WorkoutKeepOnDaysVO> keepOnDays(@RequestBody @Validated WorkoutRequestBaseDTO workoutRequestBaseDTO) {

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setMobile(workoutRequestBaseDTO.getUserMobile());
        return Result.ok(workoutRecordService.keepOnDays(sysUserEntity));
    }

    @ApiOperation(value = "测试接口",notes = "测试接口",consumes = "application/json")
    @PostMapping("/test")
    public Result test() {
        log.info("时区时间 = " + (new Date(1602770382429L)));
        return Result.ok();
    }
}
