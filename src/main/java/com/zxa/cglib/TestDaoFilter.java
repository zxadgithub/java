package com.zxa.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @ClassName: TestDaoFilter
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 20:21
 */
public class TestDaoFilter implements CallbackFilter {
	@Override
	public int accept(Method method) {

		if ("select".equals(method.getName())){
			return 0;
		}
		return 1;

	}
}
