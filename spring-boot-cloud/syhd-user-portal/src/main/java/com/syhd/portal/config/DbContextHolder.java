package com.syhd.portal.config;

import org.springframework.stereotype.Component;

@Component
public class DbContextHolder {

	/**
	 * 枚举类型 MASTER 主数据库 SLAVE 从数据库
	 */
	public enum DbType {
		MASTER, SLAVE
	}

	private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

	/**
	 * 
	 * @param dbType
	 *            传入需要读取数据库类型
	 */
	public static void setDbType(DbType dbType) {
		if (dbType == null)
			throw new NullPointerException();
		contextHolder.set(dbType);
	}

	/**
	 * 
	 * @return 默认主库
	 */
	public static DbType getDbType() {
		return contextHolder.get() != null ? contextHolder.get() : DbType.MASTER;
	}

	/**
	 * 清除
	 */
	public static void clearDbType() {
		contextHolder.remove();
	}
}
