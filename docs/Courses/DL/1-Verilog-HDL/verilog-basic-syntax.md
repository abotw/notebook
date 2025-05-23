
# Verilog 语法

Verilog 是数字逻辑设计与验证中常用的硬件描述语言（Hardware Description Language, HDL），常用于模拟组合逻辑和时序逻辑电路。在《计算机组成原理》和《数字逻辑》课程中，理解其基本语法和建模方式有助于掌握控制单元（Control Unit）、算术逻辑单元（ALU）、状态机等关键模块的设计与实现。

---

## 一、Verilog的模块结构

Verilog 基本单位为**模块（Module）**，对应一个逻辑功能块。

```verilog
module module_name (
    input wire a,
    output wire b
);
    // 内部逻辑
endmodule
```

- `module`：定义模块的开始；
    
- `input`/`output`：端口定义；
    
- `wire`/`reg`：信号类型（见下文）；
    
- `endmodule`：结束模块定义。
    

---

## 二、常见数据类型与关键字

|类型/关键字|含义|
|---|---|
|`wire`|连线类型，表示组合逻辑中不带存储的信号|
|`reg`|寄存器类型，表示在时序逻辑中带存储的信号|
|`parameter`|参数定义，常用于设置模块宽度、常量|
|`assign`|连线赋值语句，仅用于 `wire` 类型|
|`always`|时序或组合逻辑块，需搭配敏感列表|
|`initial`|初始化块，仿真用，非综合|
|`begin ... end`|表示语句块|
|`if ... else`、`case`|条件与选择语句，建模多路选择器等|

---

## 三、组合逻辑与时序逻辑建模

### 1. 组合逻辑建模（Combinational Logic Modeling）

**使用 assign 或 always @(*) 构建组合逻辑：**

```verilog
assign y = a & b;

always @(*) begin
    y = a & b;
end
```

考点说明：

- `assign` 用于持续赋值；
    
- `always @(*)` 适用于多条件组合逻辑，避免综合漏项。
    

### 2. 时序逻辑建模（Sequential Logic Modeling）

**使用 always @(posedge clk) 模拟寄存器触发器：**

```verilog
always @(posedge clk or posedge rst) begin
    if (rst)
        q <= 0;
    else
        q <= d;
end
```

考点说明：

- `<=` 表示非阻塞赋值（Non-blocking Assignment），用于时序逻辑；
    
- `posedge` 表示上升沿触发；
    
- `rst`（reset）用于异步复位。
    

---

## 四、控制结构与常用写法

### 1. 多路选择器（Multiplexer）

```verilog
always @(*) begin
    case (sel)
        2'b00: y = a;
        2'b01: y = b;
        default: y = 0;
    endcase
end
```

### 2. 状态机模板（Finite State Machine, FSM）

```verilog
parameter IDLE = 2'b00, RUN = 2'b01, STOP = 2'b10;
reg [1:0] state, next_state;

always @(posedge clk or posedge rst) begin
    if (rst)
        state <= IDLE;
    else
        state <= next_state;
end

always @(*) begin
    case (state)
        IDLE: next_state = RUN;
        RUN:  next_state = STOP;
        STOP: next_state = IDLE;
    endcase
end
```

---

## 五、经典例题：4位加法器建模

**题干简述：** 使用 Verilog 编写一个4位无符号加法器模块，要求输出和及进位。

```verilog
module adder4 (
    input [3:0] a, b,
    output [3:0] sum,
    output carry
);
    assign {carry, sum} = a + b;
endmodule
```

考点分析：

- 熟悉向量（Vector）定义与加法建模；
    
- 考查组合逻辑建模及连接多个位的进位输出。
    

---

## 六、与408相关学科的联系

- **计算机组成原理（Computer Organization and Design）**：Verilog 可用于实现 ALU、寄存器组、控制器（Control Unit）等模块的 RTL（Register Transfer Level）描述；
    
- **数字逻辑（Digital Logic）**：Verilog 是现代数字系统设计与验证的主流语言，帮助理解门电路组合、触发器、时序图等概念；
    
- **操作系统（Operating System）**：对中断处理器、DMA 控制器等硬件原理的理解可借助 Verilog 模型模拟实现；
    
- **数据结构（Data Structures）**：堆栈（Stack）、FIFO（先进先出队列）等数据结构可用 Verilog 实现其硬件版本。
    

---

## 七、易混淆概念整理

|概念|易混点|区分方法|
|---|---|---|
|`=` vs `<=`|阻塞赋值 vs 非阻塞赋值|组合逻辑用`=`, 时序逻辑用`<=`|
|`wire` vs `reg`|类型含义不同|`wire`连接逻辑网，`reg`保存数值|
|`assign` vs `always`|使用场景不同|`assign`用于`wire`, `always`可用于更复杂逻辑|
|`posedge clk`|常用于寄存器建模|表示时钟上升沿触发|
