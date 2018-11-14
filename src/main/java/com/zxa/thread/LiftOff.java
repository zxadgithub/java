package com.zxa.thread;

/**
 * @ClassName: ListOff
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 8:06
 */
public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status() + "\t");
			Thread.yield();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("");
	}
}

class BasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			startLiftOff();
		System.out.println("Waiting fot LiftOff");
	}

	private static void startLiftOff() {
		Thread thread = new Thread(new LiftOff());
		thread.start();
	}
}

