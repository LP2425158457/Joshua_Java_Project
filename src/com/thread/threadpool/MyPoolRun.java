package com.thread.threadpool;

public class MyPoolRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "_________" + i);
        }
    }
}
