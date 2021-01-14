package com.xmb.workout.lifestyle.weather;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dom4j.Element;

import java.util.List;

/**
 * @author Ben
 * @date 2021-01-14
 * @desc
 */
@ApiModel(value = "今天天气描述VO")
@Data
public class DayForecastInfoVO {

    @ApiModelProperty(value = "预报时间")
    private String time;

    @ApiModelProperty(value = "预报人员")
    private String forecaster;

    @ApiModelProperty(value = "预报描述")
    private String weatherDesc;

    @ApiModelProperty(value = "预报备注")
    private String remark;

    /**
     * 解析
     * @param infoElement
     * @return
     * @throws Exception
     */
    public static DayForecastInfoVO parseElementToVO(Element infoElement) throws Exception {
        DayForecastInfoVO vo = new DayForecastInfoVO();
        List<Element> elementList = infoElement.elements();
        if (elementList == null || elementList.size() != 4) {
            throw new Exception("预报描述子元素数量不对！");
        } else {
            if (elementList.get(0).getData() != null) {
                vo.setTime(String.valueOf(elementList.get(0).getData()));
            }
            if (elementList.get(1).getData() != null) {
                vo.setForecaster(String.valueOf(elementList.get(1).getData()));
            }
            if (elementList.get(2).getData() != null) {
                vo.setWeatherDesc(String.valueOf(elementList.get(2).getData()));
            }
            if (elementList.get(3).getData() != null) {
                vo.setRemark(String.valueOf(elementList.get(3).getData()));
            }
        }
        return vo;
    }
}
