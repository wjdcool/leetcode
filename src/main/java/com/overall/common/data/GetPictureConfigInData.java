package com.overall.common.data;

import lombok.Data;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("pict")
@ToString
public class GetPictureConfigInData {

	// 图片存储根目录

	private String basePath;

	// 图片访问根目录
	private String serverBasePath;

	// 上传目录
	private String uploadPath;

}
