package com.designpattern.singletonpattern;

/**
 * 饿汉式单例
 * 定义：只需要三步就可以保证对象的唯一性
 *  (1) 不允许其他程序用new对象
 *  (2) 在该类中创建对象
 *  (3) 对外提供一个可以让其他程序获取该对象的方法
 *
 *  1.饿汉式（静态常量）【可用】
 *  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class SingletonEHan {

    // 1、构造方法私有（不允许其他程序用new对象）
    private SingletonEHan(){

    }

    // 2、实例只有一个，通过static来修饰为静态变量（在该类中创建对象）
    private static SingletonEHan singletonEHan = new SingletonEHan();

    // 3、建立getInstance方法（对外提供一个可以让其他程序获取该对象的方法）
    public static SingletonEHan getInstance(){
        return singletonEHan;
    }

}
