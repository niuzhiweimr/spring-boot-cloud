package com.syhd.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author niuzhiwei 数据源配置
 */
@Configuration
// 注解@EnableTransactionManagement通知Spring，@Transactional注解的类被事务的切面包围。这样@Transactional就可以使用了。
@EnableTransactionManagement
public class DataSourceConfiguration {

	@Value("${druid.type}")
	private Class<? extends DataSource> dataSourceType;

	@Bean(name = "masterDataSource")
	@Primary
	// @ConfigurationProperties的大致作用就是通过它可以把properties或者yml配置直接转成对象
	@ConfigurationProperties(prefix = "druid.master")
	public DataSource masterDataSource() {

		return DataSourceBuilder.create().type(dataSourceType).build();
	}

	@Bean(name = "slaveDataSource")
	// @ConfigurationProperties的大致作用就是通过它可以把properties或者yml配置直接转成对象
	@ConfigurationProperties(prefix = "druid.slave")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().type(dataSourceType).build();
	}
}
