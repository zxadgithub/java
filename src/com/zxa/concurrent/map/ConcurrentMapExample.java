package com.zxa.concurrent.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 张新安 on 2017/8/28.
 * 并发Map
 * 通过对写数据部分加锁实现并发同步
 *
 */
public class ConcurrentMapExample {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        map.put("1","皮囊");
        System.out.println(map.get("1"));
    }
}
