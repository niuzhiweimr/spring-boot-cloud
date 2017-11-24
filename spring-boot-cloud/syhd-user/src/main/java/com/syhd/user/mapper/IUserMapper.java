package com.syhd.user.mapper;

import org.apache.ibatis.annotations.Param;
import com.syhd.user.exception.DataException;
import com.syhd.user.model.UserEbo;

public interface IUserMapper {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            传入userEbo对象
	 * @throws DataException
	 */
	public void addUser(UserEbo user) throws DataException;

	/**
	 * 
	 * @param uid
	 *            t_user表用戶id
	 * @return
	 * @throws DataException
	 */
	public UserEbo getUserById(@Param("uid") Integer uid) throws DataException;
}
