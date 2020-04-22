package com.xmb.workout.workout.vo;

import lombok.Data;

/**
 * @author Ben
 * @date 2020-03-19
 */
@Data
public class StatisticsEachTypeVO {
    private Integer type;
    private String name;
    private String nameCN;
    private Long countTotal;
}
