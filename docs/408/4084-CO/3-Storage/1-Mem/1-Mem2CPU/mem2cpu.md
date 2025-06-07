
# Mem to CPU

## links

- [菜鸟是如何修炼的22-字位扩展通俗理解](https://www.bilibili.com/video/BV1zW4y147x5/)
- [Beokayy_22-干掉存储器计划-第二话](https://www.bilibili.com/video/BV1VG411b7e3/)
	- 13:31 课后题讲解

## 存储芯片的基本结构

![](assets/Pasted%20image%2020250607191758.png)
![](assets/Pasted%20image%2020250607192129.png)

## 主存容量扩展

### 位扩展

![](assets/Pasted%20image%2020250607192842.png)

![](assets/Pasted%20image%2020250607192916.png)

![](assets/Pasted%20image%2020250607192521.png)

![](assets/Pasted%20image%2020250607192549.png)

### 字扩展

![](assets/Pasted%20image%2020250607193805.png)



线选法，是用N条线（一般是地址线的高位）来分别选择N个存储器芯片。

优点是一目了然、直观。缺点是浪费，因为N条线，其实可以有 $2^N$ 个状态，可以选择 $2^N$ 个芯片，同时也有地址空间不连续的问题。

---

而译码片选法（使用$2-2^N$译码器），则地址连续。

### 字、位扩展

![](assets/Pasted%20image%2020250607194048.png)

## 主存和CPU的连接

![](assets/Pasted%20image%2020250607192744.png)

![](assets/Pasted%20image%2020250607194251.png)
![](assets/Pasted%20image%2020250607194335.png)

## 寻址

![](assets/Pasted%20image%2020250607194543.png)

## MAR & MDR

![](assets/Pasted%20image%2020250607200456.png)





