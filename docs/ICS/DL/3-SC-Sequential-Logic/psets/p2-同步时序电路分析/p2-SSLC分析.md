---
date: 2025-05-07T20:18:00
---

# SSLC分析

## Ex. 1
### q1

1. CP (Clock Pulse, `>`) -> **SSLC, Synchronous Sequential Logic Circuit, 同步时序逻辑电路**
2. $Z = X \oplus Q$ -> $\text{Output = f(input, state)}$ -> **Mealy Machine, Mealy 型状态机**
	1. `=1` -> $\oplus$, 异或
	   ![[attachments/Pasted image 20250507203709.png]]
	2. X 输入
	3. Z 输出

### q2

- Excitation: $T = Z$
- Output: $Z = X\oplus Q$
- Next-state: 

$$
\begin{aligned}
Q_{t+1} &= Q\oplus T \\
&= Q\oplus Z \\
&= Q\oplus X \oplus Q \\
&= 0\oplus X \\
&= 0'X+X'0 \\
&= X + 0 \\
&= X
\end{aligned}
$$

### q3

| $X$ | $Q$ | $T$ (excutation) | $Q_{t+1}$ (next-state) | $Z$ (output) |
| --- | --- | ---------------- | ---------------------- | ------------ |
| 0   | 0   | 0                | 0                      | 0            |
| 0   | 1   | 1                | 0                      | 1            |
| 1   | 0   | 1                | 1                      | 1            |
| 1   | 1   | 0                | 1                      | 0            |
### q4

table:

| $\frac{X}{Q}$ | 0   | 1   |
| ------------- | --- | --- |
| 0             | 0/0 | 1/1 |
| 1             | 0/1 | 1/0 |
$Q_{t+1}/Z$

diagram:
$Q \xrightarrow{\text{X/Z}} Q'$

### q5

数据变化检测电路：输入数据变化时，输出高电平/正脉冲。

### q6
