package com.syhd.pay.config;

import groovy.util.logging.Slf4j;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
@AutoConfigureAfter({ DataSourceConfiguration.class })
@Slf4j
public class MybatisConfiguration extends MybatisAutoConfiguration {

	private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

	@Resource(name = "masterDataSource")
	private DataSource masterDataSource;

	@Resource(name = "slaveDataSource")
	private DataSource slaveDataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactorys() throws Exception {
		logger.info("-------------------- 重载父类 sqlSessionFactory init ---------------------");
		return super.sqlSessionFactory(roundRobinDataSouceProxy());
	}

	@Bean
	public AbstractRoutingDataSource roundRobinDataSouceProxy() {
		MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		DataSource writeDataSource = masterDataSource;
		// 写
		targetDataSources.put(DbContextHolder.DbType.MASTER.toString(), masterDataSource);
		// 读
		targetDataSources.put(DbContextHolder.DbType.SLAVE.toString(), slaveDataSource);
		// 设置默认数据源
		proxy.setDefaultTargetDataSource(writeDataSource);
		proxy.setTargetDataSources(targetDataSources);
		return proxy;
	}
}
