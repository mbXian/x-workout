package com.xmb.workout.user.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmb.auth.auth.dto.UserInfoSaveOrUpdateDTO;
import com.xmb.auth.entity.SysUserEntity;
import com.xmb.workout.user.UserService;
import com.xmb.workout.user.dao.SysUserDao;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements UserService {

    @Override
    public SysUserEntity saveOrUpdateUserInfo(UserInfoSaveOrUpdateDTO userInfoSaveOrUpdateDTO) {
        SysUserEntity sysUserEntity = null;
        if (userInfoSaveOrUpdateDTO.getId() != null) {
            sysUserEntity = getById(userInfoSaveOrUpdateDTO.getId());
        }
        if (sysUserEntity == null && !StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getMobile())) {
            sysUserEntity = getOne(Wrappers.<SysUserEntity>query().lambda().eq(SysUserEntity::getMobile, userInfoSaveOrUpdateDTO.getMobile()));
        }
        if (sysUserEntity == null && !StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getUserName())) {
            sysUserEntity = getOne(Wrappers.<SysUserEntity>query().lambda().eq(SysUserEntity::getUserName, userInfoSaveOrUpdateDTO.getUserName()));
        }
        if (sysUserEntity == null && !StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getOpenId())) {
            sysUserEntity = getOne(Wrappers.<SysUserEntity>query().lambda().eq(SysUserEntity::getOpenId, userInfoSaveOrUpdateDTO.getOpenId()));
        }
        if (sysUserEntity != null) {
            if (!StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getUserName())) {
                sysUserEntity.setUserName(userInfoSaveOrUpdateDTO.getUserName());
            }
            if (!StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getNickName())) {
                sysUserEntity.setNickName(userInfoSaveOrUpdateDTO.getNickName());
            }
            if (!StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getMobile())) {
                sysUserEntity.setMobile(userInfoSaveOrUpdateDTO.getMobile());
            }
            if (!StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getOpenId())) {
                sysUserEntity.setOpenId(userInfoSaveOrUpdateDTO.getOpenId());
            }
            if (!StringUtils.isEmpty(userInfoSaveOrUpdateDTO.getAvatar())) {
                sysUserEntity.setAvatar(userInfoSaveOrUpdateDTO.getAvatar());
            }
            updateById(sysUserEntity);
        }
        return null;
    }

}
