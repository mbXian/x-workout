package com.xmb.workout.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author by Ben
 * On 2019-08-28.
 *
 * @Descption
 */
@ConfigurationProperties("meal")
@Configuration
public class MealConfig {

    //老火汤
    private String soupBisque;
    //例汤
    private String soupBroth;
    //菜炒肉
    private String vegetablesScrambledMeat;
    //肉
    private String meat;
    //青菜
    private String vegetables;

    public String getSoupBisque() {
        return soupBisque;
    }

    public void setSoupBisque(String soupBisque) {
        this.soupBisque = soupBisque;
    }

    public String getSoupBroth() {
        return soupBroth;
    }

    public void setSoupBroth(String soupBroth) {
        this.soupBroth = soupBroth;
    }

    public String getVegetablesScrambledMeat() {
        return vegetablesScrambledMeat;
    }

    public void setVegetablesScrambledMeat(String vegetablesScrambledMeat) {
        this.vegetablesScrambledMeat = vegetablesScrambledMeat;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }
}
