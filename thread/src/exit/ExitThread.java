package exit;

public class ExitThread {
    public static void main(String[] args) {

        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setLoop(false);

    }
}

class T1 implements Runnable {

    // 想要终止线程需要加上一个控制变量
    int num = 0;

    boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println("当前线程正在数数：" + ++num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
