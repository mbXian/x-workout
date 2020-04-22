package com.xmb.workout.network;

import com.xmb.workout.user.dao.SysUserDao;
import com.xmb.workout.user.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ben
 * @date 2020-04-22
 * @desc
 */
public class BaseController {

    @Autowired
    private SysUserDao sysUserDao;

    public SysUserEntity getCurrentUser() {
        SysUserEntity currentUser = sysUserDao.findByMobile("18824140606");
        return currentUser;
    }
}
