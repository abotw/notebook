
# Java 多线程编程概述

Java 的**多线程编程**是一种**并发编程技术**，它允许程序同时执行多个线程，从而提高应用程序的性能和响应能力，特别适用于需要处理大量任务或响应多个用户请求的场景（如服务器、图形界面、实时系统等）。

Java 多线程编程提供了丰富的 API 和工具，帮助开发者构建高性能、可伸缩的并发应用程序。掌握线程创建、同步、通信以及使用线程池和并发容器，是高效并发编程的关键。

---

## 核心概念

1. **线程（Thread）**  
    Java 使用 `Thread` 类或实现 `Runnable` 接口来定义线程。每个线程都是程序中的一个独立执行路径。
    
2. **创建线程的方式：**
    
    - 继承 `Thread` 类
        
    - 实现 `Runnable` 接口
        
    - 实现 `Callable` 接口并配合 `Future` 使用（支持返回值和异常处理）
        
3. **线程的生命周期：**  
    包括新建（New）、就绪（Runnable）、运行（Running）、阻塞（Blocked）、等待（Waiting）、计时等待（Timed Waiting）、终止（Terminated）等状态。
    
4. **线程调度：**  
    由 JVM 和操作系统调度，采用抢占式方式执行（preemptive scheduling）。可通过 `Thread.yield()`、`sleep()`、`join()` 等方法控制线程行为。
    
5. **线程同步：**  
    为了避免多个线程同时访问共享资源造成数据不一致的问题，Java 提供了多种同步机制：
    
    - `synchronized` 关键字（同步方法或同步代码块）
        
    - 显式锁 `ReentrantLock`
        
    - 原子变量类（如 `AtomicInteger`）
        
6. **线程通信：**  
    多线程之间可以使用 `wait()`、`notify()`、`notifyAll()` 等方法进行协调运行。
    
7. **线程池（Thread Pool）：**  
    Java 提供了 `ExecutorService` 接口（如 `ThreadPoolExecutor`）来管理线程池，提高资源利用效率，避免频繁创建销毁线程。
    
8. **并发工具包（java.util.concurrent）：**  
    包含各种实用的并发工具类，如：
    
    - `CountDownLatch`、`CyclicBarrier`
        
    - `Semaphore`
        
    - `ConcurrentHashMap`
        
    - `BlockingQueue`
        
