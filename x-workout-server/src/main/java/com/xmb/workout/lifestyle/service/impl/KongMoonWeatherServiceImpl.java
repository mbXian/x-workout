package com.xmb.workout.lifestyle.service.impl;

import com.xmb.workout.constant.KongMoonWeatherNetWorkConstant;
import com.xmb.workout.lifestyle.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.service.KongMoonWeatherService;
import com.xmb.workout.utils.network.CommonOkHttpClient;
import com.xmb.workout.utils.network.CommonOkhttpRequest;
import okhttp3.Response;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Ben
 * @date 2021-01-12
 * @desc
 */
@Service
public class KongMoonWeatherServiceImpl implements KongMoonWeatherService {

    /**
     * 实时天气数据
     *
     * @return
     */
    @Override
    public WeatherRealTimeDataVO getRealTimeData() throws Exception {
        WeatherRealTimeDataVO vo = new WeatherRealTimeDataVO();

        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.REAL_TIME_WEATHER_DATA_URL;

        try {
            Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
            String respXmlString = response.body().string();
            if (StringUtils.isEmpty(respXmlString)) {
                throw new Exception("接口返回数据错误！");
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
        } catch (Exception e) {
            throw e;
        }

        return vo;
    }

}
