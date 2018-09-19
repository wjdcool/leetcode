package com.overall.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j 日志级别：trace<debug<info<warn<error
 * 
 * @author GXS
 * @version 1.0
 */
public class LoggerMgr {
	/**
	 * 将报错信息写入到log中<br>
	 * 
	 * @param cls
	 * @param message
	 */
	public static void trace(Class<?> cls, String message) {
		getLogger(cls).trace(message);
	}

	/**
	 * 将带参数的报错信息写入到log中 <br>
	 * 调用方式：LoggerMgr.trace(XX.class, "测试：{}, {}", "Hello", "World!") <br>
	 * 大括号是占位符
	 * 
	 * @param cls
	 * @param message
	 * @param objs
	 */
	public static void trace(Class<?> cls, String message, Object... objs) {
		getLogger(cls).trace(message, objs);
	}

	/**
	 * 将exception写入log中
	 * 
	 * @param cls
	 * @param message
	 * @param t
	 */
	public static void trace(Class<?> cls, String message, Throwable t) {
		getLogger(cls).trace(message, t);
	}

	public static void debug(Class<?> cls, String message) {
		getLogger(cls).debug(message);
	}

	public static void debug(Class<?> cls, String message, Object... objs) {
		getLogger(cls).debug(message, objs);
	}

	public static void debug(Class<?> cls, String message, Throwable t) {
		getLogger(cls).debug(message, t);
	}

	public static void info(Class<?> cls, String message) {
		getLogger(cls).info(message);
	}

	public static void info(Class<?> cls, String message, Object... objs) {
		getLogger(cls).info(message, objs);
	}

	public static void info(Class<?> cls, String message, Throwable t) {
		getLogger(cls).info(message, t);
	}

	public static void warn(Class<?> cls, String message) {
		getLogger(cls).warn(message);
	}

	public static void warn(Class<?> cls, String message, Object... objs) {
		getLogger(cls).warn(message, objs);
	}

	public static void warn(Class<?> cls, String message, Throwable t) {
		getLogger(cls).warn(message, t);
	}

	public static void error(Class<?> cls, String message) {
		getLogger(cls).error(message);
	}

	public static void error(Class<?> cls, String message, Object... objs) {
		getLogger(cls).error(message, objs);
	}

	public static void error(Class<?> cls, String message, Throwable t) {
		getLogger(cls).error(message, t);
	}

	private static Logger getLogger(Class<?> cls) {
		return LoggerFactory.getLogger(cls);
	}

	public static void main(String[] args) {
		LoggerMgr.error(LoggerMgr.class, "Hello world {}", "aaa");
	}
}
