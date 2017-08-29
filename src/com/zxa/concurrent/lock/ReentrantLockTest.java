package com.zxa.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 张新安 on 2017/8/29.
 * 可重入锁，（公平锁和非公平锁）
 */

public class ReentrantLockTest {
    
    
    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.fair();
        test.unfair();
    }
    
    
    //公平锁
    private static Lock fairLock = new ReentrantLock(true);
    //非公平锁
    private static Lock unfairLock = new ReentrantLock();
    
    public void fair(){
        System.out.println("公平锁");
        for(int i = 0 ; i < 5; i++){
            Thread thread = new Thread(new Job(fairLock));
            thread.setName(""+i);
            thread.start();
        }
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void unfair(){
        System.out.println("非公平锁");
        for(int i = 0 ; i < 5; i++){
            Thread thread = new Thread(new Job(unfairLock));
            thread.setName(""+i);
            thread.start();
        }
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    private static class Job implements Runnable{
        
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }
        
        @Override
        public void run() {
            for(int i = 0; i < 5; i++){
                lock.lock();
                try{
                    System.out.println("lock by"+
                    Thread.currentThread().getName());
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    
}
