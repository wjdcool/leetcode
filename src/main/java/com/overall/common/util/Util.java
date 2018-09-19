package com.overall.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author 作者 GXS
 * @date 创建时间 2017年11月24日 下午4:32:19
 * @description 共通方法的定义
 */
public class Util {

	public static final String DATE_YYYY_MM_DD_JP = "yyyy/MM/dd";

	public static final String DATE_YYYY_MM_DD_CHN = "yyyy-MM-dd";

	public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd HH:mm";

	public static final String DATE_YYYY_MM_DD_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String TIME_HOUR24_MI_SS = "HH:mm:ss";

	public static final String DATE_TIME_PAT_19 = "yyyy/MM/dd HH:mm:ss";

	public static final String DATE_PAT_10 = "yyyy/MM/dd";

	public static final String DATE_TIME_FULL = "yyyy年MM月dd日 HH时mm分";

	public static final String DATE_PAT_8 = "yyyyMMdd";

	public static final String DATE_PAT_11 = "yyyyMM";

	public static final String DATE_PAT_12 = "yyyy";

	public static final String DATE_PAT_13 = "MM";

	public static final String DATE_PAT_14 = "dd";

	public static final String DATE_PAT_15 = "d";

	public static final String DATE_PAT_KANJI = "yyyy年MM月dd日";

	public static final String DATE_SHT_PAT_8 = "yy/MM/dd";

	public static final String DATE_SHT_PAT_6 = "yyMMdd";

	public static final String DATE_SHT_PAT_KANJI = "yy年MM月dd日";

	public static final String DATE_MONTH_DAY = "MM月dd日";

	public static final String DATE_MONTH_DAY_ = "MM/dd";

	public static final String YEAR_MONTH = "yyyy/MM";

	public static final String YEAR_MONTH_ = "yyyy-MM";

	public static final String DATE_TIME_FULL_WITH_SECOND = "yyyy年MM月dd日 HH時mm分ss秒";

	public static final String DATE_TIME_FULL_WITH_SECOND_ = "yyyy年MM月dd日 HH:mm:ss";

	public static final String DATE_TIME_FULL1_ = "MM月dd日 HH:mm";

	public static final String DATE_TIME_FULL2_ = "MM-dd HH:mm";

	public static final String DATE_TIME_FULL_PAT_24 = "yyyy/MM/dd HH:mm:ss SSS";

	public static final String DATE_TIME_FULL_PAT_24_ = "yyyy-MM-dd HH:mm:ss SSS";

	public static final String DATE_TIME_FULL_PAT_17 = "yyyyMMddHHmmssSSS";

	public static final String DATE_TIME_PAT_19_ = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_TIME_PAT_CALENDER = "yyyy/MM/dd HH:mm";

	public static final String DATE_TIME_PAT_14 = "yyyyMMddHHmmss";

	public static final String DATE_TIME_PAT_SHOW = "yyyy/MM/dd HH:mm";

	public static final String HOUR_TIME_PAT_5 = "HH:mm";

	public static final String HOUR_TIME_PAT_4 = "HHmm";

	public static final String NUMBER_PAT = "###############.#";

	private static final DecimalFormat numFormatterWithComma = new DecimalFormat("###,###,###,###,###");

	private static final DecimalFormat numFormatter = new DecimalFormat("###############");

	private static final DecimalFormat moneyFormat = new DecimalFormat("###############");

	public static final int DEFAULT_SHORT_STRING_LEN = 14;

	protected static final Integer INTEGER_ZERO = 0;

	protected static final String DB_NULL_STR = "null";

	protected static final String DB_NULL_NUMBER = Integer.toString(Integer.MIN_VALUE);

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static final String EMPTY_STRING = "";

	/**
	 * @param value 日期
	 * @param pattern 转变格式
	 * @return 变化的结果
	 */
	public static String date2Str(Date value, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		try {
			return sdf.format(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "date2Str错误", e);
			return null;
		}
	}

