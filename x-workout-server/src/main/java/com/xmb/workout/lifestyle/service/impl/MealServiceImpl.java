package com.xmb.workout.lifestyle.service.impl;

import com.alibaba.fastjson.JSON;
import com.xmb.workout.config.MealConfig;
import com.xmb.workout.lifestyle.RecommendMealDTO;
import com.xmb.workout.lifestyle.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * Author by Ben
 * On 2019-08-28.
 *
 * @Descption
 */
@Service
public class MealServiceImpl implements MealService {

    private Logger logger = LoggerFactory.getLogger(MealServiceImpl.class);

    private Random random = new Random();

    @Autowired
    MealConfig mealConfig;

    @Override
    public RecommendMealDTO getRecommendMeal() {

        RecommendMealDTO recommendMealDTO = new RecommendMealDTO();

        //是否老火汤标记
        boolean needSoupBisque = (random.nextInt(10) % 2) == 1;
        if (needSoupBisque) {
            recommendMealDTO.setSoupBisque(getRandomMeal(mealConfig.getSoupBisque()));
        } else {
            recommendMealDTO.setSoupBroth(getRandomMeal(mealConfig.getSoupBroth()));
        }

        //是否两个菜炒肉
        boolean needVegetablesScrambledMeat = (random.nextInt(3) % 2) == 1;
        if (needVegetablesScrambledMeat) {
            recommendMealDTO.setVegetablesScrambledMeat(getRandomMeal(mealConfig.getVegetablesScrambledMeat()) + " + " + getRandomMeal(mealConfig.getVegetablesScrambledMeat()));
        } else {
            recommendMealDTO.setMeat(getRandomMeal(mealConfig.getMeat()));
            recommendMealDTO.setVegetables(getRandomMeal(mealConfig.getVegetables()));
        }

        logger.info("Meal = " + JSON.toJSONString(recommendMealDTO));

        return recommendMealDTO;
    }

    private String getRandomMeal(String mealConfigString) {
        if (!StringUtils.isEmpty(mealConfigString)) {
            String[] configArray = mealConfigString.split(", ");
            if (configArray.length > 0) {
                return configArray[random.nextInt(configArray.length)];
            }
        }
        return null;
    }
}
