---
date: 2025-05-06T09:34:00
tags:
  - 计数器
  - verilog
  - counter
---

# Verilog: 4-bit Sync Counter

> 设计一个**4位二进制同步计数器**的 Verilog HDL 模型。  
> 要求如下：
> 
> 1. 模块名： `counter` 
> 2. 输入：时钟 `CP`（上升沿有效）、同步清零信号 `clr`（高电平有效） 
> 3. 输出：4 位 `dataout`
> 4. 功能：每个时钟上升沿 `dataout` 加 1；若 `clr` 为高，则在时钟上升沿清零。     

## sol

```verilog
module counter (
    input wire CP,         // 时钟信号（上升沿有效）
    input wire clr,        // 同步清零信号（高电平有效）
    output reg [3:0] dataout  // 4位输出
);

	always @(posedge CP) begin
	    if (clr)
	        dataout <= 4'b0000;         // 同步清零
	    else
	        dataout <= dataout + 1'b1;  // 加1计数
	end

endmodule
```
