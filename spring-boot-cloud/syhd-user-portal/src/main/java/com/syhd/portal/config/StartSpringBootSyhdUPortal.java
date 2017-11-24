package com.syhd.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author niuzhiwei
 *		用户管理服务
 */
@EnableDiscoveryClient //服务注册发现
@SpringBootApplication
// 在不同包的情況下springboot必须要配置扫描
@ComponentScan(basePackages = { "com.syhd.portal.*" })
// 扫描mapper映射器
@MapperScan("com.syhd.portal.mapper")
public class StartSpringBootSyhdUPortal {
	
	// 线程可见
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootSyhdUPortal.class, args);
	}

}
