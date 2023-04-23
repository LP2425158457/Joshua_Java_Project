package com.thread.test.test05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test05 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> testList = new ArrayList<>();
        // 把数组的值传递给集合list
        Collections.addAll(testList, 10,5,20,100,30,45,60,72);

        // 创建多线程要运行的参数对象
        MyCallable myCallable = new MyCallable(testList);

        // 创建多线程运行结果的管理者对象
        FutureTask<Integer> ft1 = new FutureTask<Integer>(myCallable) ;
        FutureTask<Integer> ft2 = new FutureTask<Integer>(myCallable) ;

        // 创建线程对象
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        t1.setName("线程1");
        t2.setName("线程1");

        // 启动
        t1.start();
        t2.start();

        // 获取线程运行的结果
        Integer max1 = ft1.get();
        Integer max2 = ft2.get();

        System.out.println(max1);
        System.out.println(max2);

    }
}
