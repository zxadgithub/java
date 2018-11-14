package com.zxa.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 张新安 on 2017/8/28.
 * 实用阻塞队列实现生产者消费者问题
 */


public class BlockingQueueExample {
    
    public static void main(String[] args) {

        /*
        *BlockingQueue 是个接口，你需要使用它的实现之一来使用 BlockingQueue。java.util.concurrent
        *具有以下 BlockingQueue 接口的实现(Java 6)：
        * ArrayBlockingQueue数组实现初始化大小后不可更改，先进先出
        * DelayQueue在每个元素的 getDelay() 方法返回的值的时间段之后才释放掉该元素。
        *       如果返回的是 0 或者负值，延迟将被认为过期，该元素将会在 DelayQueue 的下一次 take  被调用的时候被释放掉。
        * LinkedBlockingQueue链式实现，先进先出
        * PriorityBlockingQueue优先级的阻塞队列类似PriorityQueue
        * SynchronousQueue单个元素。
        * BlockingDeque阻塞双端队列，双向插入，移除putLast(o),putFirst(o),takeFirst(o),takeLast(o)
         */
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
       while (true) {
           try {
               System.out.println("消费" + queue.take());
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
