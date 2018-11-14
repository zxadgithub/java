package com.zxa.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.Instant;

/**
 * @ClassName: TestDaoAnotherProxy
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 20:17
 */
public class TestDaoAnotherProxy implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("StartTime=[" + Instant.now() + "]");
		methodProxy.invokeSuper(o,objects);
		System.out.println("EndTime=[" + Instant.now() + "]");
		return o;
	}
}
