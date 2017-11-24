package com.syhd.portal.action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syhd.portal.exception.DataException;
import com.syhd.portal.service.IUserService;

@RestController
public class userAction {

	@Autowired
	private IUserService userService;

	private Logger logger = Logger.getLogger(userAction.class);

	// 通过用户id获取userEbo对象
	@RequestMapping("/userportal")
	public @ResponseBody
	Map<String, Object> getUserNameByuid(Integer uid, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		try {
			/*Integer uid = Util.parseNumVl(request.getParameter("uid"), 0);*/
			
			map.put("data", userService.getUserById(uid));
			map.put("message", "获取用户成功<user-portal>");
			map.put("status", 100);
			return map;
		} catch (DataException e) {
			logger.error(e.getMessage());
			map.put("status", 500);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
