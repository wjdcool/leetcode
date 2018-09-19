package com.overall.common.enums;

public enum MessageParameter {
    /** 服务器出现了一些小状况，正在修复中！*/
    SERVICE_ERROR,

    /** 保存成功！*/
    SAVE_SUCCESS,

    /** 修改成功！*/
    UPDATE_SUCCESS,

    /** 删除成功！*/
    DELETE_SUCCESS,

    /** 查询成功！*/
    SEARCH_SUCCESS,

    /** 操作成功！*/
    OPERATE_SUCCESS,

    /** 登录成功！*/
    LOGIN_SUCCESS,

    /** 退出成功！*/
    LOGIN_OUT_SUCCESS,

    /** 注册成功！*/
    REGISTER_SUCCESS,

    /** 账号已失效，请重新登录！*/
    LOGIN_STATUS_ERROR,

    /** 没有资源权限，请重新登录！*/
    RESOURCE_ERROR,

    /** 账号密码不匹配！*/
    LOGIN_PASSWORD_ERROR,

    /** 修改密码H5地址*/
    UPDATE_PWD_URL,

    /** 密码修改链接超时*/
    PASSWORD_TOKEN_TIMEOUT,

    /** %不能为空*/
    EMPTY_ERROR,

    /** 账号不存在*/
    ACCOUNT_NO_EXITS,

    /** 账号被禁用*/
    ACCOUNT_DISABLED,

    /** %s未注册*/
    NO_REGISTER_ERROR,

    /** %s已被注册*/
    REGISTER_ERROR,

    /** 系统管理员角色*/
    SYSTEM_ADMIN_ROLE,

    /** 俱乐部管理员角色*/
    CLUB_ADMIN_ROLE,

    /** %s已存在*/
    EXITS_ERROR,

    /** 数据已删除，请刷新后查看！*/
    INFO_DELETED,

    /** 数据已审核，请刷新后查看！*/
    INFO_APPROVED,

    /** 修改密码邮件标题！*/
    EMAIL_SUBJECT,

    /** 修改密码邮件内容！*/
    EMAIL_CONTENT,

    /** 俱乐部管理登录审核中提示*/
    LOGIN_WAIT_APPROVE,

    /** 密码修改链接有效时间（单位：分钟）*/
    PASSWORD_VALID_MIN,

    /** 注册须知*/
    REGISTER_NOTE,

    /** 运动员维护须知*/
    ADD_PLAYER_NOTE;
}
