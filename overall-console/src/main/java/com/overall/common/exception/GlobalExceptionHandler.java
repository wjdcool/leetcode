package com.overall.common.exception;

import com.overall.OverallApplicationRunner;
import com.overall.common.data.JsonResult;
import com.overall.common.enums.MessageParameter;
import com.overall.common.enums.ParameterCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author 作者 GXS
 * @date 创建时间 2018年3月21日 下午5:53:37
 * @description 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private OverallApplicationRunner overallApplicationRunner;

	@ExceptionHandler(value = ErrorException.class)
	@ResponseBody
	public JsonResult handlerError(HttpServletRequest request, Exception e) throws Exception {
//		OveException loggerException = new OveException();
//		loggerException.setCreateUser("admin");
//		loggerException.setCreateTime(new Date());
//		loggerException.setExceptionContent("异常信息：" + e.getCause());
//		loggerException.setExceptionUrl(request.getRequestURI());
//		OveExceptionMapper loggerExceptionMapper = SpringUtil.getBean(OveExceptionMapper.class);
//		loggerExceptionMapper.insert(loggerException);
		return JsonResult.error();
	}

	@ExceptionHandler(value = MessageException.class)
	@ResponseBody
	public JsonResult handlerMessage(Exception e) throws Exception {
		return JsonResult.fail(e.getMessage());
	}

	@ExceptionHandler(value = ServiceException.class)
	@ResponseBody
	public JsonResult handlerService(Exception e) throws Exception {
		if (e.getMessage().equals(ParameterCode.ERROR_TOKEN_STATUS.getCode())) {
			return JsonResult.lose(overallApplicationRunner.cacheMap.get(MessageParameter.LOGIN_STATUS_ERROR));
		}
		if (e.getMessage().equals(ParameterCode.ERROR_RESOURCE_STATUS.getCode())) {
			return JsonResult.lose(overallApplicationRunner.cacheMap.get(MessageParameter.RESOURCE_ERROR));
		}
		return null;
	}

}
