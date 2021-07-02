package com.xmb.workout.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmb.auth.auth.dto.UserInfoSaveOrUpdateDTO;
import com.xmb.auth.entity.SysUserEntity;

public interface UserService extends IService<SysUserEntity> {

    /**
     * 新增或修改用户信息
     * @param userInfoSaveOrUpdateDTO
     * @return
     */
    SysUserEntity saveOrUpdateUserInfo(UserInfoSaveOrUpdateDTO userInfoSaveOrUpdateDTO);

}
