package com.overall.common.enums;

public enum QuelifyType implements EnumType {

    CLUB(1, "俱乐部"),
    PLAYER(2, "运动员");

    private Integer value;
    private String label;

    QuelifyType(Integer value, String label) {
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
