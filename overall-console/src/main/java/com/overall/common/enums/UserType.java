package com.overall.common.enums;

/**
 * 账号类型
 */
public enum UserType implements EnumType {
    SYSTEM_ADMIN(1, "系统管理员"),
    CLUB_ADMIN(2, "俱乐部管理员");

    private Integer value;
    private String label;

    UserType(Integer value, String label) {
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
