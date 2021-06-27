package com.xmb.workout.wx.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xmb.common.utils.DateUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class WxRunDataVO {

    private List<WxRunDataItemVO> runDataItemVOList = new ArrayList<WxRunDataItemVO>();

    public static WxRunDataVO parseFromJsonString(String jsonString) {
        WxRunDataVO vo = new WxRunDataVO();
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("stepInfoList");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject itemJsonObject = jsonArray.getJSONObject(i);
            WxRunDataItemVO itemVO = new WxRunDataItemVO();
            itemVO.setTimestamp(itemJsonObject.getLongValue("timestamp"));
            if (itemVO.getTimestamp() > 0) {
                Date date = new Date(itemVO.getTimestamp() * 1000);
                String format = DateUtils.format(date, DateUtils.DATE_PATTERN);
                itemVO.setDateFormat(format);
            }
            itemVO.setStep(itemJsonObject.getIntValue("step"));
            vo.getRunDataItemVOList().add(itemVO);
        }
        return vo;
    }

}
