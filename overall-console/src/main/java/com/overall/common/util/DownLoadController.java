package com.overall.common.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/common/download")
@Controller
public class DownLoadController {

	private static final String EMPLOYEE = "裁判信息导入模板";

	private static final String XLS = ".xls";

	/**
	 * 下载
	 * 
	 * @param response
	 * @param module
	 */
	@RequestMapping(value = "/{module}")
	public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String module) {

		String filename = "";
		String suffix = "";
		if (module.equals("person")) {
			filename = EMPLOYEE;
			suffix = XLS;
		}
		try {
			InputStream fis = this.getClass().getClassLoader().getResourceAsStream("static/excel/" + filename + suffix);
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			response.setContentType("bin");

			String fileNames = filename + suffix;
			String agent = request.getHeader("USER-AGENT");

			String codedfilename = "";
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
				String name = java.net.URLEncoder.encode(fileNames, "UTF8");
				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
				codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
			}
			response.addHeader("Content-Disposition", "attachment; filename=\"" + codedfilename + "\"");
			response.getOutputStream().write(buffer);
		} catch (IOException e) {
		}
	}
}
