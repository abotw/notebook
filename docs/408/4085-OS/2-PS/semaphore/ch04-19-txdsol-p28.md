---
tags:
  - c-zzx
---

# ch04-19-txdsol-p28


![](assets/Pasted%20image%2020250529114059.png)

19．有 3 个进程 P1、P2、P3 协作解决文件打印问题。P1 将文件记录从磁盘读入内存

的缓冲区 1，每执行一次读一个记录 ；P2 将缓冲区 1 中的内容复制到缓冲区 2 中，每执行

一次复制一个记录 ；P3 将缓冲区 2 中的内容打印出来，每执行一次打印一个记录。缓冲区

的大小与记录大小一样。请用信号量机制来保证文件的正确打印。

![](assets/Pasted%20image%2020250529114120.png)

【参考答案】对缓冲区1来说，P1是生产者，P2是消费者；对缓冲区2来说，P2是生产者，P3

是消费者。缓冲区1和缓冲区2都只能存放一个记录，它们都是临界资源，但无须使用信号量来

实现互斥。P2对于缓冲区1是消费者，对于缓冲区2是生产者，因此要对P2设置两个信号量来分别

控制其对不同缓冲区的不同操作。该文件打印过程的同步算法可描述为：

```
semaphore empty1=1,full1=0,empty2=1,full2=0;

P1( ) {

P2( ){

while(1) {

从磁盘读一个记录 ;

P(empty1);

将记录存放到缓冲区 1 中 ;

V(full1);

}

}

while(1) {

P(full1);

P(empty2);

从缓冲区 1 中取一个记录 ;

将记录复制到缓冲区 2 中 ;

V(empty1);

V(full2);

}

}

P3( ) {

while(1){

P(full2);

从缓冲区 2 中取一个记录 ;

V(empty2);

将取出的记录打印出来 ;

main( ) {

cobegin

P1( );

P2( );

P3( );

coend

}

}

}
```
