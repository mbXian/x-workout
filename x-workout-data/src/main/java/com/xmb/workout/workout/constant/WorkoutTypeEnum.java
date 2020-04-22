package com.xmb.workout.workout.constant;

/**
 * @author Ben
 * @date 2020-03-06
 */
public enum WorkoutTypeEnum {
    PUSH_UP(1, "俯卧撑"),
    SIT_UP(2, "仰卧起坐"),
    LATERAL_CRUNCHES(3, "侧向卷腹"),
    BENT_KNEE_V_UP(4, "触腿两头起"),
    ROPE_JUMPING(5, "跳绳"),
    AIR_CYCLING(6, "空中踩单车"),
    ;

    private Integer index;
    private String name;

    WorkoutTypeEnum(Integer index, String name) {
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
