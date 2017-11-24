package com.syhd.pay.service;

import com.syhd.pay.eto.UserEto;
import com.syhd.pay.exception.DataException;
import com.syhd.pay.model.UserEbo;

public interface IUserService {

	// 通过uid获取用户
	public UserEbo getUserById(Integer uid) throws DataException;

	// 用户注册
	public UserEbo regUser(UserEto user) throws DataException;
}
