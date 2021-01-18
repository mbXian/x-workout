package com.xmb.workout.lifestyle.controller;

import com.xmb.auth.controller.BaseController;
import com.xmb.common.network.Result;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.lifestyle.weather.DayForecastVO;
import com.xmb.workout.lifestyle.weather.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.service.KongMoonWeatherService;
import com.xmb.workout.lifestyle.weather.WeekForecastVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben
 * @date 2021-01-12
 * @desc
 */
@RestController
@Api(description = "江门气象相关接口")
@RequestMapping("/weather")
public class KongMoonWeatherController extends BaseController {

    @Autowired
    KongMoonWeatherService kongMoonWeatherService;

    @ApiLog(title = "实时天气数据")
    @ApiOperation(value = "实时天气数据", notes = "实时天气数据", consumes = "application/json")
    @PostMapping(value = "/getRealTimeData", produces = "application/json; charset=UTF-8")
    public Result<WeatherRealTimeDataVO> getRealTimeData() throws Exception {
        return Result.ok(kongMoonWeatherService.getRealTimeData());
    }

    @ApiLog(title = "未来24小时天气预报")
    @ApiOperation(value = "未来24小时天气预报", notes = "未来24小时天气预报", consumes = "application/json")
    @PostMapping(value = "/getDayForecast", produces = "application/json; charset=UTF-8")
    public Result<DayForecastVO> getDayForecast() throws Exception {
        return Result.ok(kongMoonWeatherService.getDayForecast());
    }

    @ApiLog(title = "未来一周天气预报")
    @ApiOperation(value = "未来一周天气预报", notes = "未来一周天气预报", consumes = "application/json")
    @PostMapping(value = "/getWeekForecast", produces = "application/json; charset=UTF-8")
    public Result<WeekForecastVO> getWeekForecast() throws Exception {
        return Result.ok(kongMoonWeatherService.getWeekForecast());
    }

}
