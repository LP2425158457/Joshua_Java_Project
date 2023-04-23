package com.thread.test.test02;

import java.math.BigDecimal;

public class MyThread02 extends Thread{
    // 红包固定金额 100 元（共享变量：static）
    static BigDecimal hbAmount = new BigDecimal(0.06);

//    // 红包固定个数 3 个（共享变量：static）
//    static int hbCnt = 3;
    // 红包醉倒个数 5 个（共享变量：static）
    static int maxHbCnt = 5;

    // 红包最小金额（共享常量：static final 并大写）
    static final BigDecimal MIN = new BigDecimal(0.01);



    public MyThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        /*
        循环（不用循环了，没人只抢一次而已）
        同步代码块
        到了末尾（没有结果）
        到了末尾（有结果）
         */
//        while (true){
//            synchronized (MyThread02.class){
//                if (hbCnt==0){
//                    // 证明抢完了
//                    System.out.println(getName() + "没抢到");
//                }else{
//                    BigDecimal prize = BigDecimal.ZERO;
//                    // 最后一次抢红包
//                    if (hbCnt==1){
//                        prize = hbAmount;
//                    }else{
//                        // 第一次、第二次抢红包(至少要留一次或两次红包的钱)
//                        BigDecimal rouds = hbAmount.subtract(MIN.multiply(new BigDecimal(hbCnt-1)));
//                        prize = rouds.multiply(BigDecimal.valueOf(Math.random()));
//                        // 可能随机到0，如果是0，那么就要取最小金额
//                        if (prize.compareTo(MIN)<0){
//                            prize = MIN;
//                        }
//                    }
//                    prize = prize.setScale(2, BigDecimal.ROUND_HALF_UP);
//                    System.out.println(getName() + "抢到了"+ prize+ "元");
//                    hbCnt --;
//                    hbAmount  = hbAmount.subtract(prize);
//                }
//            }
        // 假设只有最大个数，红包个数 0《 5
        synchronized (MyThread02.class){
            // 以红包金额来判断是否抢完
            if (hbAmount.compareTo(BigDecimal.ZERO)<=0){
                // 证明抢完了
                System.out.println(getName() + "没抢到");
            }else{
                BigDecimal prize = BigDecimal.ZERO;
                // 最后一次抢红包（金额还有，且第五次抢红包）
                if (maxHbCnt==1){
                    prize = hbAmount;
                }else{
                    // 第n次抢红包(不用留钱，随机的)
                    prize = hbAmount.multiply(BigDecimal.valueOf(Math.random()));
                    // 可能随机到0，如果是0，那么就要取最小金额
                    if (prize.compareTo(MIN)<0){
                        prize = MIN;
                    }
                }
                prize = prize.setScale(2, BigDecimal.ROUND_HALF_UP);
                System.out.println(getName() + "抢到了"+ prize+ "元");
                maxHbCnt --;
                hbAmount  = hbAmount.subtract(prize);
            }
        }
//        }
    }
}
