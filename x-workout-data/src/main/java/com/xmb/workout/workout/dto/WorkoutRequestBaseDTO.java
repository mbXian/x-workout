package com.xmb.workout.workout.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Ben
 * @date 2020-12-10
 * @desc
 */
@Data
public class WorkoutRequestBaseDTO {

    @ApiModelProperty("用户手机号")
    @NotEmpty(message = "参数错误！")
    private String userMobile;

}
