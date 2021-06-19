package method;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

}


class T1 implements Runnable {
    int hour = 0;
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("zxx" + "正在奋斗~~~" + ++hour);
            }
            System.out.printf("zxx" + "该休息了~");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                System.out.println("zxx" + "被中断了~");
            }

        }
    }
}
