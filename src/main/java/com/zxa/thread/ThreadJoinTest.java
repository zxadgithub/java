package com.zxa.thread;

/**
 * @ClassName: ThreadJoinTest
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/14 10:48
 */
public class ThreadJoinTest {
	public static void main(String[] args) {
		Thread thread1 = new ThreadA("Thread A");
		Thread thread2 = new ThreadA("Thread B");
		thread1.start();
		thread2.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End!");
	}
}

class ThreadA extends Thread{

	ThreadA(String name){
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName()+"開始运行");

		System.out.println(this.getName() + "线程结束");
	}
}


class ThreadB extends Thread{

	private Object object;

	ThreadB(String name, Object o){
		super(name);
		this.object = o;
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " start");
		synchronized (object){
			System.out.println("get lock :" + object);
		}
		System.out.println(this.getName() + " End !");
	}
}

class Test{
	public static void main(String[] args) {

		Object object = new Object();
		ThreadB threadB = new ThreadB("B", object);

		synchronized (object){
			System.out.println(Thread.currentThread().getName() + "运行");
			threadB.start();
			System.out.println("jieshu");
		}




	}
}
