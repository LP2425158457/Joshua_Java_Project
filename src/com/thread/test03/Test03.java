package com.thread.test03;

import com.thread.test02.MyThread02;

import java.util.ArrayList;
import java.util.Collections;

public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        // 把数组的值传递给集合list
        Collections.addAll(testList, 10,5,20,100,30,45,60,72);

        MyThread03 t1 = new MyThread03("线程1",testList);
        MyThread03 t2 = new MyThread03("线程2",testList);
        // 抽奖
        t1.start();
        t2.start();
    }
}
