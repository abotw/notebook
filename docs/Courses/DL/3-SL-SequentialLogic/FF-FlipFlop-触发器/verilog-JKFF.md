
# J-K FF Verilog

> 使用 Verilog HDL 语言，描述一个**在时钟下降沿触发的 J-K 触发器**模块，并给出完整的代码实现。

## sol

```verilog
// Module: JK_FF
// Description: Negative edge-triggered JK flip-flop

module JK_FF (
    input wire clk,      // Clock signal
    input wire rst_n,    // Asynchronous active-low reset
    input wire J,        // J input
    input wire K,        // K input
    output reg Q,        // Output Q
    output reg Q_n       // Output Q_n
);

    // Asynchronous reset, negative edge triggered JK flip-flop
    always @(negedge clk or negedge rst_n) begin
        if (!rst_n)
            Q <= 1'b0;                      // Reset Q to 0
        else begin
            case ({J, K})
                2'b00: Q <= Q;              // No change
                2'b01: Q <= 1'b0;           // Reset
                2'b10: Q <= 1'b1;           // Set
                2'b11: Q <= ~Q;             // Toggle
                default: Q <= Q;
            endcase
        end
    end

endmodule
```

- 使用 `negedge clk` 实现**下降沿触发**。
    
- 包含**异步低电平复位**（`rst_n`），方便仿真与实际电路中初始化。
    
- 采用 `case` 结构清晰表达 J-K 触发器的逻辑功能。

## sol-cjn

```verilog
module JKff_2(clk, j, k, q, n_q);
    input clk, j, k;
    output q, n_q;
    reg q, n_q;

    always @ (negedge clk)
        case ({j, k})
            2'b00 : q <= q;
            2'b01 : q <= 0;
            2'b10 : q <= 1;
            2'b11 : q <= ~q;
            default: q <= q;
        endcase
endmodule
```
