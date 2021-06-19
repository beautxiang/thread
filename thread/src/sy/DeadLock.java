package sy;

// 模拟线程的死锁
public class DeadLock {
    public static void main(String[] args) {
        DeadLockMock deadLockMock1 = new DeadLockMock(true);
        DeadLockMock deadLockMock2 = new DeadLockMock(false);

        deadLockMock1.start();
        deadLockMock2.start();

    }

}

class DeadLockMock extends Thread {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    private boolean flag;

    public DeadLockMock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (obj1) {
                System.out.println("进入到方法1中");
                synchronized (obj2) {
                    System.out.printf("进入到方法2中");
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println("进入到方法3中");
                synchronized (obj1) {
                    System.out.printf("进入到方法4中");
                }
            }
        }
    }
}