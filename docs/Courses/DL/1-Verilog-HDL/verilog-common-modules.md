
# Verilog 模块

在计算机考研408科目中，掌握 Verilog 对常用逻辑模块的建模方法，能够帮助考生深入理解**控制器（Controller）**、**数据通路（Datapath）**等硬件系统设计，是《计算机组成原理》和《数字逻辑》的高频考点。

本卡片围绕常用模块的 RTL（Register Transfer Level，寄存器传输级）建模展开，涵盖加法器、选择器、比较器、计数器、状态机等典型模块，注重实用语法与考点联系。

---

## 一、加法器（Adder）

### 模块功能：实现两个二进制数相加，支持进位输出。

```verilog
module adder4 (
    input [3:0] a, b,
    output [3:0] sum,
    output carry
);
    assign {carry, sum} = a + b;
endmodule
```

考点说明：

- 使用向量建模；
    
- 常作为 ALU（Arithmetic Logic Unit，算术逻辑单元）子模块；
    
- 在组合逻辑建模中频繁出现。
    

---

## 二、多路选择器（Multiplexer）

### 模块功能：根据选择信号，从多个输入中选择一个输出。

```verilog
module mux4 (
    input [1:0] sel,
    input [3:0] a, b, c, d,
    output reg [3:0] y
);
    always @(*) begin
        case (sel)
            2'b00: y = a;
            2'b01: y = b;
            2'b10: y = c;
            2'b11: y = d;
        endcase
    end
endmodule
```

考点说明：

- 常用于数据通路控制；
    
- 与控制器设计密切相关。
    

---

## 三、比较器（Comparator）

### 模块功能：判断两个二进制数的大小关系。

```verilog
module comparator (
    input [3:0] a, b,
    output eq, gt, lt
);
    assign eq = (a == b);
    assign gt = (a > b);
    assign lt = (a < b);
endmodule
```

考点说明：

- 简单建模中常以组合逻辑形式考查；
    
- 在分支控制与流水线（Pipeline）中用于跳转判断。
    

---

## 四、计数器（Counter）

### 模块功能：每个时钟上升沿对值加一，支持异步复位。

```verilog
module counter (
    input clk, rst,
    output reg [3:0] count
);
    always @(posedge clk or posedge rst) begin
        if (rst)
            count <= 0;
        else
            count <= count + 1;
    end
endmodule
```

考点说明：

- 考查同步/异步时序逻辑；
    
- 在控制状态机（FSM）或流水线周期控制中常见。
    

---

## 五、状态机（Finite State Machine, FSM）

### 模块功能：根据当前状态和输入跳转到下一个状态。

```verilog
module fsm_example (
    input clk, rst, in,
    output reg out
);
    parameter S0 = 2'b00, S1 = 2'b01, S2 = 2'b10;
    reg [1:0] state, next_state;

    // 状态寄存器
    always @(posedge clk or posedge rst) begin
        if (rst)
            state <= S0;
        else
            state <= next_state;
    end

    // 状态跳转逻辑
    always @(*) begin
        case (state)
            S0: next_state = in ? S1 : S0;
            S1: next_state = in ? S2 : S0;
            S2: next_state = in ? S2 : S0;
        endcase
    end

    // 输出逻辑
    always @(*) begin
        out = (state == S2);
    end
endmodule
```

考点说明：

- 状态机是控制器实现的核心；
    
- 需掌握 Moore 型与 Mealy 型状态机区别；
    
- 在输入输出控制、流水线暂停控制等应用广泛。
    

---

## 六、经典例题：设计一个带使能信号的二进制计数器

**题干简述：** 实现一个4位计数器，具有复位 `rst` 和使能 `en` 输入。

```verilog
module counter_en (
    input clk, rst, en,
    output reg [3:0] cnt
);
    always @(posedge clk or posedge rst) begin
        if (rst)
            cnt <= 0;
        else if (en)
            cnt <= cnt + 1;
    end
endmodule
```

**考点解析：**

- 综合考查时序逻辑建模；
    
- 引入条件判断 `en`，体现状态控制能力；
    
- 与 CPU（Central Processing Unit）中的时钟控制逻辑相关。
    

---

## 七、与408学科交叉点分析

|模块|相关学科|应用联系|
|---|---|---|
|加法器|计算机组成原理|实现 ALU 功能单元|
|选择器|数字逻辑|作为数据通路控制器|
|比较器|操作系统|中断优先级判断逻辑|
|计数器|组成原理/操作系统|控制器周期/定时中断|
|状态机|数字逻辑/组成原理|控制单元设计、I/O 状态判断|

---

## 八、易混淆点整理

|概念|误区|正确理解|
|---|---|---|
|`always @(*)` vs `always @(posedge clk)`|容易混用组合与时序建模|前者为组合逻辑，后者为时序逻辑|
|寄存器建模使用 `reg`|`reg` ≠ 实体寄存器|`reg` 表示能在 `always` 中赋值的变量|
|状态跳转逻辑和状态寄存器分开写|初学者常合并写，逻辑混乱|建议状态寄存器与状态转移逻辑分开编写|
