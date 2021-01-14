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
@ApiModel(value = "今天城市天气预报VO")
@Data
public class DayForecastCityVO {

    @ApiModelProperty(value = "城市地区名称")
    private String name;

    @ApiModelProperty(value = "天气变化")
    private String weatherShape;

    @ApiModelProperty(value = "最低温")
    private String tMin;

    @ApiModelProperty(value = "最高温")
    private String tMax;

    @ApiModelProperty(value = "风向")
    private String windDirection;

    @ApiModelProperty(value = "风速")
    private String windSpeed;

    @ApiModelProperty(value = "")
    private String gust;

    @ApiModelProperty(value = "")
    private String uMin;

    @ApiModelProperty(value = "")
    private String uMax;

    @ApiModelProperty(value = "")
    private String vMin;

    @ApiModelProperty(value = "")
    private String vMax;

    @ApiModelProperty(value = "空气指数")
    private String air;

    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 解析
     * @param cityElement
     * @return
     * @throws Exception
     */
    public static DayForecastCityVO parseElementToVO(Element cityElement) throws Exception {
        DayForecastCityVO vo = new DayForecastCityVO();
        List<Element> elementList = cityElement.elements();
        if (elementList == null || elementList.size() != 13) {
            throw new Exception("城市天气子元素数量不对！");
        } else {
            if (elementList.get(0).getData() != null) {
                vo.setName(String.valueOf(elementList.get(0).getData()));
            }
            if (elementList.get(1).getData() != null) {
                vo.setWeatherShape(String.valueOf(elementList.get(1).getData()));
            }
            if (elementList.get(2).getData() != null) {
                vo.setTMin(String.valueOf(elementList.get(2).getData()));
            }
            if (elementList.get(3).getData() != null) {
                vo.setTMax(String.valueOf(elementList.get(3).getData()));
            }
            if (elementList.get(4).getData() != null) {
                vo.setWindDirection(String.valueOf(elementList.get(4).getData()));
            }
            if (elementList.get(5).getData() != null) {
                vo.setWindSpeed(String.valueOf(elementList.get(5).getData()));
            }
            if (elementList.get(6).getData() != null) {
                vo.setGust(String.valueOf(elementList.get(6).getData()));
            }
            if (elementList.get(7).getData() != null) {
                vo.setUMin(String.valueOf(elementList.get(7).getData()));
            }
            if (elementList.get(8).getData() != null) {
                vo.setUMax(String.valueOf(elementList.get(8).getData()));
            }
            if (elementList.get(9).getData() != null) {
                vo.setVMin(String.valueOf(elementList.get(9).getData()));
            }
            if (elementList.get(10).getData() != null) {
                vo.setVMax(String.valueOf(elementList.get(10).getData()));
            }
            if (elementList.get(11).getData() != null) {
                vo.setAir(String.valueOf(elementList.get(11).getData()));
            }
            if (elementList.get(12).getData() != null) {
                vo.setIcon(String.valueOf(elementList.get(12).getData()));
            }
        }
        return vo;
    }

}
