class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程运行中：" + Thread.currentThread().getName());
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
    }
}