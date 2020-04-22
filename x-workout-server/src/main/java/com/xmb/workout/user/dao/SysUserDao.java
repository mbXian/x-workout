package com.xmb.workout.user.dao;

import com.xmb.workout.user.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表
 * 
 * @author Ben
 * @email 
 * @date 2020-04-22 11:21:26
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    SysUserEntity findByMobile(@Param("mobile") String mobile);
}
