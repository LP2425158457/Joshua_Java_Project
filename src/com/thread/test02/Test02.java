package com.thread.test02;

import com.thread.test01.MyThread01;

public class Test02 {

    public static void main(String[] args) {
        // 抢红包，100块，分成3个包，小数后两位，五个人去抢
        // XXX 抢到了XX元，XX没抢到


        MyThread02 t1 = new MyThread02("线程1");
        MyThread02 t2 = new MyThread02("线程2");
        MyThread02 t3 = new MyThread02("线程3");
        MyThread02 t4 = new MyThread02("线程4");
        MyThread02 t5 = new MyThread02("线程5");
        MyThread02 t6 = new MyThread02("线程6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
