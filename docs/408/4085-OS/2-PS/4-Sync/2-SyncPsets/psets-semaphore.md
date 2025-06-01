
# Psets: semaphore

## Ex. 1

> 利用信号量来描述程序或语句之间的前趋关系。下图S1,S2,S3,S4,45,S6是简单的程序段，为了使各程序段能正确执行，应设置若干个初始值为0的信号量，请完成程序填空。(6分)

![](2-SyncPsets/assets/Pasted%20image%2020250528174022.png)

```c
// 每个进程分别占 1 分，共 6 分
void p1() { 
  // … 
} // (1 分)

void p2() { 
  // … 
} // (1 分)

void p3() { 
  // … 
} // (1 分)

void p4() { 
  // … 
} // (1 分)

void p5() { 
  // … 
} // (1 分)

void p6() { 
  // … 
} // (1 分)

void main() {
  // 定义信号量
  semaphore a, b, c, d, e, f, g;

  // 初始化信号量
  a.value = b.value = c.value = 0;
  d.value = e.value = 0;
  f.value = g.value = 0;

  // 并发执行各进程
  cobegin
    p1();
    p2();
    p3();
    p4();
    p5();
    p6();
  coend
}
```