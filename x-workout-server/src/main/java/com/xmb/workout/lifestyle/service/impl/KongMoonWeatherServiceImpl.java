package com.xmb.workout.lifestyle.service.impl;

import com.xmb.workout.constant.KongMoonWeatherNetWorkConstant;
import com.xmb.workout.lifestyle.weather.DayForecastVO;
import com.xmb.workout.lifestyle.weather.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.service.KongMoonWeatherService;
import com.xmb.workout.lifestyle.weather.WeatherWarningSignalVO;
import com.xmb.workout.lifestyle.weather.WeekForecastVO;
import com.xmb.workout.utils.network.CommonOkHttpClient;
import com.xmb.workout.utils.network.CommonOkhttpRequest;
import okhttp3.Response;
import org.springframework.stereotype.Service;

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

        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.REAL_TIME_WEATHER_DATA_URL;
        Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
        String respXmlString = response.body().string();
        WeatherRealTimeDataVO vo = WeatherRealTimeDataVO.parseXmlRespStringToVO(respXmlString);
        return vo;
    }

    /**
     * 未来24小时天气预报
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

    /**
     * 未来一周天气预报
     * @return
     * @throws Exception
     */
    @Override
    public WeekForecastVO getWeekForecast() throws Exception {
        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.WEEK_FORECAST_URL;
        Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
        String respXmlString = response.body().string();
        WeekForecastVO vo = WeekForecastVO.parseXmlRespStringToVO(respXmlString);
        return vo;
    }

    /**
     * 预警信号
     * @return
     * @throws Exception
     */
    @Override
    public List<WeatherWarningSignalVO> getWarningSignal() throws Exception {
        String url = KongMoonWeatherNetWorkConstant.KONGMOON_ATMOSPHERE_PLATFORM_IP + KongMoonWeatherNetWorkConstant.WARNING_SIGNAL_URL;
        Response response = CommonOkHttpClient.sendRequest(CommonOkhttpRequest.createGetRequest(url, null));
        String respXmlString = response.body().string();
        List<WeatherWarningSignalVO> voList = WeatherWarningSignalVO.parseXmlRespStringToVO(respXmlString);
        return voList;
    }
}
