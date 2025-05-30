# 异或与同或（XOR & XNOR）

|          |     |          |
| -------- | --- | -------- |
| `\oplus` | 异或  | $\oplus$ |
| `\odot`  | 同或  | $\odot$  |

## 一、基本概念

### 1. 异或（XOR：Exclusive OR）

- **符号**：`⊕` 或 `^`（在编程中常用）
    
- **定义**：当两个输入**不同**时，输出为 1；相同时输出为 0。
    
- **逻辑表达式**：
    
    $A \oplus B = \overline{A}B + A\overline{B}$
- **真值表**：
    

|A|B|A⊕B|
|---|---|---|
|0|0|0|
|0|1|1|
|1|0|1|
|1|1|0|

### 2. 同或（XNOR：Exclusive NOR）

- **符号**：`≡` 或 `⊙`
    
- **定义**：当两个输入**相同**时，输出为 1；不同则输出为 0。
    
- **逻辑表达式**：
    
    $A \odot B = AB + \overline{A}\,\overline{B} = \overline{A \oplus B}$
- **真值表**：
    

|A|B|A≡B|
|---|---|---|
|0|0|1|
|0|1|0|
|1|0|0|
|1|1|1|

---

## 二、性质总结

### 1. 异或性质

- 自反性：A⊕A=0A \oplus A = 0
    
- 零元：A⊕0=AA \oplus 0 = A
    
- 交换律：A⊕B=B⊕AA \oplus B = B \oplus A
    
- 结合律：$A \oplus (B \oplus C) = (A \oplus B) \oplus C$
    

### 2. 同或性质

- A⊙A=1A \odot A = 1
    
- A⊙0=A‾A \odot 0 = \overline{A}
    
- A⊙1=AA \odot 1 = A
    

---

## 三、在数字逻辑电路中的应用

### 1. 常见用途

- **异或门**用于**奇偶校验（Parity Check）**电路：用于检测数据传输或存储中是否发生了错误。
    
- **全加器（Full Adder）**中求**和（Sum）**信号时常用异或：
    
    S=A⊕B⊕CinS = A \oplus B \oplus C_{\text{in}}
- **同或门**常用于**比较器（Comparator）**中，判断两个输入是否相等。
    

### 2. 组合逻辑简化

异或/同或能简化多项逻辑表达式，例如：

F=AB‾+A‾B=A⊕BF = A \overline{B} + \overline{A}B = A \oplus B

---

## 四、经典例题

### 例题：构建 1 位奇偶校验器

> **题目**：设计一个电路，对 4 位数据 D3-D0 进行**偶校验**输出 P。

**解题思路**：偶校验要求整体的 1 的个数为偶数。

**电路输出**：

P=D3⊕D2⊕D1⊕D0P = D3 \oplus D2 \oplus D1 \oplus D0

---

## 五、相关领域联系

### 1. 计算机组成原理（408）

- **ALU（Arithmetic Logic Unit）** 中，异或常用于实现减法或逻辑比较。
    
- **条件控制**：在 CPU 控制单元中，条件跳转往往与比较结果有关，使用异或/同或实现等值检测较为高效。
    

### 2. 密码学（Cryptography）

- **异或**为流密码中的核心运算，例如：
    
    密文=明文⊕密钥流\text{密文} = \text{明文} \oplus \text{密钥流}

### 3. 程序设计与算法

- 异或用于：
    
    - **交换变量**：不使用临时变量交换两个数：
        
        ```c
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        ```
        
    - **找单一元素**：一组中其他元素都成对出现，只有一个出现一次，用异或快速找出。
        

---

## 六、速记技巧

- 异或：**不同为 1，相同为 0** → “异”即不同。
    
- 同或：**相同为 1，不同为 0** → “同”即一致。
    