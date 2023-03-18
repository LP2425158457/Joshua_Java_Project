package com.thread.chapter.one;

public class ThreadCreateMaxRun {
    public static final int MAX_TURN = 5;
    public static String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }

    static int threadNo = 1;
    static class DemoThread extends Thread{
        public DemoThread(){
            super("DemoThread-" + threadNo++);
        }

        @Override
        public void run() {
            super.run();
            // 每个线程运行MAX_TURN=5次
            for (int i = 0; i < MAX_TURN; i++) {
                System.out.println(getName() + ", 轮次：" + i);
            }
            System.out.println(getName() + "，运行结束。。。。");
        }
    }

    // 主线程运行
    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }
        // 看看是谁“最后”结束完成此线程，这个最后不是最后，而是第一
        System.out.println(getCurrentThreadName() + "运行结束");
    }

}
