package com.xmb.workout.workout.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Ben
 * @date 2020-03-20
 */
@Data
public class QueryStartOrEndTimeDTO {
    private String mobile;
    @ApiModelProperty("排序类型（0：asc；1：desc）")
    private Integer sortType;
}
