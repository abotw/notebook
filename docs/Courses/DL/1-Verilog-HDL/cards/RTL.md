---
aliases:
  - RTL
  - Register Transfer Level
  - 寄存器传输级
---

寄存器传输级的描述方式。

RTL 是 Verilog 设计的主要风格，描述信号在寄存器之间如何流动。

---

**RTL 是一种用来描述数字电路的抽象层次，是 Verilog 编程的主流方式。**

---

### 🔧 RTL 的核心思想：

“**数据在寄存器之间如何流动**，以及这些流动是由什么逻辑控制的。”

换句话说：

- **Register（寄存器）：** 存储数据的地方（例如触发器）
    
- **Transfer（传输）：** 数据在时钟触发下从一个寄存器流向另一个寄存器
    
- **Level（级别）：** 抽象层次，在“门级”和“行为级”之间
    

---

### 📦 RTL 模块的典型特征：

- 使用 `always @(posedge clk)` 表示时序逻辑（寄存器）
    
- 使用 `assign` 表示组合逻辑（门电路）
    
- 把整个系统分成多个“功能模块”，每个模块在 RTL 层面清晰描述
    

---

### 🧠 举例（8 位寄存器）：

```verilog
module my_register (
    input clk,
    input rst,
    input [7:0] d,
    output reg [7:0] q
);
always @(posedge clk or posedge rst) begin
    if (rst)
        q <= 8'b0;
    else
        q <= d;
end
endmodule
```

> 这段代码就是典型的 **RTL 风格**：
> 
> - 用寄存器 `q` 储存数据
>     
> - 每次时钟上升沿传输 `d` 的值
>     

---

### ✅ 为什么学习 Verilog 就要掌握 RTL？

1. **FPGA 综合工具**（如 Vivado）是基于 RTL 语义进行电路综合的
    
2. **逻辑清晰、硬件结构明确**，方便调试和测试
    
3. 是 **数字电路设计与验证的主流方式**
    