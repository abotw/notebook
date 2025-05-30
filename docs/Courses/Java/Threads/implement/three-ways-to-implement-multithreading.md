
# Java 多线程的三种实现方式及示例代码


Java 中实现多线程有三种主要方式：

---

## 一、继承 `Thread` 类

**实现方式：**

1. 创建一个类继承 `Thread`。
    
2. 重写 `run()` 方法。
    
3. 创建子类对象并调用 `start()` 启动线程。
    

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程运行中：" + Thread.currentThread().getName());
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // 启动线程，自动调用 run()
    }
}
```

---

## 二、实现 `Runnable` 接口

**实现方式：**

1. 创建一个类实现 `Runnable` 接口。
    
2. 实现 `run()` 方法。
    
3. 用 `Thread` 包装并调用 `start()` 启动线程。
    

```java
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
```

> 优点：可以避免单继承局限，一个类可以同时继承别的类和实现 `Runnable`。

---

## 三、实现 `Callable` 接口 + `FutureTask`

**特点：**可以有返回值、可以抛出异常。

**实现方式：**

1. 创建一个类实现 `Callable` 接口。
    
2. 实现 `call()` 方法。
    
3. 使用 `FutureTask` 包装 `Callable`。
    
4. 用 `Thread` 启动 `FutureTask`。
    

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {
    @Override
    public String call() {
        return "线程运行完成：" + Thread.currentThread().getName();
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(c);
        Thread t = new Thread(ft);
        t.start();

        // 获取返回值（阻塞等待）
        String result = ft.get();
        System.out.println("线程返回值：" + result);
    }
}
```

---

## 总结对比

|方式|是否支持返回值|是否支持抛出异常|是否灵活组合其他接口|
|---|---|---|---|
|`Thread`|❌|❌|❌|
|`Runnable`|❌|❌|✅|
|`Callable`|✅|✅|✅|
