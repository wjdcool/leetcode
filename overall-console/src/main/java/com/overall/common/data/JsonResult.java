package com.overall.common.data;

import java.io.Serializable;

import com.overall.common.enums.ResultCode;

/**
 * 
 * @author GXS
 * @date 2018年4月9日
 * @Description:json对象
 */
public class JsonResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_MESSAGE = "服务器出现了一些小状况，正在修复中！";

	private Integer code;

	private Object data;

	private String desc;

	public JsonResult(Integer code, Object data, String desc) {
		this.data = data;
		this.desc = desc;
		this.code = code;
	}

	public static JsonResult success(Object data, String desc) {
		return new JsonResult(ResultCode.CODE_200.getCode(), data, desc);
	}

	public static JsonResult lose(String desc) {
		return new JsonResult(ResultCode.ERROR_CODE_401.getCode(), null, desc);
	}

	public static JsonResult fail(String desc) {
		return new JsonResult(ResultCode.ERROR_CODE_403.getCode(), null, desc);
	}

	public static JsonResult error() {
		return new JsonResult(ResultCode.ERROR_CODE_500.getCode(), null, ERROR_MESSAGE);
	}

	public JsonResult() {

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
