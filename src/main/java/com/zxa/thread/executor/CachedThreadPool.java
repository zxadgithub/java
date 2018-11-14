package com.zxa.thread.executor;

import com.zxa.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CachedThreadPool
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 8:49
 */
public class CachedThreadPool{
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		ExecutorService executorService1 = Executors.newFixedThreadPool(5);
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; i++){
			executorService2.execute(new LiftOff());
		}
		executorService2.shutdown();
	}
}
