package com.zxa.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SimpleDaemons
 * @Description: 后台线程
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 11:14
 */
public class SimpleDaemons implements Runnable {
	@Override
	public void run() {
		int i= 0;
		try {
			while ( i < 1000) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		for(int i = 0; i < 10; i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}

		System.out.println("All daemos started");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
