package com.overall.common.enums;

public enum ApproveType implements EnumType {

    CLUB(1, "俱乐部"),
    REFEREE(2, "裁判"),
    LEAGUE(3, "联赛"),
    COMMUNITY(4, "群体活动");

    private Integer value;
    private String label;

    ApproveType(Integer value, String label) {
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
