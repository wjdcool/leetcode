package com.overall.common.enums;

public enum ParameterCode {
    /**
     * 无权限状态
     */
    ERROR_RESOURCE_STATUS("no-resource"),

    /**
     * 无令牌状态
     */
    ERROR_TOKEN_STATUS("no-token"),

    /**
     * header-token
     */
    LOGIN_TOKEN("X-Token"),

    /**
     * 文件上传大小
     */
    UPLOAD_MIU("1024MB"),

    /**
     * 文件流上传大小
     */
    UPLOAD_REQUEST("2048MB"),

    /**
     * 枚举包路径
     */
    ENUM_PACKAGE_NAME("com.overall.common.enums"),

    /**
     * 验证码默认字符源 字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
     */
    VERIFY_CODES("23456789ABCDEFGHJKLMNPQRSTUVWXYZ"),

    /**
     * 验证码图片默认宽度
     */
    VERIFY_WIDTH(200),

    /**
     * 验证码图片默认高度
     */
    VERIFY_HEIGHT(80),

    /**
     * token有效时间
     */
    TOKEN_VALID(24L * 60L * 60L * 1000L);

    private final String code;
    private final Integer intValue;
    private final Long longValue;

    ParameterCode(String code) {
        this.code = code;
        this.intValue = 0;
        this.longValue = 0L;
    }

    ParameterCode(Integer intValue) {
        this.code = "";
        this.intValue = intValue;
        this.longValue = 0L;
    }

    ParameterCode(Long longValue) {
        this.code = "";
        this.intValue = 0;
        this.longValue = longValue;
    }

    public String getCode() {
        return code;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Long getLongValue() {
        return longValue;
    }

}
