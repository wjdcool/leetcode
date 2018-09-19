package com.overall.common.enums;

/**
 * 审批状态
 */
public enum ApproveStatus implements EnumType{

    WAIT(1, "待审批"),
    APPROVED(2, "已通过"),
    REJECT(3, "已拒绝");

    private Integer value;
    private String label;

    ApproveStatus(Integer value, String label) {
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
