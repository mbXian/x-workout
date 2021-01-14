package com.xmb.workout.lifestyle.controller;

import com.xmb.auth.controller.BaseController;
import com.xmb.common.network.Result;
import com.xmb.workout.lifestyle.DayForecastVO;
import com.xmb.workout.lifestyle.WeatherRealTimeDataVO;
import com.xmb.workout.lifestyle.service.KongMoonWeatherService;
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

    @ApiOperation(value = "实时天气数据", notes = "实时天气数据",consumes = "application/json")
    @PostMapping(value = "/getRealTimeData", produces = "application/json; charset=UTF-8")
    public Result<WeatherRealTimeDataVO> getRealTimeData() throws Exception {
        return Result.ok(kongMoonWeatherService.getRealTimeData());
    }

    @ApiOperation(value = "今天天气预报", notes = "今天天气预报",consumes = "application/json")
    @PostMapping(value = "/getDayForecast", produces = "application/json; charset=UTF-8")
    public Result<DayForecastVO> getDayForecast() throws Exception {
        return Result.ok(kongMoonWeatherService.getDayForecast());
    }

}
