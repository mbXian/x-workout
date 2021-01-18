package com.xmb.workout.lifestyle.controller;

import com.xmb.auth.controller.BaseController;
import com.xmb.common.network.Result;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.lifestyle.RecommendMealDTO;
import com.xmb.workout.lifestyle.service.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author by Ben
 * On 2019-08-28.
 *
 * @Descption 餐饮
 */

@RestController
@Api(description = "餐饮相关接口")
@RequestMapping("/meal")
public class MealController extends BaseController {

    @Autowired
    MealService mealService;

    @ApiLog(title = "获取推荐餐饮")
    @ApiOperation(value = "获取推荐餐饮",notes = "获取推荐餐饮",consumes = "application/json")
    @RequestMapping(value = "/recommend", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Result recommend(@RequestParam(value = "id") String id, @RequestParam(value = "id1") String id1) {
        RecommendMealDTO recommendMealDTO = mealService.getRecommendMeal();
        return Result.ok(recommendMealDTO);
    }
}
