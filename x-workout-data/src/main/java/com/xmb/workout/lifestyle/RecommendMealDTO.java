package com.xmb.workout.lifestyle;

import lombok.Data;


/**
 * @author Ben
 * @date 2019-08-28.
 *
 * 推荐餐饮
 */
@Data
public class RecommendMealDTO {
    /**
     * 老火汤
     */
    private String soupBisque;
    /**
     * 例汤
     */
    private String soupBroth;
    /**
     * 菜炒肉
     */
    private String vegetablesScrambledMeat;
    /**
     * 肉
     */
    private String meat;
    /**
     * 青菜
     */
    private String vegetables;
}
