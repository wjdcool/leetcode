package com.overall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 
 * @author 作者 wjd
 * @date 创建时间 2017年11月24日 下午4:30:06
 * @description springboot启动类
 */
@SpringBootApplication
// 扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.overall.mapper")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages = { "com.overall" })
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
// 启动缓存
@EnableCaching
public class OverallApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverallApplication.class, args);
	}

}
