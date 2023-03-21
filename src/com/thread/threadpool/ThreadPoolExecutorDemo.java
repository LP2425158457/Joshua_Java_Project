package com.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        // ThreadPoolExecutor 类详解
        // 1、创建线程池（Executors来进行创建）
        //  newFixedThreadPool()
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        //  newSingleThreadExecutor()
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //  newCachedThreadPool()
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 2、构造参数
        //  corePoolSize:指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去；
        //  maximumPoolSize:指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量；
        //  keepAliveTime:当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁；
        //  unit:keepAliveTime的单位
        //  workQueue:任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种；
        //  threadFactory:线程工厂，用于创建线程，一般用默认即可；
        //  handler:拒绝策略；当任务太多来不及处理时，如何拒绝任务；
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, // 核心线程数量
                5,// 最大线程数
                100,// 空闲线程最大存活时间
                TimeUnit.SECONDS,// 时间单位
                new ArrayBlockingQueue(3),// 任务队列
                Executors.defaultThreadFactory(),// 创建线程工厂
                new ThreadPoolExecutor.DiscardPolicy()// 任务的拒绝策略
        );

        // 3、任务队列（workQueue）
        //  直接提交队列：SynchronousQueue：没有容量，没执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。
        BlockingQueue SynchronousQueue = new SynchronousQueue();
        //  有界任务队列：ArrayBlockingQueue：有界任务队列，若有新的任务需要执行时，线程池会创建新的线程，直到创建的线程数量达到corePoolSize时，则会将新的任务加入到等待队列中。若等待队列已满，即超过ArrayBlockingQueue初始化的容量，则继续创建线程，直到线程数量达到maximumPoolSize设置的最大线程数量，若大于maximumPoolSize，则执行拒绝策略。
        BlockingQueue ArrayBlockingQueue = new ArrayBlockingQueue(3);// 参数为队伍的数量
        //  无界任务队列：LinkedBlockingQueue：无界任务队列，线程池的任务队列可以无限制的添加新的任务，而线程池创建的最大线程数量就是你corePoolSize设置的数量，也就是说在这种情况下maximumPoolSize这个参数是无效的，哪怕你的任务队列中缓存了很多未执行的任务，当线程池的线程数达到corePoolSize后，就不会再增加了；若后续有新的任务加入，则直接进入队列等待
        BlockingQueue LinkedBlockingQueue = new LinkedBlockingQueue();
        //  优先任务队列；PriorityBlockingQueue：一个特殊的无界队列，它其中无论添加了多少个任务，线程池创建的线程数也不会超过corePoolSize的数量，只不过其他队列一般是按照先进先出的规则处理任务，而PriorityBlockingQueue队列可以自定义规则根据任务的优先级顺序先后执行。
        BlockingQueue PriorityBlockingQueue = new PriorityBlockingQueue();

        // 4、拒绝策略（handler）
        //  AbortPolicy 策略：该策略会直接抛出异常，阻止系统正常工作；
        RejectedExecutionHandler abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        //  CallerRunsPolicy 策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；
        RejectedExecutionHandler callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        //  DiscardOldestPolicy 策略：该策略会丢弃任务队列中最老的一个任务，也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；
        RejectedExecutionHandler discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        //  DiscardPolicy 策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
        RejectedExecutionHandler discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
    }
}
