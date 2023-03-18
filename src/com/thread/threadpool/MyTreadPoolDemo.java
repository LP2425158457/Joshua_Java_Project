package com.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTreadPoolDemo {
    public static void main(String[] args) {
        /*
        Excutors：线程池的工具类通过调用方法返回不同类型的线程池对象
        1、Executors.newCachedThreadPool() 获取一个没有上限的线程池，上限是int的最大值
        2、Executors.newFixedThreadPool(int max) 获取一个有上限的线程池，上限是max的值
        注意：线程池需要手动销毁，不会自动销毁
         */
        ExecutorService cachedThreadPool =  Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool =  Executors.newFixedThreadPool(1);

        // 提交任务到线程
        fixedThreadPool.submit(new MyPoolRun());
        fixedThreadPool.submit(new MyPoolRun());
        fixedThreadPool.submit(new MyPoolRun());
        fixedThreadPool.submit(new MyPoolRun());
        fixedThreadPool.submit(new MyPoolRun());

        // 线程池不会自动销毁，需要手动销毁，销毁线程池
        cachedThreadPool.shutdown();
        fixedThreadPool.shutdown();
    }
}
