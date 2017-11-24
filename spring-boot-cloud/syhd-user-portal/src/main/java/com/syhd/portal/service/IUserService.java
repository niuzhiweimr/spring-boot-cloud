package com.syhd.portal.service;

import com.syhd.portal.eto.UserEto;
import com.syhd.portal.exception.DataException;
import com.syhd.portal.model.UserEbo;

public interface IUserService {

	// 通过uid获取用户
	public UserEbo getUserById(Integer uid) throws DataException;

	// 用户注册
	public UserEbo regUser(UserEto user) throws DataException;
}
