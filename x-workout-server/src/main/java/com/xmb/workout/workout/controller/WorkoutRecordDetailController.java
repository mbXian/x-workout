package com.xmb.workout.workout.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xmb.workout.workout.entity.WorkoutRecordDetailEntity;
import com.xmb.workout.workout.service.WorkoutRecordDetailService;

/**
 * 训练项目表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
//@AppControllerMapping("workout/workoutrecorddetail")
public class WorkoutRecordDetailController {
    @Autowired
    private WorkoutRecordDetailService workoutRecordDetailService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    //@RequiresPermissions("workout:workoutrecorddetail:list")
//    public Result list(@RequestParam Map<String, Object> params){
//        PageUtils page = workoutRecordDetailService.queryPage(params);
//
//        return Result.ok(page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    //@RequiresPermissions("workout:workoutrecorddetail:info")
//    public Result info(@PathVariable("id") Long id){
//		WorkoutRecordDetailEntity workoutRecordDetail = workoutRecordDetailService.getById(id);
//
//        return Result.ok(workoutRecordDetail);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    //@RequiresPermissions("workout:workoutrecorddetail:save")
//    public Result save(@RequestBody WorkoutRecordDetailEntity workoutRecordDetail){
//		workoutRecordDetailService.save(workoutRecordDetail);
//
//        return Result.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    //@RequiresPermissions("workout:workoutrecorddetail:update")
//    public Result update(@RequestBody WorkoutRecordDetailEntity workoutRecordDetail){
//		workoutRecordDetailService.updateById(workoutRecordDetail);
//
//        return Result.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    //@RequiresPermissions("workout:workoutrecorddetail:delete")
//    public Result delete(@RequestBody Long[] ids){
//		workoutRecordDetailService.removeByIds(Arrays.asList(ids));
//
//        return Result.ok();
//    }

}
