package com.designpattern.singletonpattern;

public class SingletonTest {

    public static void main(String[] args) {
        /**
         * 单例模式主要是为了避免因为创建了多个实例造成资源的浪费，
         * 且多个实例由于多次调用容易导致结果出现错误，
         * 而使用单例模式能够保证整个应用中有且只有一个实例。
         *
         * 定义：只需要三步就可以保证对象的唯一性
         *  (1) 不允许其他程序用new对象
         *  (2) 在该类中创建对象
         *  (3) 对外提供一个可以让其他程序获取该对象的方法
         *
         * 对比定义：
         *  (1) 私有化该类的构造函数
         *  (2) 通过new在本类中创建一个本类对象
         *  (3) 定义一个公有的方法，将在该类中所创建的对象返回
         */

        SingletonEHan singletonEHan = SingletonEHan.getInstance();
        SingletonEHan singletonEHan2 = SingletonEHan.getInstance();
        SingletonEHanTwo singletonEHanTwo = SingletonEHanTwo.getInstance();
        // 如何区分是否是一个实例？
        // 查看hashCode
        System.out.println(singletonEHan.toString() + "——hashCode：" + singletonEHan.hashCode());
        System.out.println(singletonEHan2.toString() + "——hashCode：" + singletonEHan2.hashCode());
        System.out.println(singletonEHanTwo.toString() + "——hashCode：" + singletonEHanTwo.hashCode());
    }
}
