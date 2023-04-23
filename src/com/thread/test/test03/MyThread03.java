package com.thread.test.test03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread03 extends Thread{

    List<Integer> list = new ArrayList<Integer>();

    // 线程1 的数组
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();


    public MyThread03(String name, List list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        // 循环
        // 同步代码块
        // 末尾（不符合）
        // 末尾（符合）
//        while (true){
//            synchronized (MyThread03.class){
//                if (list.size()==0) {
//                    break;
//                }else {
//                    // 打乱集合
//                    Collections.shuffle(list);
//                    System.out.println(getName() + "又产生了一个 " + list.get(0)+ " 元大奖");
//                    list.remove(0);
//                }
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        // 采用统一的集合输出
        while (true){
            synchronized (MyThread03.class){
                if (list.size()==0) {
                    if("线程1".equals(getName())){
                        System.out.println("线程1 ：" + list1);
                    }else{
                        System.out.println("线程2 ：" + list2);
                    }
                    break;
                }else {
                    // 打乱集合
                    Collections.shuffle(list);
                    if("线程1".equals(getName())){
                        list1.add(list.remove(0));
                    }else{
                        list2.add(list.remove(0));
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
