package com.xmb.workout.workout.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Ben
 * @date 2020-03-20
 */
@Data
public class StatisticsDurationAndTimesDTO {
    private String mobile;
    private Date startDate;
    private Date endDate;
}
