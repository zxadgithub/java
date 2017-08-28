package com.zxa.current.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 张新安 on 2017/8/28.
 * 实用阻塞队列实现生产者消费者问题
 */
public class BlockingQueueExample {
    
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        consumer.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

/*
*生产者对象
 */
class Producer implements Runnable{
    private BlockingQueue queue = null;
    public Producer(BlockingQueue queue){
        this.queue = queue;
    }
    
    @Override
    public void run() {
        int i = 0;
        while (true)
        try {
            queue.put(++i+"");
            System.out.println("生产"+i);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





/*
*消费者对象
 */

class Consumer extends  Thread{
    private BlockingQueue queue = null;
    
    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    
    @Override
    public void run() {
       while (true)
        try{
            System.out.println("消费"+queue.take());
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
