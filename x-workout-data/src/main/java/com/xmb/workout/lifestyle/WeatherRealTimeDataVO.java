package com.xmb.workout.lifestyle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Ben
 * @date 2021-01-13
 * @desc
 */
@ApiModel(value = "实时天气数据")
@Data
public class WeatherRealTimeDataVO {

    @ApiModelProperty(value = "站名")
    private String stationName;

    @ApiModelProperty(value = "世界时间")
    private String worldDateTimeString;

    @ApiModelProperty(value = "监测时间")
    private String detectionDateTimeString;

    @ApiModelProperty(value = "气温")
    private String temperature;

    @ApiModelProperty(value = "风向图片")
    private String windDirectionImage;

    @ApiModelProperty(value = "风速")
    private BigDecimal windSpeed;

    @ApiModelProperty(value = "风力")
    private String windPower;

    @ApiModelProperty(value = "日雨量")
    private String dailyRainfall;

    @ApiModelProperty(value = "相对湿度")
    private String relativeHumidity;

}
