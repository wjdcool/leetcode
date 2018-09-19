package com.overall.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.overall.OverallApplicationRunner;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import com.overall.common.data.GetEhcacheUserOutData;

/**
 * 
 * @author 作者 GXS
 * @date 创建时间 2018年3月21日 下午5:32:04
 * @description 控制层基类
 */
public class BaseController {

	@Autowired
	private OverallApplicationRunner overallApplicationRunner;

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	/**
	 * 取出session
	 * 
	 * @return
	 */
	public GetEhcacheUserOutData getUserData(String token) {
		GetEhcacheUserOutData data = (GetEhcacheUserOutData) CacheUtils.get(token);
		if (Util.isEmpty(data)) {
			data = new GetEhcacheUserOutData();
			data.setLoginName("王振尧测试");
			data.setId(1l);
		}
		return data;
	}

	public String getMessage(String type) {
		return overallApplicationRunner.cacheMap.get(type);
	}

	/**
	 * 导出Excel
	 * 
	 * @param response
	 * @param list
	 * @param header
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void exportExcel(HttpServletResponse response, List<?> list, String[] header, ExportExcelInterface export) throws Exception {
		Date dt = new Date();
		String fileName = new Long(dt.getTime()).toString();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
		OutputStream out = response.getOutputStream();
		try {
			export.exportExcel(header, list, out, "yyyy-MM-dd");
			out.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			out.close();
		}
	}

	/**
	 * 导入
	 * 
	 * @param uploadExcel
	 * @param t
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 */
	public <T> List<T> importExcel(MultipartFile uploadExcel, Class<T> t) throws IOException, IllegalAccessException, IllegalArgumentException,
	        InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		List<T> list = this.importExcel(uploadExcel, 0, t);
		return list;
	}

	/**
	 * 导入资源
	 * 
	 * @param uploadExcel
	 * @param no
	 * @param t
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("resource")
	public <T> List<T> importExcel(MultipartFile uploadExcel, int no, Class<T> t) throws IOException, IllegalAccessException,
	        IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		Workbook workbook = null;
		String fileName = uploadExcel.getOriginalFilename();
		String fileEnd = fileName.substring(fileName.indexOf(".") + 1);
		Sheet sheet = null;
		// 兼容 2007及2003版本
		if ("xls".equals(fileEnd)) {
			workbook = new HSSFWorkbook(uploadExcel.getInputStream());
			sheet = (HSSFSheet) workbook.getSheetAt(no);
		} else {
			workbook = new XSSFWorkbook(uploadExcel.getInputStream());
			sheet = (XSSFSheet) workbook.getSheetAt(no);
		}
		List<T> list = new ArrayList<T>();
		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			T instance = t.newInstance();
			Field[] fields = instance.getClass().getDeclaredFields();
			for (int k = 0; k < fields.length; k++) {
				Method setMethod = instance.getClass().getMethod("set" + StringUtils.capitalize(fields[k].getName()), String.class);
				Cell cell = row.getCell(k);
				if (cell == null) {
					setMethod.invoke(instance, "");
				} else if (cell.getCellType() == 0) {
					String strCell = "";
					// 判断是否是日期
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						SimpleDateFormat sdf = null;
						if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
							sdf = new SimpleDateFormat("HH:mm");
						} else {// 日期
							sdf = new SimpleDateFormat("yyyy-MM-dd");
						}
						Date date = cell.getDateCellValue();
						strCell = sdf.format(date);
					} else {
						DecimalFormat df = new DecimalFormat("0");
						strCell = df.format(cell.getNumericCellValue());
					}
					setMethod.invoke(instance, strCell);
				} else if (cell.getCellType() == 1) {
					setMethod.invoke(instance, cell.getStringCellValue());
				}
			}
			list.add(instance);
		}
		return list;
	}

}
