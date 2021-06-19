package ticket;

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
        Sell2 sell2 = new Sell2();
        new Thread(sell2).start();
        new Thread(sell2).start();
        new Thread(sell2).start();
    }
}

class Sell extends Thread {
    private static int ticketNum = 100;

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