
# 蔡佳楠25 Final Review

## 一、(30') 基础题

### 1. (6') 8421, excess-3

#### 1.11 8421, 余3码, 2421, 格雷BCD (25mid) *

![](assets/Pasted%20image%2020250609185459.png)

#### 1.12

![](assets/Pasted%20image%2020250609185525.png)

#### 1.13

![](assets/Pasted%20image%2020250609185717.png)

#### 1.14

![](assets/Pasted%20image%2020250609185733.png)

#### 1.15

![](assets/Pasted%20image%2020250609185748.png)

#### 1.16

![](assets/Pasted%20image%2020250609185626.png)

### 2. (8') parity check

#### 1.17 确定二进制信息码的奇、偶校验位 (25mid) *

![](assets/Pasted%20image%2020250609185816.png)

### 3. (8') prove

#### 2.7 证明等式 (24mid, 25mid) *

![](assets/Pasted%20image%2020250609190030.png)

![](assets/Pasted%20image%2020250609190051.png)

![](assets/Pasted%20image%2020250609193912.png)

### 4. (8') simplified

#### 化简逻辑函数 (25mid) *

$$
F=AB'CD+ABD+AC'D
$$

![](assets/Pasted%20image%2020250609193926.png)

![](assets/Pasted%20image%2020250609193945.png)

#### 2.16

![](assets/Pasted%20image%2020250609190855.png)

![](assets/Pasted%20image%2020250609190908.png)



## 二、(30') 分析题

### 5. (14') CL

#### 4.1

![](assets/Pasted%20image%2020250609191234.png)

#### 4.2

![](assets/Pasted%20image%2020250609191324.png)

#### 4.3

![](assets/Pasted%20image%2020250609191343.png)

#### 4.5

![](assets/Pasted%20image%2020250609191421.png)

#### 4.23 险象

![](assets/Pasted%20image%2020250609191732.png)

#### 4.24 险象

![](assets/Pasted%20image%2020250609191755.png)
![](assets/Pasted%20image%2020250609191813.png)



### 6. (16') SL

#### 5.2 波形图

![](assets/Pasted%20image%2020250609191955.png)

#### 5.3 波形图

![](assets/Pasted%20image%2020250609192021.png)

#### 5.4 T触发器状态转移图

![](assets/Pasted%20image%2020250609192048.png)

#### 5.6 波形图

![](assets/Pasted%20image%2020250609192338.png)

#### 5.7 波形图

![](assets/Pasted%20image%2020250609192415.png)

![](assets/Pasted%20image%2020250609192430.png)

![](assets/Pasted%20image%2020250609192452.png)

![](assets/Pasted%20image%2020250609192502.png)


## 三、(40') 设计题

### 7. (10') verilog

#### 编程题 1

> 设计4位二进制同步加1计数器的 Verilog HDL 模型。
> 
> （提示：模块名称命名为 counter，输入为时钟 CP，上升沿有效，输出 dataout，位宽为4，每接收到一个 CP 上升沿，计数器进行加1计数。）

##### key (cjn)

```verilog
module counter (cp, dataout);
	input cp;
	output [3:0] dataout;
	reg [3:0] dataout;
	always @(posedge cp)
		dataout <= dataout + 1; // 加1计数
endmodule
```

##### sol

上述参考代码写的并不好，分析如下：

1. **端口声明**风格过时：上述代码中是旧式 Verilog-1995 风格的**端口声明**方式，不建议再使用。
2. 最好使用 Verilog-2001 风格：即将**类型**和**宽度**统一写在**模块定义（模块头）**中，更清晰。如下：

```verilog
module counter (
	input cp,
	output reg [3:0] dataout
);
```

- `reg` 是**存储类型**，而 `output` 是**方向声明**，不要重复声明，不清晰。

此外，上述代码也缺乏复位逻辑（reset）。在实际设计中，计数器通常应该包含复位信号，以便**初始化**或**异步清零**。否位，在仿真或综合工具中，初始值可能为X，导致行为不确定。

最后，注释也过于简单，虽然简洁，但缺乏上下文。

综上所述，可以改为：

