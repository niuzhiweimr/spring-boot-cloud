package com.syhd.user.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.syhd.user.cache.CacheKeyGenerator;
import com.syhd.user.cache.ICurrencyCacheManager;
import com.syhd.user.eto.UserEto;
import com.syhd.user.exception.DataException;
import com.syhd.user.mapper.IUserMapper;
import com.syhd.user.model.UserEbo;
import com.syhd.user.service.IUserService;
import com.syhd.user.util.DataValUtil;

@Service("userService")
public class UserService implements IUserService {

	private Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private IUserMapper userMapper;
	@Autowired
	private ICurrencyCacheManager currencyCacheManager;

	// value设置缓存时间 keyGenerator自定义生产key的类 需要加入扫描
	// @Cacheable(value = "10s", keyGenerator = "cacheKeyGenerator")
	public UserEbo getUserById(Integer uid) throws DataException {
		logger.info("产生的key：" + CacheKeyGenerator.getKey().toString());
		if (uid <= 0)
			return null;
		UserEbo user = null;
		try {
			logger.info("从数据库中获取了");
			user = userMapper.getUserById(uid);
			return user;
		} catch (DataException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public UserEbo regUser(UserEto user) throws DataException {

		DataValUtil.dataValidation(user.getClass(), user);
		UserEbo user1 = new UserEbo();
		// 对象浅拷贝
		BeanUtils.copyProperties(user, user1);
		user1.setUid(user1.getUid());
		userMapper.addUser(user1);

		return null;
	}

}
