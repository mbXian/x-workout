package com.xmb.workout.workout.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ben
 * @date 2020-12-10
 * @desc
 */
@Data
public class WorkoutKeepOnDaysVO {

    @ApiModelProperty("连续锻炼天数")
    private Integer keepOnDays;

}
