package com.xmb.workout.user.service.impl;

import com.xmb.workout.utils.MD5Utils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmb.workout.user.dao.SysUserDao;
import com.xmb.workout.user.entity.SysUserEntity;
import com.xmb.workout.user.service.SysUserService;
import org.springframework.util.StringUtils;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    /**
     * 验证手机号和密码是否匹配
     * @param mobile
     * @param password
     * @return
     */
    @Override
    public boolean checkUserMobilePassword(String mobile, String password) {
        SysUserEntity sysUserEntity = this.baseMapper.findByMobile(mobile);
        String passwordMD5 = MD5Utils.encode(password);
        return (sysUserEntity != null && !StringUtils.isEmpty(sysUserEntity.getMobile()) && sysUserEntity.getPassword().equals(passwordMD5));
    }
}