package com.thread.threadpool;

import java.util.concurrent.*;

public class MyTreadPoolDemo {
    public static void main(String[] args) {
        /*
        Excutors：线程池的工具类通过调用方法返回不同类型的线程池对象
        1、Executors.newCachedThreadPool() 获取一个没有上限的线程池，上限是int的最大值
        2、Executors.newFixedThreadPool(int max) 获取一个有上限的线程池，上限是max的值
        注意：线程池需要手动销毁，不会自动销毁
         */
//        ExecutorService cachedThreadPool =  Executors.newCachedThreadPool();
//        ExecutorService fixedThreadPool =  Executors.newFixedThreadPool(1);
//
//        // 提交任务到线程
//        fixedThreadPool.submit(new MyPoolRun());
//        fixedThreadPool.submit(new MyPoolRun());
//        fixedThreadPool.submit(new MyPoolRun());
//        fixedThreadPool.submit(new MyPoolRun());
//        fixedThreadPool.submit(new MyPoolRun());
//
//        // 线程池不会自动销毁，需要手动销毁，销毁线程池
//        cachedThreadPool.shutdown();
//        fixedThreadPool.shutdown();

        /*
        自定义线程池
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
            (核心线程数、最大线程数量、空闲线程最大存活时间、任务队列、创建线程工厂、任务的拒绝策略)

            核心线程数：不能小于0
            最大线程数量：不能小于0，最大数量>=核心线程数量
            空闲线程最大存活时间：不能小于0
            时间单位：用TimeUnit指定
            任务队列：不能为null
            创建线程工厂：不能为null
            任务的拒绝策略：不能为null
         */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, // 核心线程数量
                5,// 最大线程数
                100,// 空闲线程最大存活时间
                TimeUnit.SECONDS,// 时间单位
                new ArrayBlockingQueue(3),// 任务队列
                Executors.defaultThreadFactory(),// 创建线程工厂
                new ThreadPoolExecutor.DiscardPolicy()// 任务的拒绝策略
        );
        // 提交任务到线程池
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        threadPoolExecutor.submit(new MyPoolRun());
        // 销毁
        threadPoolExecutor.shutdown();

    }
}
