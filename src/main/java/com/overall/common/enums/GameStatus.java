package com.overall.common.enums;

/**
 * 比赛状态
 */
public enum GameStatus implements EnumType {

    WAIT_ENROLL(1, "待报名"),
    ENROLLING(2, "报名中"),
    WAIT_START(3, "待开始"),
    STARTING(4, "比赛中"),
    END(5, "已结束");

    private Integer value;
    private String label;

    GameStatus(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
