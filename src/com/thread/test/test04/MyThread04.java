package com.thread.test.test04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread04 extends Thread{

    List<Integer> list = new ArrayList<Integer>();

    public MyThread04(String name, List list) {
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
        // 采用统一的集合输出
        // 线程1 的数组

        // 利用线程栈的逻辑来存储
        List<Integer> curList = new ArrayList<Integer>();

        while (true){
            synchronized (MyThread04.class){
                if (list.size()==0) {
                    System.out.println(getName() + curList);
                    break;
                }else {
                    // 打乱集合
                    Collections.shuffle(list);
                    curList.add(list.remove(0));
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
