package com.collections;

import java.util.*;

public class CollectionUtils {

    /*
    阿里巴巴Java开发手册：判断所有集合内部的元素是否为空，使用 isEmpty() 方法，而不是 size()==0 的方式
    判断所有集合内部的元素是否为空，使用 isEmpty() 方法，而不是 size()==0 的方式
     */

    public static void main(String[] args) {
        // List 有序可重复
        List list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        // 遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "：" + list.get(i)) ;
        }



        Map map = new HashMap();
    }

}
