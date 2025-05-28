
# Psets: Processes Sync

## Ex. 1

> 请简要说明什么是 AND 信号量（AND-semaphore），并结合其特性，利用 AND 信号量编写解决生产者-消费者问题的伪代码。**（10 分）

```c
// 解决生产者－消费者问题可描述如下：

// 定义相关变量
// …（2 分）

void producer() {
  do {
    // 生产一个产品至 nextp
    produce an item in nextp;
    // …

    // ↓以下空行处填写同步与互斥相关操作（4 分）
    ;
    ;
    ;
    ;

  } while (TRUE);
}

void consumer() {
  do {
    // ↓以下空行处填写同步与互斥相关操作（4 分）
    ;
    ;
    ;
    ;

    // 从 nextc 中消费产品
    consume the item in nextc;
    // …
  } while (TRUE);
}
```

### AND信号量的定义（2 分）
AND 信号量是一种同步机制，允许一个进程在等待多个条件同时满足时进行阻塞和唤醒。只有当所有被等待的信号量都达到允许条件（例如全部非 0），进程才会继续执行。它是多条件同步的一种机制，适用于多个事件必须同时完成才能继续执行的场景。

---

### 使用 AND 信号量解决生产者－消费者问题的伪代码（8 分）

设定如下共享变量和信号量：

```c
semaphore mutex = 1;        // 互斥信号量，初始值为1
semaphore empty = N;        // 表示空缓冲区数量，初始值为缓冲区大小 N
semaphore full = 0;         // 表示已占用缓冲区数量，初始值为0

AND_semaphore and_full_mutex = AND(full, mutex);
AND_semaphore and_empty_mutex = AND(empty, mutex);
```

生产者进程：

```c
void producer() {
  do {
    produce_item(nextp);

    wait(and_empty_mutex);  // 等待缓冲区非满且获得互斥访问
    insert_item(nextp);     // 插入到缓冲区
    signal(mutex);          // 释放互斥信号量
    signal(full);           // 增加已使用缓冲区计数
  } while (TRUE);
}
```

消费者进程：

```c
void consumer() {
  do {
    wait(and_full_mutex);   // 等待缓冲区非空且获得互斥访问
    remove_item(nextc);     // 从缓冲区取出项目
    signal(mutex);          // 释放互斥信号量
    signal(empty);          // 增加空缓冲区计数

    consume_item(nextc);
  } while (TRUE);
}
```

---

**评分说明：**

- 正确定义 AND 信号量概念，说明其“多个条件同时满足”特点：2 分；
    
- 生产者伪代码正确使用 AND 信号量进行同步和互斥：4 分；
    
- 消费者伪代码正确使用 AND 信号量进行同步和互斥：4 分；
    