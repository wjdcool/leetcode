package com.overall.common.enums;

public enum EnabledStatus implements EnumType {

    ENABLED(1, "有效"),
    DISABLED(2, "无效");

    private Integer value;
    private String label;

    EnabledStatus(Integer value, String label) {
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
