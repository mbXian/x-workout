package com.xmb.workout.lifestyle.service;

import com.xmb.workout.lifestyle.DayForecastVO;
import com.xmb.workout.lifestyle.WeatherRealTimeDataVO;

/**
 * @author Ben
 * @date 2021-01-12
 * @desc
 */
public interface KongMoonWeatherService {

    /**
     * 实时天气数据
     *
     * @return
     */
    WeatherRealTimeDataVO getRealTimeData() throws Exception;

    /**
     * 今天天气预报
     *
     * @return
     */
    DayForecastVO getDayForecast() throws Exception;

}
