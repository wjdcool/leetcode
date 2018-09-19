package com.overall.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.overall.common.data.GetEhcacheUserOutData;
import com.overall.common.enums.ParameterCode;
import com.overall.common.exception.ServiceException;
import com.overall.common.util.CacheUtils;
import com.overall.common.util.Jwt;
import com.overall.common.util.Util;

/**
 *
 * 
 * @author 作者 GXS
 * @date 创建时间 2017年11月21日 下午2:15:25
 * @description 权限拦截
 */
public class SecurityInterceptor implements HandlerInterceptor {

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String token = request.getHeader(ParameterCode.LOGIN_TOKEN.getCode());
		GetEhcacheUserOutData outData = Jwt.unsign(token, GetEhcacheUserOutData.class);
//		if (Util.isEmpty(outData)) {
//			CacheUtils.remove(token);
//			throw new ServiceException(ParameterCode.ERROR_TOKEN_STATUS.getCode());
//		}
//		GetEhcacheUserOutData data = (GetEhcacheUserOutData) CacheUtils.get(token);
//		if (!data.getResourceList().contains(request.getRequestURI())) {
//			throw new ServiceException(ParameterCode.ERROR_RESOURCE_STATUS.getCode());
//		}
		return true;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
	}
}
