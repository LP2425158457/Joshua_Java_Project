package com.thread.test01;

public class MyThread01 extends Thread{
    // 定义1000张电影票，共享
    static int ticketCnt = 1000;

    // 定义100张礼品，共享
    static int gifttCnt = 100;

    // 两个线程获取1-100之间的所有数字，只输出所有的奇数
    static int Cnt = 100;

    public MyThread01(String name) {
        super(name);
    }

    @Override
    public void run() {
        /*
        循环
        同步代码块
        到了末尾（不符合）
        到了末尾（符合）
         */
//        while(true) {
//            synchronized (MyThread01.class) {
//                if (ticketCnt==0){
//                    break;
//                }else{
//                    try {
//                        Thread.sleep(30);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ticketCnt --;
//                    System.out.println(getName() + "抢到了票，还剩余"+ticketCnt+"票");
//                }
//            }
//            // 使其均匀一点，抢完一次休息10ms
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        while (true){
//            synchronized (MyThread01.class){
//                if (gifttCnt<=10){
//                    break;
//                }else{
//                    try {
//                        Thread.sleep(30);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    gifttCnt --;
//                    System.out.println(getName() + "拿到了礼物，还剩"+ gifttCnt + "件礼物");
//                }
//            }
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while (true){
            synchronized (MyThread01.class){
                if (Cnt==0){
                    break;
                }else{
                    // 先拿再减
                    if(Cnt%2!=0){
                        System.out.println(getName() + "拿到了数值："+ Cnt + "");
                    }
                    Cnt --;
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
