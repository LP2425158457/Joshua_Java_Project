package com.designpattern.singletonpattern;

/**
 * 2.饿汉式（静态代码块）【可用】
 * 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
 *  优点：写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class SingletonEHanTwo {
    private static SingletonEHanTwo singletonEHanTwo = null;

    static {
        singletonEHanTwo = new SingletonEHanTwo();
    }

    public static SingletonEHanTwo getInstance() {
        if (singletonEHanTwo == null) {
            singletonEHanTwo = new SingletonEHanTwo();
        }
        return singletonEHanTwo;
    }

}
