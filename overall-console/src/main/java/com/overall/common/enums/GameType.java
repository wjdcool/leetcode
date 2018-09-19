package com.overall.common.enums;

/**
 * 比赛类型
 */
public enum GameType implements EnumType {

    LEAGUE(1, "联赛"),
    COMMUNITY(2, "群体活动");

    private Integer value;
    private String label;

    GameType(Integer value, String label) {
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
