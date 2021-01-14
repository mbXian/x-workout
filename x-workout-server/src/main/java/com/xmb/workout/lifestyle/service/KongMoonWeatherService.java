package com.xmb.workout.lifestyle.service;

import com.xmb.workout.lifestyle.weather.DayForecastVO;
import com.xmb.workout.lifestyle.weather.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.weather.WeekForecastVO;

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

    /**
     * 一周天气预报
     * @return
     * @throws Exception
     */
    WeekForecastVO getWeekForecast() throws Exception;

}
