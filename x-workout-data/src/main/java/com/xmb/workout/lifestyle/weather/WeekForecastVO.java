package com.xmb.workout.lifestyle.weather;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 * @date 2021-01-14
 * @desc
 */
@ApiModel(value = "一周天气预报VO")
@Data
public class WeekForecastVO {

    @ApiModelProperty(value = "一周预报信息VO")
    private WeekForecastInfoVO weekForecastInfoVO;

    @ApiModelProperty(value = "一周城市预报VO集合")
    private List<WeekForecastCityVO> weekForecastCityVOList;

    /**
     * 解析
     * @param respXmlString
     * @return
     * @throws Exception
     */
    public static WeekForecastVO parseXmlRespStringToVO(String respXmlString) throws Exception {
        WeekForecastVO vo = new WeekForecastVO();

        if (StringUtils.isEmpty(respXmlString)) {
            throw new Exception("xml数据错误！");
        } else {
            Document doc = DocumentHelper.parseText(respXmlString);
            Element forecastElement = doc.getRootElement();
            if (forecastElement == null) {
                throw new Exception("xml数据不包含根元素！");
            } else {
                List<Element> forecastElementList = forecastElement.elements();
                if (CollectionUtils.isEmpty(forecastElementList) || forecastElementList.size() != 9) {
                    throw new Exception("Forecast元素下包含子元素数量不对！");
                } else {
                    Element infoElement = forecastElementList.get(0);
                    WeekForecastInfoVO weekForecastInfoVO = WeekForecastInfoVO.parseElementToVO(infoElement);
                    vo.setWeekForecastInfoVO(weekForecastInfoVO);

                    vo.setWeekForecastCityVOList(new ArrayList<WeekForecastCityVO>());
                    for (int i = 1; i < 9; i++) {
                        Element cityElement = forecastElementList.get(i);
                        WeekForecastCityVO weekForecastCityVO = WeekForecastCityVO.parseElementToVO(cityElement);
                        vo.getWeekForecastCityVOList().add(weekForecastCityVO);
                    }

                }
            }
        }
        return vo;
    }
}
