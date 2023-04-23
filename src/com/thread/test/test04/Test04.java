package com.thread.test.test04;

import java.util.ArrayList;
import java.util.Collections;

public class Test04 {
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        // 把数组的值传递给集合list
        Collections.addAll(testList, 10,5,20,100,30,45,60,72);

        MyThread04 t1 = new MyThread04("线程1",testList);
        MyThread04 t2 = new MyThread04("线程2",testList);

        t1.start();
        t2.start();
    }
}
