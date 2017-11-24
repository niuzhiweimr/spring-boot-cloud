package com.syhd.portal.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.syhd.portal.annotation.MasterConnection;
import com.syhd.portal.cache.CacheKeyGenerator;
import com.syhd.portal.cache.ICurrencyCacheManager;
import com.syhd.portal.eto.UserEto;
import com.syhd.portal.exception.CacheException;
import com.syhd.portal.exception.DataException;
import com.syhd.portal.mapper.IUserMapper;
import com.syhd.portal.model.UserEbo;
import com.syhd.portal.service.IUserService;
import com.syhd.portal.util.DataValUtil;

@Service("userService")
public class UserService implements IUserService {

	private Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private IUserMapper userMapper;
	@Autowired
	private ICurrencyCacheManager currencyCacheManager;

	private static final String USER_CACHE = "userCache";

	// value设置缓存时间 keyGenerator自定义生产key的类 需要加入扫描
	@Cacheable(value = "10s", keyGenerator = "cacheKeyGenerator")
	@MasterConnection
	public UserEbo getUserById(Integer uid) throws DataException {
		logger.info("产生的key：" + CacheKeyGenerator.getKey().toString());
		if (uid <= 0)
			return null;
		UserEbo user = null;
		try {
			user = (UserEbo) currencyCacheManager.getFromCache(USER_CACHE, CacheKeyGenerator.getKey());
			if (user != null) {
				logger.info("从缓存中获取了");
				return user;
			} else {
				logger.info("从数据库中获取了");
				user = userMapper.getUserById(uid);
				if (user != null)
					currencyCacheManager.putCache(USER_CACHE, CacheKeyGenerator.getKey(), user);
				else
					return null;
				return user;
			}
		} catch (CacheException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public UserEbo regUser(UserEto user) throws DataException {
		
		DataValUtil.dataValidation(user.getClass(), user);
		UserEbo user1 = new UserEbo();
		//对象浅拷贝
		BeanUtils.copyProperties(user, user1);
		user1.setUid(user1.getUid());
		userMapper.addUser(user1);
		
		return null;
	}

}
