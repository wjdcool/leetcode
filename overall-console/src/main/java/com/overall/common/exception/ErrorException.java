package com.overall.common.exception;

/**
 * 
 * @author  作者  GXS
 * @date    创建时间  2018年3月21日 下午5:53:37  
 * @description  自定义异常
 */
public class ErrorException extends RuntimeException {

	private static final long serialVersionUID = -2608373317729107675L;

	public ErrorException() {
		super();
	}

	public ErrorException(String message) {
		super(message);
	}

	public ErrorException(Throwable cause) {
		super(cause);
	}

	public ErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
