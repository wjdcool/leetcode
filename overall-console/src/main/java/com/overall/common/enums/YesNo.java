package com.overall.common.enums;

/**
 * 是否
 */
public enum YesNo implements EnumType {

    YES(1, "是"),
    NO(0, "否");

    private Integer value;
    private String label;

    YesNo(Integer value, String label) {
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
