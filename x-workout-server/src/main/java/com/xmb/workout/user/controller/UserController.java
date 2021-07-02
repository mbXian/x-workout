package com.xmb.workout.user.controller;

import com.xmb.auth.auth.dto.UserInfoSaveOrUpdateDTO;
import com.xmb.auth.controller.BaseController;
import com.xmb.workout.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(description = "用户模块")
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("新增或修改用户信息")
    @RequestMapping("/saveOrUpdateUserInfo")
    public void saveOrUpdateUserInfo(@RequestBody UserInfoSaveOrUpdateDTO userInfoSaveOrUpdateDTO) {
        userService.saveOrUpdateUserInfo(userInfoSaveOrUpdateDTO);
    }

}
