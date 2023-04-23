package com.thread.test.test05;

import com.thread.test.test04.MyThread04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    List<Integer> list = new ArrayList<Integer>();

    // 使用Callable
    public MyCallable(List list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        List<Integer> curList = new ArrayList<Integer>();
        while (true){
            synchronized (MyThread04.class){
                if (list.size()==0) {
                    System.out.println(Thread.currentThread().getName() + curList);
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
        if (curList.size()==0){
            return null;
        }else{
            return Collections.max(curList);
        }
    }
}
