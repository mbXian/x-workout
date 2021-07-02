package com.xmb.workout.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmb.auth.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表
 * 
 * @author Ben
 * @email 
 * @date 2020-05-04 19:46:47
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    SysUserEntity findByMobile(@Param("mobile") String mobile);

}
