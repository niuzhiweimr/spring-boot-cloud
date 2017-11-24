package com.syhd.portal.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String typeKey = DbContextHolder.getDbType().toString();
		if (typeKey.equals(DbContextHolder.DbType.MASTER.toString()))
			return DbContextHolder.DbType.MASTER.toString();
		else if (typeKey.equals(DbContextHolder.DbType.SLAVE.toString()))
			return DbContextHolder.DbType.SLAVE.toString();
		// 不存在 注解 默认 主库
		return DbContextHolder.DbType.MASTER.toString();
	}
}
