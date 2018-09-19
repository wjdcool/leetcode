package com.overall.common.enums;

/**
 * 通知类型
 */
public enum NoticeTyep implements EnumType {

    SYSTEM(1, "系统通知"),
    LEAGUE(2, "赛事通知");

    private Integer value;
    private String label;

    NoticeTyep(Integer value, String label) {
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
