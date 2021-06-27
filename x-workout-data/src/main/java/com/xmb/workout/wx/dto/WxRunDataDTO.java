package com.xmb.workout.wx.dto;

import lombok.Data;

@Data
public class WxRunDataDTO {
    private String openId;
    private String encryptedData;
    private String iv;
}
