# Performance, 计算机性能指标

- **Response Time / Execution Time** 从程序开始到结束的时间
- **Throughput / Bandwidth** 单位时间内完成的任务数量

## CPU Clock Cycles, 时钟周期数

- C = cycles

	- 总时钟周期数：$\text{C} = \text{cycles} = \text{CPU Time}\times{f}$

$$
\begin{aligned}
    \text{CPU clock cycles} &= \text{Instructions count} \times \text{Average cycles per instruction}
\end{aligned}
$$

## CPU Clock Frequency/Rate, 时钟主频

- $f$（单位：Hz）。
- CPU clock cycles per second, 每秒钟的时钟周期数。

$$
f=\frac{1\text{s}}{T}
$$

## CPU Clock Cycle Time, 时钟周期时间

- $\text{T}$ （单位：秒）。
- 每个时钟周期持续的时间。

$$
T = \dfrac{1\text{s}}{f}
$$

## CPI, Cycles Per Instruction, 每条指令平均消耗的时钟周期数

$$
\text{CPI}
=\frac{\text{C}}{\text{I}}
=\frac{\text{cycles}}{\text{inst.}}
=\frac{\text{CPU Time}\times{f}}{\text{inst.}}
$$

- I = inst. = instruction(s)

## CPU (execution) Time, CPU 执行时间

- 单位：秒

$$
\begin{aligned}
\text{CPU Time}
&= \text{cycles} \times \text{T} \\
&= \text{inst.} \times \frac{\text{cycles}}{\text{inst.}} \times \text{T} \\
&= \text{inst.} \times \text{CPI} \times \text{T} \\
&= \frac{\text{inst.} \times \text{CPI}}{f}
\end{aligned} \\
$$

$$
\begin{aligned}
    \text{CPU execution time} &= \text{CPU clock cycles} \times \text{Clock cycle time} \\
    &= \frac{\text{CPU clock cycles}}{\text{Clock rate}}
\end{aligned}
$$

## MIPS, Million Instructions Per Second, 每秒百万条指令



$$
\begin{aligned}
\text{MIPS} 
&= \frac{\text{inst.}}{\text{CPU time}\times 10^{6}} \\
&= \frac{\text{inst.}}{\frac{\text{inst.} \times \text{CPI}}{f}\times 10^{6}} \\
&= \frac{f}{\text{CPI} \times 10^6} \\
\end{aligned}
$$

- M = $10^6$ = 百万
- MIPS 与 $f$ 成正比、与 CPI 成反比。

---

## 📌 实用案例

### 🔹 示例：已知

- 主频 $f = 2\ \text{GHz}$
    
- 指令数 $= 10^9$
    
- CPI = 1.5
    

求执行时间和 MIPS：

$$
\text{CPU Time} = \frac{10^9 \times 1.5}{2 \times 10^9} = 0.75\ \text{秒}
$$

$$
\text{MIPS} = \frac{2 \times 10^9}{1.5 \times 10^6} = 1333.3
$$

---

## 🔄 概念对比与联系

|概念|本质|单位|越小/大越好|备注|
|---|---|---|---|---|
|主频 $f$|每秒时钟数|Hz|越大越快（理论）|非唯一性能指标|
|CPI|每条指令需多少时钟|无|越小越快|取决于架构和指令集|
|MIPS|每秒执行多少条指令|MIPS|越大越快|易被误用，不能全面评价性能|
|Clock Cycle Time $T$|单个时钟周期时间|s|越小越快|$T = 1/f$|

---

## 📎 垂直关联

|领域|联系内容|
|---|---|
|计算机组成|经典三因子模型：**时间 = 指令数 × CPI × 时钟周期**，理解性能瓶颈来源。|
|操作系统|调度策略、上下文切换、定时器频率与 CPU 执行时间相关。|
|嵌入式系统|性能预算需估算 MIPS 与功耗限制；高 CPI 指令应优化。|
|编译优化|优化器目标之一为降低有效 CPI（如减少跳转、乱序执行支持）。|

---

## 🧠 思考提示

- 两个频率一样的 CPU，为什么性能差异大？  
    👉 CPI、缓存命中率、乱序执行、流水线效率等因素决定实际执行效率。