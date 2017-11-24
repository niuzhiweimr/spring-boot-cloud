package com.syhd.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author niuzhiwei
 *	    api网关代理
 */
@EnableDiscoveryClient //服务注册发现
@EnableZuulProxy    //api网关代理
@SpringCloudApplication
public class ServerCenter {

	public static void main(String[] args) {
		SpringApplication.run(ServerCenter.class, args);
	}

}
