---
tags:
  - c-zzx
---

# ch04-20-txdsol-p28


![](../../../0-Misc/final-25sp-zzx/assets/Pasted%20image%2020250529114157.png)

20．桌上有一个能盛得下 5 个水果的空盘子。爸爸不停地向盘中放苹果或橘子，儿子

不停地从盘中取出橘子享用，女儿不停地从盘中取出苹果享用。规定 3 人不能同时向（从）

盘子中放（取）水果。试用信号量来实现爸爸、儿子和女儿这 3 个“循环进程”之间的

同步。

![](../../../0-Misc/final-25sp-zzx/assets/Pasted%20image%2020250529114223.png)

【参考答案】分析：本题是生产者-消费者问题的变形，相当于一个能生产两种产品的生

产者（爸爸）向两个消费者（儿子和女儿）提供产品的同步问题，因此，须设置两个不同的

full信号量apple和orange，它们的初值均为0。为了描述上述同步问题，可定义如下信号量：

```
semaphore empty=5, orange=0, apple=0, mutex=1;
```

爸爸、儿子、女儿的算法可描述为：

```
Dad( ) {

Son( ) {

while(1) {

P(empty);

P(mutex);

将水果放入盘中 ;

while(1) {

P(orange);

P(mutex);

从盘中取一个橘子 ;

Daughter( ) {

while(1) {

P(apple);

P(mutex);

从盘中取一个苹果 ;

V(mutex);

if( 放入的是橘子 )

V(orange);

V(mutex);

V(empty);

享用橘子 ;

V(mutex);

V(empty);

享用苹果 ;

else

}

}

V(apple);

}

}

}

}
```

