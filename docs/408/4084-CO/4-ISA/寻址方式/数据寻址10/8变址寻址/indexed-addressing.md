
# 变址寻址（Indexed Addressing）

---

## 一、定义与基本原理

**变址寻址（Indexed Addressing）** 是一种常用于数组访问的寻址方式。在这种方式下，**有效地址（EA, Effective Address）**由以下两部分构成：

```
EA = 基地址（Base Address） + 变址寄存器内容（Index Register）
```

其中，变址寄存器中通常存放**索引值**或**偏移量**，基地址则来自指令中指定的某个**内存地址或基址寄存器**。

---

## 二、主要应用场景

- **访问数组、表格、字符串等线性结构**
    
- 在循环结构中实现按序遍历
    
- 常用于高层语言中的 `for (i=0; i<n; i++) A[i]` 这类访问
    

---

## 三、逻辑过程（抽象）

设：

- `A` 是存放数组首地址的寄存器（或立即数）
    
- `IR` 是变址寄存器（Index Register）
    

则指令如：

```
LOAD R, A(IR)
```

表示从内存地址 `A + (IR)` 中取数据送入寄存器 `R`。

---

## 四、例题分析

### 【例题1】

设某变址寻址指令为 `MOV R1, 1000(R2)`，其中 `R2 = 3`，内存中地址 `1003` 存储内容为 `ABCDH`，则指令执行后，`R1` 的内容为？

**解析**：

- `1000(R2)` 表示地址为 `1000 + R2 = 1003`
    
- 所以 `R1 ← M[1003] = ABCDH`
    

✅ 答案：`R1 = ABCDH`

---

## 五、与其他寻址方式的比较

|寻址方式|特点|优点|典型应用|
|---|---|---|---|
|立即寻址（Immediate）|操作数在指令中|快速|赋值常数|
|直接寻址（Direct）|指令中给出地址|简单|小程序访问固定地址|
|间接寻址（Indirect）|指令中地址指向另一地址|灵活|链表访问|
|**变址寻址（Indexed）**|基地址 + 索引寄存器|高效访问数组|遍历数组|
|基址寻址（Base）|基址 + 偏移，常用于分段|支持程序重定位|操作系统管理|

---

## 六、相关延伸：结合汇编语言的运用

在 x86 汇编中：

```asm
MOV AX, [BX + SI]
```

即为典型的变址寻址，其中 `BX` 为基地址，`SI` 为变址寄存器。

---

## 七、总结记忆要点

- 有效地址 = 基地址 + 变址寄存器值
    
- 核心用于 **数组按索引访问**
    
- 属于 **相对寻址** 范畴，灵活高效
    
- 常与**基址寻址**混用，称为**基址变址寻址**
    