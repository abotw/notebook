
# 线程的生命周期

线程的生命周期可以分为以下几个主要阶段：

|状态|英文名|说明|
|---|---|---|
|新建状态|New|线程对象已创建，但尚未调用 `start()` 启动。|
|就绪状态|Runnable|调用 `start()` 后进入就绪状态，等待 CPU 调度。|
|运行状态|Running|获得 CPU 时间片后，线程开始执行 `run()` 方法。|
|阻塞状态|Blocked|线程试图访问被其他线程锁定的同步资源时进入阻塞状态。|
|等待状态|Waiting|线程无限期等待其他线程执行特定操作而唤醒，例如 `wait()`。|
|超时等待状态|Timed Waiting|线程等待指定时间后自动唤醒，例如 `sleep()` 或 `join(timeout)`。|
|终止状态|Terminated|线程执行完毕或抛出未捕获异常，生命周期结束。|

---

### 示例代码：演示线程生命周期（Java）

```java
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
```

---

### 中文说明：

- `new Thread(...)` 创建线程对象时，状态为 **New**。
    
- 调用 `start()` 后，线程进入 **Runnable（就绪）状态**，等待系统调度。
    
- 当调度器分配 CPU 给线程后，它进入 **Running（运行）状态**。
    
- `sleep()` 会使线程进入 **Timed Waiting（超时等待）状态**。
    
- `join()` 会使主线程等待子线程完成，主线程可能进入 **Waiting** 或 **Timed Waiting**。
    
- 线程执行完毕后，状态变为 **Terminated（终止）**。
    

如需进一步演示线程阻塞、等待等复杂状态，我也可以提供更复杂的示例。需要吗？