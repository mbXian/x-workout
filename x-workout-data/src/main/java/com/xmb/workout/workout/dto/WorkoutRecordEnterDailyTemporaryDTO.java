package com.xmb.workout.workout.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Ben
 * @date 2020-03-11
 */
@ApiModel("临时登记参数DTO")
@Data
public class WorkoutRecordEnterDailyTemporaryDTO {

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty("开始训练时间")
    @NotNull(message = "开始训练时间不能为空")
    private Long trainTimeMilliSec;

    @ApiModelProperty("结束训练时间")
    @NotNull(message = "结束训练时间不能为空")
    private Long finishTimeMilliSec;

    /**
     * 经度
     */
    private BigDecimal latitude;

    /**
     * 纬度
     */
    private BigDecimal longitude;
}
