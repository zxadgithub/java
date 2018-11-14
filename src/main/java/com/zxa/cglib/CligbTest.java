package com.zxa.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.util.ArrayList;

/**
 * @ClassName: CligbTes
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 20:13
 */
public class CligbTest {
	public static void main(String[] args) {
		TestDaoProxy testDaoProxy = new TestDaoProxy();
		TestDaoAnotherProxy testDaoAnotherProxy = new TestDaoAnotherProxy();


		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestDao.class);
//		enhancer.setCallback(testDaoProxy);

		//CallbackFilter的accept方法返回的数值表示的是顺序，顺序和setCallbacks里面Proxy的顺序是一致的。
		enhancer.setCallbacks(new Callback[]{testDaoProxy,testDaoAnotherProxy,NoOp.INSTANCE});
		enhancer.setCallbackFilter(new TestDaoFilter());
		enhancer.setInterceptDuringConstruction(false);//不拦截构造函数


		TestDao testDao = (TestDao)enhancer.create();
		testDao.update();
		testDao.select();
	}
}



