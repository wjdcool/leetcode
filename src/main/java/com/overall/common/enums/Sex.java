package com.overall.common.enums;

/**
 * 性别
 */
public enum Sex implements EnumType {
    MALE(1, "男"),
    FEMALE(2, "女");

    private Integer value;
    private String label;

    Sex(Integer value, String label) {
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
