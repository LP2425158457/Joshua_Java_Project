package com.thread.test01;

public class Test01 {

    public static void main(String[] args) {
        /**
         * 1000张电影票，每次领取3000毫秒，可以在两个窗口领取
         * 多线程模拟卖票过程并打印剩余票数的数量
         */

        MyThread01 t1 = new MyThread01("线程1");
        MyThread01 t2 = new MyThread01("线程2");

        t1.start();
        t2.start();
    }
}
