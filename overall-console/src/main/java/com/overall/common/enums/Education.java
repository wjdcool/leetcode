package com.overall.common.enums;

/**
 * 学历
 */
public enum Education implements EnumType {
    PRIMARY_SCHOOL_GRADUATED(1, "小学及以下"),
    MIDDLE_SCHOOL_GRADUATED(2, "初中"),
    HIGH_SCHOOL_GRADUATED(3, "高中"),
    SPECIAL_SCHOOL_GRADUATED(4, "中专"),
    COLLEGE_GRADUATED(5, "大专"),
    BACHELOR(6, "本科"),
    MASTER(7, "硕士研究生"),
    DOCTOR(8, "博士研究生及以上");

    private Integer value;
    private String label;

    Education(Integer value, String label) {
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
