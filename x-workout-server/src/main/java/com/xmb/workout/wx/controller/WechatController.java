package com.xmb.workout.wx.controller;

import com.xmb.auth.controller.BaseController;
import com.xmb.common.network.Result;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.wx.dto.WxRunDataDTO;
import com.xmb.workout.wx.entity.WechatAccessToken;
import com.xmb.workout.wx.entity.WechatCode2Session;
import com.xmb.workout.wx.service.IWechatService;
import com.xmb.workout.wx.vo.WxRunDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信接口模块
 *
 * @author Ben
 * @email 
 * @date 2020-04-22 11:23:29
 */
@Slf4j
@Api(description = "微信接口模块")
@RestController
@RequestMapping("wechat")
public class WechatController extends BaseController {
    @Autowired
    private IWechatService wechatService;

    @ApiLog(title = "获取access_token")
    @ApiOperation(("获取access_token"))
    @GetMapping("/getAccessToken")
    public Result<WechatAccessToken> getAccessToken(){
        WechatAccessToken accessToken = wechatService.getAccessToken();
        return Result.ok(accessToken);
    }

    @ApiLog(title = "登录凭证校验")
    @ApiOperation(value = "登录凭证校验",notes = "登录凭证校验",consumes = "application/json")
    @GetMapping("/getSession")
    public Result<WechatCode2Session> getSession(@ApiParam(value = "jsCode", required = true) @RequestParam(required = true)String jsCode) {
        WechatCode2Session wechatCode2Session = wechatService.getSession(jsCode);
        return Result.ok(wechatCode2Session);
    }

    @ApiLog(title = "解密微信运动数据")
    @ApiOperation(value = "解密微信运动数据",notes = "解密微信运动数据",consumes = "application/json")
    @PostMapping("/decryptRunData")
    public Result<WxRunDataVO> decryptRunData(@RequestBody WxRunDataDTO wxRunDataDTO) throws Exception {
        WxRunDataVO wxRunDataVO = wechatService.decryptRunData(wxRunDataDTO.getOpenId(), wxRunDataDTO.getEncryptedData(), wxRunDataDTO.getIv());
        return Result.ok(wxRunDataVO);
    }

}
