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
@ApiModel(value = "今天天气预报VO")
@Data
public class DayForecastVO {

    @ApiModelProperty(value = "今天天气描述VO")
    private DayForecastInfoVO dayForecastInfoVO;

    @ApiModelProperty(value = "今天城市天气预报VO集合")
    private List<DayForecastCityVO> dayForecastCityVOList;

    @ApiModelProperty(value = "今天天气指数VO")
    private DayForecastIndexVO dayForecastIndexVO;

    /**
     * 解析
     *
     * @param respXmlString
     * @return
     * @throws Exception
     */
    public static DayForecastVO parseXmlRespStringToVO(String respXmlString) throws Exception {
        DayForecastVO vo = new DayForecastVO();
        if (StringUtils.isEmpty(respXmlString)) {
            throw new Exception("xml数据错误！");
        } else {
            Document doc = DocumentHelper.parseText(respXmlString);
            Element forecastElement = doc.getRootElement();
            if (forecastElement == null) {
                throw new Exception("xml数据不包含根元素！");
            } else {
                List<Element> forecastElementList = forecastElement.elements();
                if (CollectionUtils.isEmpty(forecastElementList) || forecastElementList.size() != 10) {
                    throw new Exception("DS元素下包含子元素数量不对！");
                } else {
                    Element infoElement = forecastElementList.get(0);
                    DayForecastInfoVO dayForecastInfoVO = DayForecastInfoVO.parseElementToVO(infoElement);
                    vo.setDayForecastInfoVO(dayForecastInfoVO);

                    vo.setDayForecastCityVOList(new ArrayList<DayForecastCityVO>());
                    for (int i = 1; i < 9; i++) {
                        Element cityElement = forecastElementList.get(i);
                        DayForecastCityVO dayForecastCityVO = DayForecastCityVO.parseElementToVO(cityElement);
                        vo.getDayForecastCityVOList().add(dayForecastCityVO);
                    }

                    Element indexElement = forecastElementList.get(9);
                    DayForecastIndexVO dayForecastIndexVO = DayForecastIndexVO.parseElementToVO(indexElement);
                    vo.setDayForecastIndexVO(dayForecastIndexVO);
                }
            }
        }
        return vo;
    }

}
