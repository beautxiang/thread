package threadus;

public class Thread01 {
    public static void main(String[] args) {
        // 1 创建要给Cat对象，可以当作线程使用
        Cat cat = new Cat();
        // 2 启动线程，思考：为什么用start来启动？
        cat.start();
        // 如果采用run的话，那么就是main线程直接调用方法了，那么小猫咪中的线程名也会变为main★★★，并且main线程阻塞。
//        cat.run();

        // 源码解析
        /*
         (1)
         public synchronized void start(){
            start0();
         }
         (2)
         // start0是本地方法，由JVM调用，底层是c/c++实现
         // 真正实现多线程效果的是start0()方法
         */

        // 当上面的线程启动后，程序并不会阻塞在上面不动，下面的程序依旧会执行(也就是说主线程不会阻塞)
        System.out.println("主线程正在执行中 ");
        int count = 0;
        for (int i = 0; i < 60; i++) {
            System.out.println("喵喵正在数数" + ++count + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

// 1.生成Cat，如果不继承Thread类的话，Cat只是一个普通类，继承Thread类，让其变为一个线程类
// 2.重写Thread中的run方法，该方法中写上自己的业务逻辑

class Cat extends Thread {

    private int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵，我是小猫咪" + ++times + " 当前线程的名称是：" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 80) {
                break;

            }
        }
    }
}