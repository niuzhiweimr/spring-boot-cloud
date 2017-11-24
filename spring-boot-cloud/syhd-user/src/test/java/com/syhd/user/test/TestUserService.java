package com.syhd.user.test;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.syhd.user.util.HttpUtil;

/**
 * 
 * @author niuzhiwei 单元测试案例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestUserService {

	@Test
	public void testGetUserById() {
		String url = "http://118.190.157.94/kjplus-api/testdata.html";
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("opentoken","FDe4tlpO1LRgKnh18q9tmWE8eDX8iXQw");
		String result = HttpUtil.doGet(url, params);
		System.out.println(result);
	}

}
