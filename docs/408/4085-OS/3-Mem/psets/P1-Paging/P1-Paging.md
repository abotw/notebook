---
tags:
  - cal-zzx
---

# P1: Paging

## Ex. 1 ch05-15-txdsol-p33

![](assets/Pasted%20image%2020250529113812.png)

---

| logical memory index (页号) | physical memory index (内存块号) |
| ------------------------- | ---------------------------- |
| 0                         | 2                            |
| 1                         | 4                            |
| 2                         | 6                            |
| 3                         | 7                            |
page size = 1KB

| logical address | logical page number | page offset | physical page number                          | physical address  |
| --------------- | ------------------- | ----------- | --------------------------------------------- | ----------------- |
|                 | p(l)                | d           | p(p)                                          |                   |
| 1023            | 0                   | 1023        | 2                                             | 3071              |
| 2500            | 2                   | 452         | 6                                             | 6596              |
| 3500            | 3                   | 428         | 7                                             | 7596              |
| 4500            | **4**               | 404         | logical page number<br>><br>page table length | -> boundary error |

---

![](assets/Pasted%20image%2020250529113824.png)

---

![](assets/address-translation.drawio.svg)

---

![](assets/address-translation-p1.drawio.svg)

---

$$
\text{逻辑地址}\div\text{页面大小}=\text{页号}\text{\ R\ }\text{页内地址}
$$

---


![](assets/Pasted%20image%2020250531212438.png)

![](assets/Pasted%20image%2020250531212122.png)

![](assets/Pasted%20image%2020250531212458.png)

##  address translation by Memory Management Unit (MMU)

![](assets/Pasted%20image%2020250531212613.png)

![](assets/Pasted%20image%2020250531213543.png)