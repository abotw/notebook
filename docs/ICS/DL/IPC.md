---
aliases:
  - IPC
  - Intellectual Property Core
  - IP核
  - 知识产权核
date: 2025-05-08T17:16:00
---
# IP核

**“IP核”是“Intellectual Property Core”（知识产权核）的简称**，在数字集成电路设计和FPGA/ASIC开发中非常常见。简单来说，**IP核是一段可以重复使用的模块化设计单元**，通常由某种硬件描述语言（如 Verilog 或 VHDL）编写。它实现了某种功能，比如加法器、FIFO、UART控制器、以太网控制器，甚至完整的CPU核心。

---

## IP核的常见类型

1. **软核（Soft IP Core）**
    
    - 用 HDL（如 Verilog）编写，可综合。
        
    - 优点：可移植、可定制。
        
    - 示例：一个 Verilog 写的 SPI 控制器模块。
        
2. **硬核（Hard IP Core）**
    
    - 已经布图、固定在某种工艺上的电路块。
        
    - 优点：性能高、面积小、功耗低。
        
    - 示例：ARM Cortex-A 核心在某些 SoC 中就是硬核。
        
3. **固核（Firm IP Core）**
    
    - 介于软核和硬核之间，通常是针对某种特定工艺优化后的 RTL 和布局建议。
        

---

## 使用IP核的场景

- 在 **FPGA 开发** 中，很多厂商（如 Xilinx、Intel/Altera）提供 IP 核库，可以直接拖拽使用。例如：AXI 总线控制器、PLL、电机驱动器等。
    
- 在 **ASIC 设计** 中，芯片设计公司会购买第三方提供的 IP 核，比如购买 ARM 核来构建手机 SoC。
    

---

假设你正在用 Vivado 开发一个 FPGA 项目，需要实现一个 UART 串口通信模块。你可以：

- 自己写 Verilog 来实现（比较复杂）
    
- 或者直接调用 Vivado 的 UART IP核，配置波特率等参数，生成 RTL，然后集成进你的设计中。
    
