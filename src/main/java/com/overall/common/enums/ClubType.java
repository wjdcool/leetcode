package com.overall.common.enums;

/**
 * 俱乐部类型
 */
public enum ClubType implements EnumType {
    CLUB(1, "俱乐部"),
    COMMUNITY(2, "区镇");

    private Integer value;
    private String label;

    ClubType(Integer value, String label) {
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
