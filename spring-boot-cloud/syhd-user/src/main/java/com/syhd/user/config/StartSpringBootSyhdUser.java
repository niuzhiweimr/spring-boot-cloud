package com.syhd.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author niuzhiwei 用户服务
 */
@EnableDiscoveryClient
// 服务注册发现
@SpringBootApplication
// 在不同包的情況下springboot必须要配置扫描
@ComponentScan(basePackages = { "com.syhd.user.*" })
// 扫描mapper映射器
@MapperScan("com.syhd.user.mapper")
public class StartSpringBootSyhdUser {

	// 线程可见
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootSyhdUser.class, args);
	}

}
