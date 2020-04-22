package com.xmb.workout.workout.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Ben
 * @date 2020-03-19
 */
@Data
public class StatisticsEachTypeDTO {
    private String mobile;
    private Date startDate;
    private Date endDate;
    private Integer type;
}
