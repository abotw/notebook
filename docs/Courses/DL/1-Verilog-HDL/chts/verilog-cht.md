# Verilog Cheatsheet

Verilog 是一种用于描述**数字电路**的**硬件描述语言（HDL）**，常用于 FPGA 和 ASIC 设计。

## 小贴士 📝

| 关键词         | 用途简介              |
| ----------- | ----------------- |
| `module`    | 定义模块              |
| `endmodule` | 结束模块              |
| `input`     | 输入端口              |
| `output`    | 输出端口              |
| `wire`      | 连线型变量（默认）         |
| `reg`       | 寄存器型变量（用于 always） |
| `always`    | 定义时序或组合逻辑         |
| `@()`       | 敏感列表，定义触发条件       |
| `posedge`   | 上升沿               |
| `negedge`   | 下降沿               |
| `<=`        | 非阻塞赋值（并发，推荐用于时序）  |
| `begin/end` | 多语句块              |
| `case`      | 多分支选择器            |
| `{a, b}`    | 拼接信号              |

---

## 模块定义 📦

```verilog
module module_name(
	// module 声明列表：端口定义
    input wire clk,
    input wire rst,
    output reg [3:0] out
);
// ... 模块体（模块内容） ...
endmodule
```

- **module**：模块起始关键字。
    
- **endmodule**：模块结束标志。
    
- **module_name**：模块名称。
    
- 端口（input/output）可以在 module 声明处或模块体内声明。
    

---

## 输入输出与变量类型 🔌 

```verilog
input wire clk;      // 输入信号，类型是 wire
output reg [7:0] q;  // 输出信号，类型是 reg（用于 always 块）
```

- **`wire`**：**默认**类型，**连接**用，**不能在 `always` 中赋值**。
    
- **`reg`**：可在 `always` 块中赋值，表示"寄存器"行为（不是真实寄存器，只是行为上有存储效果）。
    
- **`input/output/inout`**：输入、输出、**双向端口**。
    

---

## 时序控制（always 块） 🔁 

```verilog
always @(posedge clk or negedge rst) begin
    // 时序逻辑
end
```

- **`always @()`**：用于描述时序逻辑或组合逻辑。
    
- `posedge clk`：时钟上升沿触发。
    
- `negedge rst`：复位信号下降沿触发。
    

---

## 非阻塞赋值 `<=` vs 阻塞赋值 `=` ⏱

```verilog
// 时序逻辑中使用非阻塞赋值
always @(posedge clk) begin
    q <= d;
end

// 组合逻辑中常用阻塞赋值
always @(*) begin
    y = a & b;
end
```

- `<=`：**非阻塞赋值**，并行赋值，常用于时序逻辑。
    
- `=`：**阻塞赋值**，顺序执行，常用于组合逻辑。
    

---

## 代码块：begin ... end 🔂

```verilog
always @(posedge clk) begin
    a <= b;
    c <= d;
end
```

- **begin ... end**：类似于 C 的 `{}`，用于封装多个语句。
    

---

## 多路选择：case语句 🧮

```verilog
always @(*) begin
    case (sel)
        2'b00: y = a;
        2'b01: y = b;
        2'b10: y = c;
        default: y = 0;
    endcase
end
```

- 类似于 C 的 `switch-case`，常用于多路选择器、状态机等。
    
- 必须有 `default` 分支以避免 latch 生成。
    

---

## 拼接运算：{ } 🧩 

```verilog
assign out = {a, b}; // 将两个信号拼接成一个更宽的信号
```

- `{J, K}`：拼接操作，类似于 Python 的 tuple 合并。
    
- 例：`{4'b1010, 4'b1100}` → `8'b10101100`
    

---
