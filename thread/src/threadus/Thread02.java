package threadus;

import sun.awt.windows.ThemeReader;

// 通过实现接口来实现多线程
public class Thread02 {
    public static void main(String[] args) {
        // 1.创建线程类
        Dog dog = new Dog();
        // 2.这里没有start方法，怎么办？
        // 创建Thread类，来调用start方法，实际上这里底层使用了静态代理模式
        Thread thread = new Thread(dog);
        thread.start();

    }




}

// 通过实现Runnable接口来实现开发线程类
class Dog implements Runnable {

    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫" + "hi" + Thread.currentThread().getName() + "+" + times++);
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