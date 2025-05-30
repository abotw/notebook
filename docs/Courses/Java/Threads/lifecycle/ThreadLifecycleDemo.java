public class ThreadLifecycleDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task(), "MyThread");

        System.out.println("1. New 状态: " + thread.getState()); // NEW

        thread.start(); // 启动线程
        System.out.println("2. 启动后状态: " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(200); // 主线程睡眠，给子线程运行的机会
            System.out.println("3. 主线程睡眠中，子线程可能在运行或等待: " + thread.getState());

            thread.join(); // 等待子线程执行完毕
            System.out.println("4. 子线程执行完毕状态: " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        public void run() {
            try {
                System.out.println("子线程正在运行...");
                Thread.sleep(500); // 进入 Timed Waiting 状态
                System.out.println("子线程运行结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}