package com.thread.chapter.one;

public class ThreadMethod {
    public static void main(String[] args) {
        // Thread详解：获取当前CPU执行的线程
        Thread thread = Thread.currentThread();
        System.out.println("****Thread.id：" + thread.getId());
        System.out.println("****Thread.名称：" + thread.getName());
        System.out.println("****Thread.优先级：" + thread.getPriority());
        System.out.println("****Thread.是否守护线程：" + thread.isDaemon());
        System.out.println("****Thread.运行状态：" + thread.getState());
        System.out.println("****Thread.运行状态：" + thread.getState());

        // 创建一个新线程
        Thread newThread = new Thread("新线程");
        System.out.println("****newThread.id：" + newThread.getId());
        System.out.println("****newThread.名称：" + newThread.getName());
        System.out.println("****newThread.优先级：" + newThread.getPriority());
        System.out.println("****newThread.是否守护线程：" + newThread.isDaemon());
        System.out.println("****newThread.运行状态：" + newThread.getState());
//        newThread.run(); // run方法并不能激活线程，需要start方法激活
        newThread.start();
        System.out.println("****newThread.运行状态：" + newThread.getState());
//        newThread.stop(); // stop 方法也不能停止线程
        System.out.println("****newThread.运行状态：" + newThread.getState());

    }
}
