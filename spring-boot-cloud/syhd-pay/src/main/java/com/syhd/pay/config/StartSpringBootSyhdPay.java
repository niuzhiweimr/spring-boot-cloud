package com.syhd.pay.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author niuzhiwei
 *		支付微服务
 */
@EnableDiscoveryClient //服务注册发现
@SpringBootApplication
// 在不同包的情況下springboot必须要配置扫描
@ComponentScan(basePackages = { "com.syhd.pay.*"})
// 扫描mapper映射器
@MapperScan("com.syhd.pay.mapper")
public class StartSpringBootSyhdPay {
	
	// 线程可见
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootSyhdPay.class, args);
	}

}
