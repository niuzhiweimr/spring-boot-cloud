package com.syhd.register.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author niuzhiwei
 *      服务注册中心
 */
@EnableEurekaServer
@SpringCloudApplication
public class RegisterCenter {

	public static void main(String[] args) {
		SpringApplication.run(RegisterCenter.class, args);
	}
}
