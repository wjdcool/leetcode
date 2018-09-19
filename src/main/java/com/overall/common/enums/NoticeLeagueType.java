package com.overall.common.enums;

/**
 * 赛事通知类型
 */
public enum NoticeLeagueType implements EnumType {

    PROGRAM(1, "秩序册"),
    REPORT(2, "成绩单"),
    OTHER(3, "其他");

    private Integer value;
    private String label;

    NoticeLeagueType(Integer value, String label) {
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
