

## java.util.concurrent.ConcurrentMap
   java.util.concurrent.ConcurrentMap 接口表示了一个能够对别人的访问(插入和提取)进行并发处理的 java.util.Map。 
    ConcurrentMap 除了从其父接口 java.util.Map 继承来的方法之外还有一些额外的原子性方法。
       ConcurrentMap 的实现
        既然 ConcurrentMap 是个接口，你想要使用它的话就得使用它的实现类之一。java.util.concurrent 包具备 ConcurrentMap 接口的以下实现类：
        **ConcurrentHashMap**
        ConcurrentHashMap 和 java.util.HashTable 类很相似，但 ConcurrentHashMap 能够提供比 HashTable 更好的并发性能。在你从中读取对象的时候 ConcurrentHashMap 并不会把整个 Map 锁住。此外，在你向其中写入对象的时候，ConcurrentHashMap 也不会锁住整个 Map。它的内部只是把 Map 中正在被写入的部分进行锁定。
        另外一个不同点是，在被遍历的时候，即使是 ConcurrentHashMap 被改动，它也不会抛 ConcurrentModificationException。尽管 Iterator 的设计不是为多个线程的同时使用。
        ConcurrentMap 例子
```
           ConcurrentMap concurrentMap = new ConcurrentHashMap();
           concurrentMap.put("key", "value");  
           Object value = concurrentMap.get("key");  
```