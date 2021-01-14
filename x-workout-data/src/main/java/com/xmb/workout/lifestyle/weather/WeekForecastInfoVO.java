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
@ApiModel(value = "一周预报信息VO")
@Data
public class WeekForecastInfoVO {

    @ApiModelProperty(value = "生成预报时间")
    private String time7Day;

    @ApiModelProperty(value = "预报人员")
    private String forecaster7Day;

    @ApiModelProperty(value = "预报一周时间开始时间")
    private String forecastTimeFrom;

    @ApiModelProperty(value = "预报一周时间结束时间")
    private String forecastTimeTo;

    @ApiModelProperty(value = "备注")
    private String weekRemark;

    /**
     * 解析
     * @param infoElement
     * @return
     * @throws Exception
     */
    public static WeekForecastInfoVO parseElementToVO(Element infoElement) throws Exception {
        WeekForecastInfoVO vo = new WeekForecastInfoVO();
        List<Element> elementList = infoElement.elements();
        if (elementList == null || elementList.size() != 5) {
            throw new Exception("预报描述子元素数量不对！");
        } else {
            if (elementList.get(0).getData() != null) {
                vo.setTime7Day(String.valueOf(elementList.get(0).getData()));
            }
            if (elementList.get(1).getData() != null) {
                vo.setForecaster7Day(String.valueOf(elementList.get(1).getData()));
            }
            if (elementList.get(2).getData() != null) {
                vo.setForecastTimeFrom(String.valueOf(elementList.get(2).getData()));
            }
            if (elementList.get(3).getData() != null) {
                vo.setForecastTimeTo(String.valueOf(elementList.get(3).getData()));
            }
            if (elementList.get(4).getData() != null) {
                vo.setWeekRemark(String.valueOf(elementList.get(4).getData()));
            }
        }
        return vo;
    }
}