	/**
	 * String转换为Date类型
	 * 
	 * @param value 字符串
	 * @param pattern 转换格式
	 * @return 转换后的结果
	 */
	public static Date str2Date(String value, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		try {
			return sdf.parse(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Date错误", e);
			return null;
		}
	}

	/**
	 * @description :时间戳转换为时间
	 * @author yq 2017年9月22日 下午2:08:06
	 * @param value
	 * @return
	 */
	public static Date long2Date(Long value) {
		Date date = new Date(value);
		return date;
	}

	/**
	 * String转换为Timestamp类型
	 * 
	 * @param value 字符串
	 * @param pattern 转换格式
	 * @return 转换后的结果
	 */
	public static Timestamp str2Timestamp(String value, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		try {
			if (sdf.parse(value) != null) {
				return new Timestamp(sdf.parse(value).getTime());
			}
			return null;
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Timestamp错误", e);
			return null;
		}
	}

	/**
	 * String转换为Date类型
	 * 
	 * @param value 字符串
	 * @param pattern 转换格式
	 * @return 转换后的结果
	 */
	public static java.sql.Date str2SqlDate(String value, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		try {
			return new java.sql.Date(sdf.parse(value).getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * String转换为Integer
	 * 
	 * @param value 字符串
	 * @return 返回值（不正确的情况返回值为NULL）
	 */
	public static Integer str2Int(String value) {
		if (Util.isEmpty(value)) {
			LoggerMgr.warn(Util.class, "str2Int的输入参数值为空！ ");
			return null;
		}

		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Int错误", e);
			return null;
		}
	}

	/**
	 * String转换为Float
	 * 
	 * @param value 字符串
	 * @return 返回值（不正确的情况返回值为NULL）
	 */
	public static Float str2Float(String value) {
		if (Util.isEmpty(value)) {
			LoggerMgr.warn(Util.class, "str2Float的输入参数值为空！ ");
			return null;
		}

		try {
			return Float.parseFloat(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Float错误", e);
			return null;
		}
	}

	/**
	 * String转换为Long
	 * 
	 * @param value 输入值
	 * @return 返回值（不正确的情况返回值为NULL）
	 */
	public static Long str2Long(String value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "str2Long的输入参数值为空！ ");
			return null;
		}
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Long错误", e);
			return null;
		}
	}

	/**
	 * 字符串转换为DOUBLE
	 * 
	 * @param value 文字列
	 * @return 转换后的文字（错误情况，返回值为NULL）
	 */
	public static Double str2Double(String value) {
		if (Util.isEmpty(value)) {
			LoggerMgr.warn(Util.class, "str2Double的输入参数值为空！ ");
			return null;
		}

		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "str2Double错误", e);
			return null;
		}
	}

	/**
	 * 数值文字的转换
	 * 
	 * @param value 输入的字符串
	 * @return 转换后的文字
	 */
	public static String numToStringWithComma(Object value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "numToStringWithComma的输入参数值为空！ ");
			return null;
		}

		return numFormatterWithComma.format(value);
	}

	/**
	 * 数值文字的转换
	 * 
	 * @param value 输入的字符串
	 * @return 转换后的文字
	 */
	public static String numToString(Object value) {
		if (value == null) {
			return null;
		}
		return numFormatter.format(value);
	}

	/**
	 * 数值文字的转换
	 * 
	 * @param value 输入的字符串
	 * @return 转换后的文字
	 */
	public static String numToStrForMoney(Object value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "numToStrForMoney的输入参数值为空！ ");
			return null;
		}
		return moneyFormat.format(value);
	}

	/**
	 * 数值文字的转换
	 * 
	 * @param value 输入的字符串
	 * @return 转换后的文字
	 */
	public static Number stringToNumWithComma(String value) {
		if (Util.isEmpty(value)) {
			LoggerMgr.warn(Util.class, "stringToNumWithComma的输入参数值为空！ ");
			return null;
		}

		try {
			return numFormatterWithComma.parse(value);
		} catch (Exception e) {
			LoggerMgr.error(Util.class, "stringToNumWithComma错误", e);
			return null;
		}

	}

	/**
	 * 将阿拉伯文字转成中文（一、二..十）
	 * 
	 * @param obj 输入的阿拉伯数字
	 * @return 转换后的中文一、二、三..十
	 */
	public static String albToZW(int obj) {
		String[] str1 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[] str2 = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
		for (int i = 0; i < 10; i++) {
			if (obj == str2Int(str1[i])) {
				return str2[i];
			}
		}
		return null;
	}

	/**
	 * Object转换为String
	 * 
	 * @param value 输入值
	 * @return 返回值（不正确的场合，返回值为NULL）
	 */
	public static String objToStr(Object value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "objToStr的输入参数值为空！ ");
			return null;
		} else {
			return value.toString();
		}
	}

	public static String numToStringNoZero(Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof Integer) {
			Integer data = (Integer) value;
			if (data.intValue() == 0) {
				return null;
			}
		} else if (value instanceof Long) {
			Long data = (Long) value;
			if (data.longValue() == 0) {
				return null;
			}
		} else if (value instanceof Double) {
			Double data = (Double) value;
			if (data.doubleValue() == 0) {
				return null;
			}
		} else if (value instanceof Float) {
			Float data = (Float) value;
			if (data.floatValue() == 0) {
				return null;
			}
		}

		return value.toString();
	}

	/**
	 * Null字符串的转换
	 * 
	 * @param value 输入值
	 * @return 返回值
	 */
	public static String null2Empty(String value) {
		if (value == null) {
			return EMPTY_STRING;
		} else {
			return value;
		}
	}

	/**
	 * 字符串长度的取得
	 * 
	 * @param value 原字符串的长度
	 * @param length 指定的文字长度
	 * @return 截取后的结果
	 */
	public static String cutStr(String value, int len) {
		if (Util.isEmpty(value)) {
			return value;
		}
		if (value.length() <= len) {
			return value;
		}

		value = value.substring(0, len);
		return value;
	}

	/**
	 * 截取字符串(Byte)
	 * 
	 * @param value 原字符串
	 * @param length 指定byte长度
	 * @return 截取后的结果
	 */
	public static String cutStrByByte(String value, int length) {
		if ((value == null) || (length < 0)) {
			return value;
		}

		byte byteArr[] = value.getBytes();
		if (byteArr.length <= length) {
			return value;
		}

		String strNew = new String(byteArr, 0, length);
		if (value.indexOf(strNew) == 0) {
			return strNew;
		} else {
			return strNew.substring(0, strNew.length() - 1);
		}
	}

	/**
	 * Ajax输出字符串的转换
	 * 
	 * @param value 输入值
	 * @return 输出值
	 */
	public static String convForAjax(String value) {
		if (value == null) {
			return EMPTY_STRING;
		} else {
			return value.replaceAll("\\|", "||");
		}
	}

	public static final String STR_62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/**
	 * 10进制到62进制的转换（0-9, A-Z,a-z)
	 * 
	 * @param value 输入十进制的数字
	 * @return 62进制的字符串
	 */
	public static String changeTo62(Long value) {
		if (value == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		long tmpValue = (value >= 0 ? value : -value);

		while (true) {
			if (tmpValue == 0) {
				break;
			}
			int aLeft = (int) (tmpValue % 62);

			sb.insert(0, STR_62.charAt(aLeft));
			tmpValue = (tmpValue - aLeft) / 62;
		}

		if (sb.length() == 0) {
			return "0";
		} else {
			if (value < 0) {
				sb.insert(0, "-");
			}
			return sb.toString();
		}
	}

	/**
	 * SQL语句生成时、NULL对象的处理（文字列）
	 * 
	 * @param value 输入值
	 * @return 返回结果值
	 */
	public static String convForSql(String value) {
		if (value == null) {
			return DB_NULL_STR;
		} else {
			value = value.trim();

			return value;
		}
	}

	public static String convForSqlHasQuot(String value) {
		if (value == null) {
			return DB_NULL_STR;
		} else {
			value = value.trim();

			if (value.indexOf("'") >= 0) {
				value = value.replace("'", "''");
			}
			return value;

		}
	}

	public static String convForSqlNoQuot(String value) {
		if (value == null) {
			return DB_NULL_STR;
		} else {
			value = value.trim();

			if (value.indexOf("'") >= 0) {
				value = value.replace("'", "''");
			}

			if (value.indexOf("\\") >= 0) {
				value = value.replace("\\", "\\\\");
			}

			if (value.indexOf("%") >= 0) {
				return value.replace("%", "\\%");
			} else {
				return value;
			}

		}
	}

	/**
	 * SQL语句生成时、NULL对象的处理（Long）
	 * 
	 * @param value 输入值
	 * @return 返回结果值
	 */
	public static String convForSql(Long value) {
		if (value == null) {
			return DB_NULL_NUMBER;
		} else {
			return value.toString();
		}
	}

	/**
	 * SQL语句生成时、NULL对象的处理（Double）
	 * 
	 * @param value 输入值
	 * @return 返回结果值
	 */
	public static String convForSql(Double value) {
		if (value == null) {
			return DB_NULL_NUMBER;
		} else {
			return value.toString();
		}
	}

	/**
	 * SQL语句生成时、NULL对象的处理（Integer）
	 * 
	 * @param value 输入值
	 * @return 返回结果值
	 */
	public static String convForSql(Integer value) {
		if (value == null) {
			return DB_NULL_NUMBER;
		} else {
			return value.toString();
		}
	}

	/**
	 * NULL对象的处理（Integer）
	 * 
	 * @param value 输入值
	 * @return 返回结果值
	 */
	public static Integer convForInteger(Integer value) {
		if (value == null) {
			return INTEGER_ZERO;
		} else {
			return value;
		}
	}

	/**
	 * SQL语句生成时、日期格式的转换(Timestamp)
	 * 
	 * @param value 输入值
	 * @return 返回的结果值
	 */
	public static String convForSql(java.sql.Timestamp value) {
		if (value == null) {
			return DB_NULL_STR;
		} else {
			String strValue = date2Str(new java.util.Date(value.getTime()), DATE_TIME_PAT_19);
			return "to_date('" + strValue + "', 'yyyy/mm/dd hh24:mi:ss')";
		}
	}

	/**
	 * SQL语句生成时、日期格式的转换
	 * 
	 * @param value 输入值
	 * @return 返回的结果值
	 */
	public static String convForSql(java.sql.Date value) {
		if (value == null) {
			return DB_NULL_STR;
		} else {
			String strValue = date2Str(new java.util.Date(value.getTime()), DATE_PAT_10);
			return "to_date('" + strValue + "', 'yyyy/mm/dd')";
		}
	}

	/**
	 * exception 字符串的转换
	 * 
	 * @param e Exception
	 * @return 返回文字列
	 */
	public static String convException2Str(Exception e) {
		if (e == null) {
			return EMPTY_STRING;
		}

		try {
			StringWriter strWriter = new StringWriter();
			PrintWriter prnWriter = new PrintWriter(strWriter);
			e.printStackTrace(prnWriter);
			prnWriter.close();
			strWriter.close();
			return strWriter.toString();

		} catch (Exception e1) {
			return EMPTY_STRING;
		}
	}

	/**
	 * 特殊字符转换为URL
	 * 
	 * @param value
	 * @return
	 */
	public static String strEncode(String value) {
		String result = "";
		if (Util.isEmpty(value)) {
			LoggerMgr.warn(Util.class, "strEncode的输入参数值为空！ ");
			return null;
		}

		result = value;

		result = result.replace("%3C", "<");
		result = result.replace("%3E", ">");
		result = result.replace("%26", "&");
		result = result.replace("%22", "\"");
		result = result.replace("%27", "\'");
		result = result.replace("%3F", "?");
		result = result.replace("%20", " ");
		result = result.replace("%23", "#");
		result = result.replace("%5C", "\\");
		result = result.replace("%5D", "+");
		result = result.replace("%25", "%");

		return result;
	}

	/**
	 * HTML字符串转换
	 * 
	 * @param value 输入的字符串
	 * @return
	 */
	public static String convForHtml(String value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "convForHtml的输入参数值为空！ ");
			return "";
		}
		String result = value.replaceAll("&", "&amp;");
		result = result.replaceAll("<", "&lt;");
		result = result.replaceAll(">", "&gt;");
		result = result.replaceAll("\"", "&quot;");

		return result;
	}

	/**
	 * HTML字符转换
	 */
	public static String reconvForHtml(String value) {
		if (value == null) {
			LoggerMgr.warn(Util.class, "reconvForHtml的输入参数值为空！ ");
			return "";
		}
		String result = value.replaceAll("&lt;", "<");
		result = result.replaceAll("&gt;", ">");
		result = result.replaceAll("&quot;", "\"");
		result = result.replaceAll("&amp;", "&");

		return result;
	}

	public static java.sql.Date timestampToDate(Timestamp p) {
		if (p == null) {
			LoggerMgr.warn(Util.class, "timestampToDate的输入参数值为空！ ");
			return null;
		}
		return new java.sql.Date(p.getTime());
	}

	public static String timestamp2String(Timestamp stamp, String pattern) {
		if (stamp == null) {
			LoggerMgr.warn(Util.class, "timestamp2String的输入参数值为空！ ");
			return EMPTY_STRING;
		}
		if ((Util.isEmpty(pattern))) {
			pattern = DATE_TIME_FULL;
		}
		Date date = new Date(stamp.getTime());
		String showStr = date2Str(date, pattern);
		if (showStr == null) {
			return EMPTY_STRING;
		}
		return showStr;
	}

	public static String numToStr(Object value, String pattern) {
		if (value == null || Util.isEmpty(pattern)) {
			return null;
		}

		DecimalFormat df = new DecimalFormat(pattern);

		return df.format(value);
	}

	public static String dateToDay(String value, int day, String pattern) {
		if (Util.isEmpty(value)) {
			return null;
		}
		if ((Util.isEmpty(pattern))) {
			pattern = DATE_TIME_FULL;
		}

		Date date = str2Date(value, pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();

		return date2Str(date, pattern);
	}

	/**
	 * 将驼峰式命名转换为下划线型
	 * 
	 * @param str
	 * @return
	 * @author L
	 * @date 2016年1月26日
	 * @modified L
	 */
	public static String convCamel2Underline(String str) {
		if (Util.isEmpty(str)) {
			return "";
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			String iStr = str.substring(i, i + 1);
			if (iStr.toUpperCase().equals(iStr)) {
				sb.append("_");
				sb.append(iStr.toLowerCase());
			} else {
				sb.append(iStr);
			}
		}

		return sb.toString();
	}

	/**
	 * 将下划线型命名改为驼峰型
	 * 
	 * @param str
	 * @return
	 * @author L
	 * @date 2016年1月26日
	 * @modified L
	 */
	public static String convUnderline2Camel(String str) {
		if (Util.isEmpty(str)) {
			return "";
		}

		String[] strs = str.split("_");

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			String iStr = strs[i];
			if (i == 0) {
				sb.append(iStr.toLowerCase());
			} else {
				sb.append(iStr.substring(0, 1).toUpperCase());
				sb.append(iStr.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * 空检查
	 */
	public static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		} else {
			if (value instanceof String) {
				String strTmp = (String) value;
				if (strTmp.trim().length() == 0) {
					return true;
				} else {
					return false;
				}
			} else if (value instanceof Collection) {
				Collection<?> datalist = (Collection<?>) value;
				if (datalist.size() == 0) {
					return true;
				} else {
					return false;
				}
			} else if (value instanceof Map) {
				Map<?, ?> datalist = (Map<?, ?>) value;
				if (datalist.size() == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static boolean isEmptyList(Collection<?> list) {
		if (list == null) {
			return true;
		} else if (list.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmptyMap(Map<?, ?> list) {
		if (list == null) {
			return true;
		} else if (list.size() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	private static final String REG_RXPRE_RESV[] = { "\\.", "\\^", "\\$", "\\[", "\\]", "\\*", "\\+", "\\?", "\\|", "\\(", "\\)" };

	/**
	 * 正则表达式ReplaceAll
	 * 
	 * @param value 要替换的字符
	 * @param origStr 替换的原字符串
	 * @param replStr 替换的字符串
	 * @return
	 */
	public static String replaceAll(String value, String origStr, String replStr) {
		if ((value == null) || (origStr == null)) {
			return value;
		} else {
			if (replStr == null) {
				replStr = EMPTY_STRING;
			}
			for (String tmp : REG_RXPRE_RESV) {
				origStr = origStr.replaceAll(tmp, "\\" + tmp);
			}
			return value.replaceAll(origStr, replStr);
		}
	}

	/**
	 * project路径取得
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * 换行文字
	 * 
	 * @return
	 */
	public static String getLineSep() {
		return System.getProperty("line.separator");
	}

	/**
	 * 系统路径取得
	 */
	public static String getRuntimePath() {
		String strTmp = Util.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		int pos = strTmp.indexOf("classes");
		if (pos >= 0) {
			return strTmp.substring(0, pos + 8);
		} else {
			return EMPTY_STRING;
		}
	}

	/**
	 * 指定长度
	 * 
	 * @param size
	 * @return Random
	 */
	public static String getRandomStr(int size) {
		if (size <= 0) {
			return EMPTY_STRING;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			int pos = (int) (Math.random() * 62);
			if (pos < 0) {
				pos = 0;
			} else if (pos >= 62) {
				pos = 61;
			}
			sb.append(STR_62.charAt(pos));
		}
		return sb.toString();
	}

	/**
	 * 获取byte数
	 * 
	 * @param value
	 * @return
	 */
	public static int getByteNum(String value) {
		if (value == null) {
			return 0;
		}
		return value.getBytes().length;
	}

	/**
	 * 替换：[+][/] → [_][-]
	 * 
	 * @param sessId
	 * @return
	 */
	public static String convSessionId(String sessId) {
		if (sessId == null) {
			return EMPTY_STRING;
		}
		String result = sessId.replaceAll("\\+", "_");
		return result.replaceAll("/", "-");
	}

	/**
	 * 替换：[_][-] → [+][/]
	 * 
	 * @param sessId
	 * @return
	 */
	public static String convSessionIdRev(String sessId) {
		if (sessId == null) {
			return EMPTY_STRING;
		}
		String result = sessId.replaceAll("_", "+");
		return result.replaceAll("-", "/");
	}

	static final String CERT_BASE_LIST = "0123456789ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz_-";

	public static String getOcxCertifyPassword(int pwdLen) {
		StringBuffer sbCertifyPassword = new StringBuffer();
		int listLen = CERT_BASE_LIST.length();
		for (int iNum = 0; iNum < pwdLen; iNum++) {
			Random rand = new Random();
			int iPos = (int) (listLen * rand.nextDouble());
			if (iPos < 0) {
				iPos = 0;
			}
			if (iPos >= listLen) {
				iPos = listLen - 1;
			}
			sbCertifyPassword.append(CERT_BASE_LIST.charAt(iPos));
		}
		return sbCertifyPassword.toString();
	}

	/**
	 * @param param
	 * @param value [|]
	 * @return
	 */
	public static List<String> splitString(String value, String param) {
		List<String> result = new ArrayList<String>();
		if (value != null) {
			String list[] = value.split("\\" + param);
			for (int i = 0; i < list.length; i++) {
				result.add(list[i]);
			}
		}
		return result;
	}

	/**
	 * @param param
	 * @param value [|]
	 * @return
	 */
	public static List<String> splitFullString(String value, String param) {
		List<String> result = new ArrayList<String>();
		if (isEmpty(value)) {
			return result;
		} else if (isEmpty(param)) {
			result.add(value);
			return result;
		} else {
			while (true) {
				int iPos = value.indexOf(param);
				if (iPos < 0) {
					result.add(value);
					break;
				} else {
					result.add(value.substring(0, iPos));
					value = value.substring(iPos + param.length());
				}
			}
			return result;
		}
	}

	/**
	 * 换行文字替换 过期，可使用patch.css中的t_wrap标记页面上你需要\r\n换行的元素
	 * 
	 * @param value
	 * @return
	 */
	@Deprecated
	public static String replaceReturnWithBR(String value) {
		if (Util.isEmpty(value)) {
			return null;
		}
		String result = value.trim();
		result = result.replaceAll("\r\n", "<br/>");
		result = result.replaceAll("\n", "<br/>");
		return result;
	}

	/**
	 * CharArray
	 *
	 * @param array
	 * @param beginIndex
	 * @param endIndex
	 */
	public static char[] getCharArray(char[] array, int beginIndex, int endIndex) {
		if (array == null) {
			return null;
		}
		char[] tmp = new char[endIndex - beginIndex];
		int count = 0;
		for (int i = beginIndex; i < endIndex; i++) {
			if (i < array.length) {
				tmp[i - beginIndex] = array[i];
				count++;
			} else {
				break;
			}
		}
		char[] ret = new char[count];
		for (int i = 0; i < count; i++) {
			ret[i] = tmp[i];
		}
		return ret;
	}

	/**
	 * 保存文件
	 * 
	 * @param is 输入流
	 * @param filepath 输出文件地址
	 * @throws Exception
	 */
	public static void saveFile(BufferedInputStream is, String filepath) throws Exception {
		int bytesRead = 0;
		byte[] buffer = new byte[1024];
		FileOutputStream fos = new FileOutputStream(filepath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}
		bos.close();
		fos.close();
	}

	public static List<String> findDates(Date dBegin, Date dEnd) {
		List<String> lDate = new ArrayList<String>();
		lDate.add(date2Str(dBegin, DATE_YYYY_MM_DD_CHN));
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(dEnd);
		while (dEnd.after(calBegin.getTime())) {
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(date2Str(calBegin.getTime(), DATE_YYYY_MM_DD_CHN));
		}
		return lDate;
	}

	public static List<String> findMonths(Date dBegin, Date dEnd) {
		List<String> lDate = new ArrayList<String>();
		lDate.add(date2Str(dBegin, YEAR_MONTH_));
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(dEnd);
		while (dEnd.after(calBegin.getTime())) {
			calBegin.add(Calendar.MONTH, 1);
			lDate.add(date2Str(calBegin.getTime(), YEAR_MONTH_));
		}
		return lDate;
	}

	/**
	 * 删除文件夹中的文件（递归删除）
	 * 
	 * @param path
	 */
	public static void clearFolder(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			String[] list = file.list();
			for (String str : list) {
				clearFolder(path + "/" + str);
			}
		} else {
			file.delete();
		}
	}

	/**
	 * 删除文件夹中的文件（不递归删除）
	 * 
	 * @param path
	 */
	public static void clearFolderL1(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			String[] list = file.list();
			for (String str : list) {
				file = new File(path + "/" + str);
				if (!file.isDirectory()) {
					file.delete();
				}
			}
		}
	}

	/**
	 * 获取扩展名
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileExt(String filePath) {
		String fileExt = EMPTY_STRING;
		if (filePath == null) {
			return fileExt;
		}
		int iPos = filePath.lastIndexOf(".");
		if (iPos >= 0) {
			fileExt = filePath.substring(iPos + 1);
		}
		return fileExt;
	}

	/**
	 * 拼接字符串
	 * 
	 * @param obj1 字符串1（可以是Object类型，会自动转换）
	 * @param obj2 字符串1（可以是Object类型，会自动转换）
	 * @param combineSymbol 拼接标识字符串
	 * @return
	 * @return String
	 */
	public static String combineStr(String combineSymbol, Object... objs) {
		StringBuffer sb = new StringBuffer();
		for (Object obj : objs) {
			sb.append(objToStr(obj));
			sb.append(objToStr(combineSymbol));
		}
		return sb.substring(0, sb.length() - combineSymbol.length());
	}

	/**
	 * 文件拷贝
	 * 
	 * @param oldFilename
	 * @param newFilename
	 * @param bNotOverWrite
	 */
	@SuppressWarnings("resource")
	public synchronized static void copyFile(String oldFilename, String newFilename, boolean bNotOverWrite) {
		FileChannel ifc = null;
		FileChannel ofc = null;
		try {
			File fileNew = new File(newFilename);
			if ((bNotOverWrite && fileNew.exists())) {
				// 文件已存在、不覆盖模式的情况下，不处理
				return;
			}
			File file = new File(oldFilename);
			if (!file.exists()) {
				// 文件不存在
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ifc = fis.getChannel();
			FileOutputStream fos = new FileOutputStream(fileNew);
			ofc = fos.getChannel();
			// 数据传输
			ifc.transferTo(0, ifc.size(), ofc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ifc != null) {
				try {
					ifc.close();
				} catch (IOException e) {
				}
			}
			if (ofc != null) {
				try {
					ofc.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 去除头和尾的字符串
	 * 
	 * @param value 传入的字符串
	 * @param replaceFirst 去除第一个字符串
	 * @param subStringLast 去除的最后一个字符串
	 * @return
	 */
	public static String removeFirstAndLastString(String value, String replaceFirst, String subStringLast) {
		if (!Util.isEmpty(value)) {
			String newValue = value.substring(0, value.lastIndexOf(subStringLast));
			newValue = newValue.replaceFirst(replaceFirst, "");
			return newValue;
		} else {
			return null;
		}
	}

	// 检查文件是否存在
	public static boolean isNotValidFile(String value) {
		if (Util.isEmpty(value)) {
			return false;
		}
		File file = new File(value);
		if (!file.exists() || !file.isFile()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否匹配正则
	 * 
	 * @param str
	 * @param regStr
	 * @return
	 */
	public static boolean isMatch(String str, String regStr) {
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 获取两个日期的差 date1-date2 如果date1 小于date2 返回0 如果date1等于date2，返回天数1
	 * 
	 * @param date1
	 * @param date2
	 * @param timeUnit 可以是天、小时、分钟、秒、毫秒
	 * @return
	 * @return long
	 * @author LIUQI
	 * @date 2015年8月6日
	 * @version 1.0
	 */
	public static long getDateMinusVal(Date date1, Date date2, TimeUnit timeUnit) {
		double minusVal = 0;
		long result = 0L;
		if (date1.before(date2)) {
			return result;
		} else {
			minusVal = date1.getTime() - date2.getTime();
		}

		if (TimeUnit.DAYS.equals(timeUnit)) {
			result = (long) Math.ceil(minusVal / (24 * 60 * 60 * 1000));
		} else if (TimeUnit.HOURS.equals(timeUnit)) {
			result = (long) Math.ceil(minusVal / (60 * 60 * 1000));
		} else if (TimeUnit.MINUTES.equals(timeUnit)) {
			result = (long) Math.ceil(minusVal / (60 * 1000));
		} else if (TimeUnit.SECONDS.equals(timeUnit)) {
			result = (long) Math.ceil(minusVal / 1000);
		} else if (TimeUnit.MILLISECONDS.equals(timeUnit)) {
			result = (long) minusVal;
		}

		return result + 1;
	}

	private static final String LONG_MIN_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * 把时间转换为日期字符串
	 * 
	 * @param instant
	 * @return
	 */
	public static String toLongMinutes(Instant instant) {
		return DateTimeFormatter.ofPattern(LONG_MIN_FORMAT).withZone(ZoneId.systemDefault()).format(instant);
	}

	/**
	 * 文件大小计算
	 * 
	 * @param size 单位bytes
	 * @return KB计算的大小
	 */
	public static String fileSizeInKB(long size) {
		return String.format("%.2f", size / 1024.0);
	}

	/**
	 * 
	 * @author 作者 GXS
	 * @date 创建时间 2018年8月28日 下午2:33:22
	 * @Description 根据日期获取星期几
	 * @param @param str
	 * @param @return
	 * @return String
	 */
	public static String getWeek(String str) {
		// 1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(str2Date(str, "yyyy-MM-dd").getTime()));
		return cal.get(Calendar.DAY_OF_WEEK) + "";

	}

	/**
	 * 获取两个日期之间的所有日期（yyyy-MM-dd）
	 * 
	 * @Description
	 * @param begin
	 * @param end
	 * @return
	 * @author GXS
	 */
	public static List<Date> getBetweenDates(Date begin, Date end) {
		List<Date> result = new ArrayList<Date>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(begin);
		while (begin.getTime() <= end.getTime()) {
			result.add(tempStart.getTime());
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
			begin = tempStart.getTime();
		}
		return result;
	}

	/**
	 * 将 URL 编码
	 */
	public static String encodeURL(String str) {
		String target;
		try {
			target = URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将 URL 解码
	 */
	public static String decodeURL(String str) {
		String target;
		try {
			target = URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将字符串 Base64 编码
	 */
	public static String encodeBASE64(String str) {
		String target;
		try {
			target = Base64.encodeBase64URLSafeString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将字符串 Base64 解码
	 */
	public static String decodeBASE64(String str) {
		String target;
		try {
			target = new String(Base64.decodeBase64(str), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将字符串 MD5 加密
	 */
	public static String encryptMD5(String str) {
		return DigestUtils.md5Hex(str);
	}

	/**
	 * 将字符串 SHA 加密
	 */
	public static String encryptSHA(String str) {
		return DigestUtils.sha1Hex(str);
	}

	/**
	 * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
	 * @param str 待转换字符串
	 * @return 转换后字符串
	 * @throws UnsupportedEncodingException exception
	 */
	public static String emojiConvert1(String str) throws UnsupportedEncodingException {
		String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			try {
				matcher.appendReplacement(sb, "[[" + URLEncoder.encode(matcher.group(1), "UTF-8") + "]]");
			} catch (UnsupportedEncodingException e) {
				// LOG.error("emojiConvert error", e);
				throw e;
			}
		}
		matcher.appendTail(sb);
		// LOG.debug("emojiConvert " + str + " to " + sb.toString()
		// + ", len：" + sb.length());
		return sb.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(emojiRecovery2("[[%F0%9F%98%80]]"));
	}

	/**
	 * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
	 * @param str 转换后的字符串
	 * @return 转换前的字符串
	 * @throws UnsupportedEncodingException exception
	 */
	public static String emojiRecovery2(String str) throws UnsupportedEncodingException {
		if (Util.isEmpty(str)) {
			str = "";
		}
		String patternString = "\\[\\[(.*?)\\]\\]";

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			try {
				matcher.appendReplacement(sb, URLDecoder.decode(matcher.group(1), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// LOG.error("emojiRecovery error", e);
				throw e;
			}
		}
		matcher.appendTail(sb);
		// LOG.debug("emojiRecovery " + str + " to " + sb.toString());
		return sb.toString();
	}

	/**
	 * 将对象转换成json字符串。
	 * <p>
	 * Title: pojoToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data) {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json结果集转化为对象
	 * 
	 * @param jsonData json数据
	 * @param clazz 对象中的object类型
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json数据转换成pojo对象list
	 * <p>
	 * Title: jsonToList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
