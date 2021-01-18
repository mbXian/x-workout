package com.xmb.workout.log.constant;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc
 */
public enum LogTypeEnum {
    API_LOG(1, "API Log")
    ;

    private Integer index;
    private String name;

    LogTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
