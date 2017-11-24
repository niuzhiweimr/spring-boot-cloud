package com.syhd.user.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//测试视图
@Controller
public class TestView {

	@RequestMapping("/userview.html")
	public ModelAndView menuList(HttpServletRequest request, HttpServletResponse response) {
	
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = mav.getModel();
		map.put("code", 200);
		mav.setViewName("index");
		return mav;
	}

}
