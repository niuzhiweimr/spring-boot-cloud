package com.syhd.pay.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.syhd.pay.annotation.SlaveConnection;
import com.syhd.pay.annotation.MasterConnection;
import com.syhd.pay.config.DbContextHolder;

@Component
@Aspect
public class DataSourceAspect {

	public static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

	@Before("execution(* com.*.*.service.*.*(..))")
	public void setReadDataSourceType(JoinPoint joinPoint) {
		// 获取云行类的对象
		Class<?> Class = joinPoint.getTarget().getClass();
		// 获取运行类对象的方法数组
		Method[] methods = Class.getMethods();
		// 获取运行时方法名称
		String methodName = joinPoint.getSignature().getName();
		for (Method method : methods) {
			//找到运行时类的方法
			if (method.getName().endsWith(methodName)) {
				//获取方法的注解
				MasterConnection writeOnly = method.getAnnotation(MasterConnection.class);
				SlaveConnection readOnly = method.getAnnotation(SlaveConnection.class);
				if (readOnly != null) {//是否有此注解
					// 切换从库
					DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
					logger.info("dataSource切换到：slave");
					break;//找到后直接跳出
				}
				if (writeOnly != null) {
					DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
					logger.info("dataSource切换到： ");
					break;
				}
			}
		}
	}
}
