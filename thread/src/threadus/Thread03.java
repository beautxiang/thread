package threadus;

public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        System.out.println("main正在运行中");
    }
}

class T1 implements Runnable {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + Thread.currentThread().getName() + "+" + ++times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 10) {
                break;
            }
        }
    }
}
class T2 implements Runnable {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + Thread.currentThread().getName() + "+" + ++times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 10) {
                break;
            }
        }
    }
}