```verilog
module counter (
    input cp,
    input rst,                  // 异步复位
    output reg [3:0] dataout;
);

always @(posedge cp or posedge rst) begin
    if (rst)
        dataout <= 4'd0;        // 复位清零
    else
        dataout <= dataout + 1; // 每个时钟周期加1
end

endmodule
```

#### 4.9

![](assets/Pasted%20image%2020250609191507.png)

#### 4.10

![](assets/Pasted%20image%2020250609191528.png)

#### 5.5 D触发器 & JK触发器 & T触发器

![](assets/Pasted%20image%2020250609192127.png)

![](assets/Pasted%20image%2020250609192152.png)

![](assets/Pasted%20image%2020250609192211.png)

#### 24mid

下图给出了一个组合逻辑电路的真值表，该电路有3个输入信号，3个输出信号，请用 Verilog HDL 语言描述该组合逻辑电路真值表，该模块名称为 Decode。

| A   | B   | C   | F1  | F2  |
| --- | --- | --- | --- | --- |
| 0   | 0   | 0   | 1   | 1   |
| 0   | 0   | 1   | 1   | 0   |
| 0   | 1   | 0   | 0   | 0   |
| 0   | 1   | 1   | 1   | 0   |
| 1   | 0   | 0   | 0   | 1   |
| 1   | 0   | 1   | 0   | 1   |
| 1   | 1   | 0   | 1   | 1   |
| 1   | 1   | 1   | 1   | 0   |
##### key (chatgpt)

```verilog
module Decode (
    input wire A,
    input wire B,
    input wire C,
    output reg F1,
    output reg F2
);

    // Combinational logic described using a case statement
    always @(*) begin
        case ({A, B, C}) // Concatenate inputs into a 3-bit vector
            3'b000: begin F1 = 1; F2 = 1; end
            3'b001: begin F1 = 1; F2 = 0; end
            3'b010: begin F1 = 0; F2 = 0; end
            3'b011: begin F1 = 1; F2 = 0; end
            3'b100: begin F1 = 0; F2 = 1; end
            3'b101: begin F1 = 0; F2 = 1; end
            3'b110: begin F1 = 1; F2 = 1; end
            3'b111: begin F1 = 1; F2 = 0; end
            default: begin F1 = 0; F2 = 0; end // Default case (shouldn't occur)
        endcase
    end

endmodule
```

---

```verilog
module Decode (
    input wire A,
    input wire B,
    input wire C,
    output wire F1,
    output wire F2
);

    // F1 = (~A & ~B) | (~A & C) | (A & B)
    assign F1 = (~A & ~B) | (~A & C) | (A & B);

    // F2 = (~B & ~C) | (A & ~B) | (A & ~C)
    assign F2 = (~B & ~C) | (A & ~B) | (A & ~C);

endmodule
```

#### 分析题 1

> 阅读下列 Verilog 代码，找出其中的**语法**和**逻辑**错误，并说明该模块的**设计意图（逻辑功能）**。

```verilog
module demux1_4(n_en, D, X, Y)
intput n_en, D;
output Y;
reg [3:0] Y;
always @(n_en or D or X)
    if (~n_en)
        case(X)
            2`b00: Y[0] = D;
            2`b01: Y[1] = D;
            2`b10: Y[2] = D;
            2`b11: Y[3] = D;
        endcase
    else 
        Y = 4`b0000;
