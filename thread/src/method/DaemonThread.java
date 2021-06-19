package method;

// 该例用于创建守护线程
public class DaemonThread {
    public static void main(String[] args) {
        DaemonThreadSub daemonThreadSub = new DaemonThreadSub();
//        daemonThreadSub.start();
        // 如果希望主线程结束之后，子线程也自动的退出，就需要将子线程转化为守护线程
        daemonThreadSub.setDaemon(true);
        daemonThreadSub.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在幸苦的工作" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThreadSub extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("马蓉和宋喆在聊天~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}