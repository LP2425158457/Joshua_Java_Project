package com.thread.chapter.one;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Double;

import java.util.concurrent.atomic.AtomicInteger;

public class SalesThreadDemo {
    // 商品数量：5
    public static final int MAX_AMOUNT = 5;

    static class StoreGoods extends Thread{
        // 同样的一个商品数量
        private int goodsAmount = MAX_AMOUNT;
        public StoreGoods(String name){
            super(name);
        }
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < MAX_AMOUNT; i++) {
                if (this.goodsAmount>0){
                    System.out.println(getCurrentThreadName() + " 卖出一件，还剩：【" + --goodsAmount + "】" );
                    sleepMillSeconds(10);
                }
            }
            System.out.println(getCurrentThreadName() + "，运行结束。。。");
        }
    }

    static class MallGoods implements Runnable{
        // 同样的一个商品数量
        private AtomicInteger goodsAmount = new AtomicInteger(MAX_AMOUNT);
        @Override
        public void run() {
            for (int i = 0; i < this.goodsAmount.get(); i++) {
                System.out.println(getCurrentThreadName() + " 卖出一件，还剩：【" + this.goodsAmount.decrementAndGet() + "】" );
                sleepMillSeconds(10);
            }
            System.out.println(getCurrentThreadName() + "，运行结束。。。");
        }
    }

    public static void main(String[] args) {
        System.out.println("================================商店销售的版本================================");
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new StoreGoods("店员【" + i + "】");
            thread.start();
        }
        sleepMillSeconds(20);
        System.out.println("================================商场销售的版本================================");
        MallGoods mallGoods = new MallGoods();
        for (int i = 0; i < 2; i++) {
            thread = new Thread(mallGoods, "商场销售员【" + i + "】");
            thread.start();
        }
    }

    // 获取线程的方法
    public static String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }

    // 线程休眠
    public static void sleepMillSeconds(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
