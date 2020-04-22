package com.xmb.workout.workout.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Ben
 * @date 2020-03-19
 */
@Data
public class TodayStatisticsVO {
    private Long duration;
    private List<StatisticsEachTypeVO> statisticsEachTypeVOList;
}
