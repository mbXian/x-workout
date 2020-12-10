package com.xmb.workout.workout.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ben
 * @date 2020-12-10
 * @desc
 */
@Data
public class WorkoutDaysSaturationVO {

    @ApiModelProperty("n天前饱和率")
    private double daysSaturation;

}
