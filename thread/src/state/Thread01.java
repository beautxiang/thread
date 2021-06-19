package state;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();
        System.out.println(state.getState());
        state.start();
        System.out.println(state.getState());

        for (int i = 0; i < 30; i++) {
            System.out.println(state.getState());
            Thread.sleep(500);
        }
    }
}

class ThreadState extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}