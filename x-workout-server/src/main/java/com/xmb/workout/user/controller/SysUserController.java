package com.xmb.workout.user.controller;

import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xmb.workout.user.entity.SysUserEntity;
import com.xmb.workout.user.service.SysUserService;

/**
 * 用户表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:21:26
 */
//@AppControllerMapping("user/sysuser")
@RestController("user/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    //@RequiresPermissions("user:sysuser:list")
//    public Result list(@RequestParam Map<String, Object> params){
//        PageUtils page = sysUserService.queryPage(params);
//
//        return Result.ok(page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    //@RequiresPermissions("user:sysuser:info")
//    public Result info(@PathVariable("id") Long id){
//		SysUserEntity sysUser = sysUserService.getById(id);
//
//        return Result.ok(sysUser);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    //@RequiresPermissions("user:sysuser:save")
//    public Result save(@RequestBody SysUserEntity sysUser){
//		sysUserService.save(sysUser);
//
//        return Result.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    //@RequiresPermissions("user:sysuser:update")
//    public Result update(@RequestBody SysUserEntity sysUser){
//		sysUserService.updateById(sysUser);
//
//        return Result.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    //@RequiresPermissions("user:sysuser:delete")
//    public Result delete(@RequestBody Long[] ids){
//		sysUserService.removeByIds(Arrays.asList(ids));
//
//        return Result.ok();
//    }

}
