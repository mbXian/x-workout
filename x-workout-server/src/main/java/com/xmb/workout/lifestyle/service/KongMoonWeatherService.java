package com.xmb.workout.lifestyle.service;

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

}
