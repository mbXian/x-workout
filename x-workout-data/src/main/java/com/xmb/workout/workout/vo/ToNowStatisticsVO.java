package com.xmb.workout.workout.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Ben
 * @date 2020-03-19
 */
@Data
public class ToNowStatisticsVO {
    private Long duration;
    private Long times;
    private Date startTrainTime;
    private Date endTrainTime;
    private List<StatisticsEachTypeVO> statisticsEachTypeVOList;
}
