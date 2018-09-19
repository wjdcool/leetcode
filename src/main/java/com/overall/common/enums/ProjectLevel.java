package com.overall.common.enums;

/**
 * 项目级别
 */
public enum ProjectLevel implements EnumType {

    INTERNATIONAL(1, "国际级"),
    NATIONAL(2, "国家级"),
    ONE(3, "一级"),
    TWO(4, "二级"),
    THREE(5, "三级");

    private Integer value;
    private String label;

    ProjectLevel(Integer value, String label) {
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
