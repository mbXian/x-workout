package com.xmb.workout.lifestyle.service.impl;

import com.xmb.workout.constant.KongMoonWeatherNetWorkConstant;
import com.xmb.workout.lifestyle.DayForecastVO;
import com.xmb.workout.lifestyle.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.service.KongMoonWeatherService;
import com.xmb.workout.utils.network.CommonOkHttpClient;
import com.xmb.workout.utils.network.CommonOkhttpRequest;
import okhttp3.Response;
import org.springframework.stereotype.Service;

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

        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.REAL_TIME_WEATHER_DATA_URL;
        Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
        String respXmlString = response.body().string();
        WeatherRealTimeDataVO vo = WeatherRealTimeDataVO.parseXmlRespStringToVO(respXmlString);
        return vo;
    }

    /**
     * 今天天气预报
     * @return
     * @throws Exception
     */
    @Override
    public DayForecastVO getDayForecast() throws Exception {

        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.DAY_FORECAST_URL;
        Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
        String respXmlString = response.body().string();
        DayForecastVO vo = DayForecastVO.parseXmlRespStringToVO(respXmlString);
        return vo;
    }

}
