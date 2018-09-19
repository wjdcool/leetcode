package com.overall.common.enums;

/**
 * 学历
 */
public enum ResultCode {
	/** 成功 */
	CODE_200(200),

	/** 用户失效，需要重新登录 */
	ERROR_CODE_401(401),

	/** 程序错误，无法解决 */
	ERROR_CODE_500(500),

	/** 错误提示 */
	ERROR_CODE_403(403);

	private final Integer code;

	ResultCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
