package com.overall.common.enums;

/**
 * 俱乐部级别
 */
public enum ClubLevel implements EnumType {

    LEVEL_A(3, "甲级"),
    LEVEL_B(2, "乙级"),
    LEVEL_C(1, "丙级");

    private Integer value;
    private String label;

    ClubLevel(Integer value, String label) {
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
