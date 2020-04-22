package com.xmb.workout.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmb.workout.user.entity.SysUserEntity;

/**
 * 用户表
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:21:26
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 验证手机号和密码是否匹配
     * @param mobile
     * @param password
     * @return
     */
    boolean checkUserMobilePassword(String mobile, String password);
}

