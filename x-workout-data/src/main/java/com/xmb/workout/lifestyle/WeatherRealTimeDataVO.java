package com.xmb.workout.lifestyle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

import java.util.List;

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
    private String windSpeed;

    @ApiModelProperty(value = "风力")
    private String windPower;

    @ApiModelProperty(value = "日雨量")
    private String dailyRainfall;

    @ApiModelProperty(value = "相对湿度")
    private String relativeHumidity;

    /**
     * 解析xml返回数据为WeatherRealTimeDataVO
     * @param respXmlString
     * @return
     * @throws Exception
     */
    public static WeatherRealTimeDataVO parseXmlRespStringToVO(String respXmlString) throws Exception {
        WeatherRealTimeDataVO vo = new WeatherRealTimeDataVO();
        if (StringUtils.isEmpty(respXmlString)) {
            throw new Exception("xml数据错误！");
        } else {
            Document doc = DocumentHelper.parseText(respXmlString);
            Element dsElement = doc.getRootElement();
            if (dsElement == null) {
                throw new Exception("xml数据不包含根元素！");
            } else {
                List<Element> rElementList = dsElement.elements();
                if (CollectionUtils.isEmpty(rElementList) || rElementList.size() < 2) {
                    throw new Exception("DS元素下包含子元素数量不对！");
                } else {
                    Element r2Element = rElementList.get(1);
                    List<Element> cEmentList = r2Element.elements();
                    if (cEmentList == null || cEmentList.size() < 9) {
                        throw new Exception("R元素下包含子元素数量不对！");
                    } else {
                        if (cEmentList.get(0).getData() != null) {
                            vo.setStationName(String.valueOf(cEmentList.get(0).getData()));
                        }
                        if (cEmentList.get(1).getData() != null) {
                            vo.setWorldDateTimeString(String.valueOf(cEmentList.get(1).getData()));
                        }
                        if (cEmentList.get(2).getData() != null) {
                            vo.setDetectionDateTimeString(String.valueOf(cEmentList.get(2).getData()));
                        }
                        if (cEmentList.get(3).getData() != null) {
                            vo.setTemperature(String.valueOf(cEmentList.get(3).getData()));
                        }
                        if (cEmentList.get(4).getData() != null) {
                            vo.setWindDirectionImage(String.valueOf(cEmentList.get(4).getData()));
                        }
                        if (cEmentList.get(5).getData() != null) {
                            vo.setWindSpeed(String.valueOf(cEmentList.get(5).getData()));
                        }
                        if (cEmentList.get(6).getData() != null) {
                            vo.setWindPower(String.valueOf(cEmentList.get(6).getData()));
                        }
                        if (cEmentList.get(7).getData() != null) {
                            vo.setDailyRainfall(String.valueOf(cEmentList.get(7).getData()));
                        }
                        if (cEmentList.get(8).getData() != null) {
                            vo.setRelativeHumidity(String.valueOf(cEmentList.get(8).getData()));
                        }
                    }
                }
            }
        }
        return vo;
    }
}
