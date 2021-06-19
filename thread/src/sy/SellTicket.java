package sy;

public class SellTicket {

    public static void main(String[] args) {
//        // 第一种方法
//        Sell sell1 = new Sell();
//        Sell sell2 = new Sell();
//        Sell sell3 = new Sell();
//        sell1.start();
//        sell2.start();
//        sell3.start();
        // 第二种方法
        Sell sell = new Sell();
        new Thread(sell).start();
        new Thread(sell).start();
        new Thread(sell).start();

    }
}

class Sell extends Thread {
    private static int ticketNum = 100;

    private boolean loop = true;

    // 1.将synchronized加在方法上面，这个方法就是一个同步方法
    // 2.这时锁在 this对象
//    public synchronized void sell() {
//        if (ticketNum <= 0) {
//            loop = false;
//            System.out.println("票已售完");
//            return;
//        }
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "正在售票，剩余票数：" + --ticketNum);
//
//    }
    // 3.也可以在代码块上写synchronized，这时候就是同步代码块了
    public synchronized void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                loop = false;
                System.out.println("票已售完");
                return;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售票，剩余票数：" + --ticketNum);
        }

    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}

class Sell2 implements Runnable {

    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售票，剩余票数：" + --ticketNum);
        }
    }

}