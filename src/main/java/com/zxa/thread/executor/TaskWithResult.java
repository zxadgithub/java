package com.zxa.thread.executor;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @ClassName: TaskWithResult
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/10 10:40
 */
public class TaskWithResult implements Callable<String> {
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult :" + id;
	}
}


class CallableDemo{
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		for(Future<String> f : results){
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally {
				executorService.shutdown();
			}
		}
	}
}