endmoudule
```

##### key (chatgpt)

###### 一、语法错误分析（共 **6** 处）

1. **拼写错误**
    
    ```verilog
    intput n_en, D;
    ```
    
    应为：
    
    ```verilog
    input n_en, D;
    ```
    
2. **缺少对输入信号 `X` 的声明**
    
    `X` 出现在 `case(X)` 中，但未声明，应添加：
    
    ```verilog
    input [1:0] X;
    ```
    
3. **`output Y;` 和 `reg [3:0] Y;` 冲突**
    
    正确的声明方式为：
    
    ```verilog
    output reg [3:0] Y;
    ```
    
4. **位宽表示语法错误**
    
    ```verilog
    2`b00, 4`b0000
    ```
    
    应为：
    
    ```verilog
    2'b00, 4'b0000
    ```
    
5. **缺少 `begin`/`end`**
    
    `always` 块中使用 `if` 和 `case` 的组合时应加 `begin...end` 来明确范围。
    
6. **模块结束关键字拼写错误**
    
    ```verilog
    endmoudule
    ```
    
    应为：
    
    ```verilog
    endmodule
    ```

###### 二、逻辑问题分析（2 点）

1. **部分赋值可能导致未定义行为**
    
    在 `case` 中只对 `Y[X]` 位赋值，其它位保持旧值，可能导致综合器发出告警或产生锁存器。应在进入 `case` 前清零：
    
    ```verilog
    Y = 4'b0000;
    ```
    
2. **没有 `default` 分支**
    
    虽然 `X` 是 2 位，理论上只有 4 种取值，但建议补上 `default` 分支以防综合器行为不确定。
    

---

###### 三、模块逻辑功能说明

该模块是一个 **1-to-4 解复用器（Demux）**，输入为 `D`，控制信号为 `X[1:0]`，使能信号为 `n_en`（低电平有效）。当 `n_en == 0` 时，`D` 的值被送到 `Y` 的某一个位（由 `X` 指定）；其余位为 0。当 `n_en == 1` 时，`Y` 全部清零。

---

###### 四、修改后的参考代码

```verilog
module demux1_4(
    input n_en,
    input D,
    input [1:0] X,
    output reg [3:0] Y
);
    always @(n_en or D or X) begin
        if (~n_en) begin
            Y = 4'b0000;
            case (X)
                2'b00: Y[0] = D;
                2'b01: Y[1] = D;
                2'b10: Y[2] = D;
                2'b11: Y[3] = D;
                default: Y = 4'b0000;
            endcase
        end else begin
            Y = 4'b0000;
        end
    end
endmodule
```

#### 3.9

![](assets/Pasted%20image%2020250609190345.png)

#### 3.11

![](assets/Pasted%20image%2020250609191107.png)

### 8. (10') 原始状态图 / 原始状态表



### 9. (20') SL

#### Verilog

- Verilog HDL 模块的3种建模方式
	1. 结构（电路结构；逻辑门例化）
	2. 数据流（逻辑表达式）
	3. 行为（电路行为）

##### 结构

```verilog
module composite(
	input A, B, C, D,
	output F
);

wire notA = ~A;
wire notC = ~C;
wire notD = ~D;

wire w1, w2, w3;

and u1(w1, notA, B, D);
and u2(w2, A, B, notC, notD);
and u3(w3, notA, B, C, D);
or  u4(F, w1, w2, w3);

endmodule
```

##### 数据流

```verilog
module composite(
	input A, B, C, D,
	output F
);

assign F = (A & (~B) & D) | (A & B & (~C) & (~D)) | ((~A) & B & C & D);

endmodule
```

下面这样做在组合逻辑中不是错误，但略显啰嗦。使用上面的 `assign` 更清晰简洁。

```verilog
module composite (
    input A, B, C, D,
    output reg F
);

always @(*) begin
    F = (A & (~B) & D) | (A & B & (~C) & (~D)) | ((~A) & B & C & D);
end

endmodule
```

##### 行为

```verilog
module composite(
	input A, B, C, D,
	output reg F
);

always @(*) begin
	case({A, B, C, D})
		4'b0111: F = 1;
		4'b1001: F = 1;
		4'b1011: F = 1;
		4'b1100: F = 1;
		default: F = 0;
	endcase
end

endmodule
```

---

```verilog
module composite(
	input A, B, C, D,
	output reg F
);

always @(*) begin
	case ({A, B, C, D})
		4'b0111,
		4'b1001,
		4'b1011,
		4'b1100: F = 1;
		default: F = 0;
	endcase
end

endmodule
```

---

```verilog
module composite(
	input A, B, C, D,
	output F
);

assign F = ({A, B, C, D} == 4'b0111) |
           ({A, B, C, D} == 4'b1001) |
           ({A, B, C, D} == 4'b1011) |
           ({A, B, C, D} == 4'b1100);

endmodule
```

---

```verilog
module composite(
	input A, B, C, D,
	output F
);

wire [3:0] in = {A, B, C, D};
assign F = (in == 4'b0111) || (in == 4'b1001) || (in == 4'b1011) || (in == 4'b1100);

endmodule
```




