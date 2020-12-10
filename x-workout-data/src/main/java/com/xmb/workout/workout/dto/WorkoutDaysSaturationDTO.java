package com.xmb.workout.workout.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ben
 * @date 2020-12-10
 * @desc
 */
@Data
public class WorkoutDaysSaturationDTO extends WorkoutRequestBaseDTO {

    @ApiModelProperty("过去n天")
    @NotNull(message = "参数错误!")
    private Integer days;

}
