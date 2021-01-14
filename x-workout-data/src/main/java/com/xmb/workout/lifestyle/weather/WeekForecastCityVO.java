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
@ApiModel(value = "一周城市预报VO")
@Data
public class WeekForecastCityVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "一周每天的城市预报VO集合")
    private List<WeekDayForecastCityVO> weekDayForecastCityVOList;

    /**
     * 解析
     *
     * @param cityElement
     * @return
     */
    public static WeekForecastCityVO parseElementToVO(Element cityElement) throws Exception {
        WeekForecastCityVO vo = new WeekForecastCityVO();
        List<Element> elementList = cityElement.elements();
        if (elementList == null || elementList.size() != 99) {
            throw new Exception("城市一周每天预报子元素数量不对！");
        } else {
            vo.setName(String.valueOf(elementList.get(0).getData()));

            List<WeekDayForecastCityVO> weekDayForecastCityVOList = WeekDayForecastCityVO.parseElementToVOList(cityElement);
            vo.setWeekDayForecastCityVOList(weekDayForecastCityVOList);
        }
        return vo;
    }

}
