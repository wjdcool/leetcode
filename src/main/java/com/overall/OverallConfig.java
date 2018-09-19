package com.overall;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.overall.common.data.GetPictureConfigInData;
import com.overall.common.interceptor.SecurityInterceptor;

@Configuration
public class OverallConfig extends WebMvcConfigurationSupport {
	@Autowired
	private GetPictureConfigInData pictureConfig;

	/**
	 * 图片映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 配置图片存储路径和图片访问路径的映射
		registry.addResourceHandler(pictureConfig.getServerBasePath() + "/**").addResourceLocations("file:" + pictureConfig.getBasePath() + "/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 跨域配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
		super.addCorsMappings(registry);
	}

	/**
	 * 拦截器配置
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    List<String> url = new ArrayList<String>();
	    url.add("/get/common/**");
	    url.add("/get/system/**");
		registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/**").excludePathPatterns(url);
		super.addInterceptors(registry);
	}

	/**
	 * 消息内容转换配置 配置fastJson返回json转换
	 * 
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 调用父类的配置
		super.configureMessageConverters(converters);
		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue,
		        SerializerFeature.WriteNullStringAsEmpty);
		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 将fastjson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}

}
