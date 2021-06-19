package method;

public class Thread02 {


    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println("主线程正在吃包子，吃了" + i + "个包子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                System.out.println("主线程让子线程先吃");
                t2.join();
            }
        }

    }

}

class T2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程正在吃包子，吃了" + i + "个包子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
