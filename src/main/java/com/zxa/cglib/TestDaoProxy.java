package com.zxa.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: TestDaoProxy
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 20:11
 */
public class TestDaoProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("Before Methd Invoke");
		methodProxy.invokeSuper(o,objects);
		System.out.println("After Method Invoke");
		return o;
	}
}
