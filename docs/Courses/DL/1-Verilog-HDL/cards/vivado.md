# Vivado

Vivado 是 Xilinx（现为 AMD 收购）推出的一款**FPGA 设计工具集**，主要用于基于 Xilinx FPGA 和 SoC（如 Zynq）的开发。它是 ISE 的升级版，支持更现代的设计流程，尤其是 **基于 IP 和模块化的设计方式**。

---

## Vivado 的核心功能

1. **RTL 设计与仿真**
    
    - 支持 Verilog、VHDL 的综合（Synthesis）和实现（Implementation）
        
    - 提供内置的仿真工具（XSim）
        
2. **IP Integrator（IP核集成）**
    
    - 可视化地拖拽连接 IP 核，快速构建复杂系统（如 AXI 总线）
        
3. **时序分析与约束管理**
    
    - 使用 XDC 约束文件进行时钟、引脚等设置
        
    - 提供强大的静态时序分析工具
        
4. **硬件调试与分析**
    
    - 支持逻辑分析仪（ILA）、虚拟IO等调试功能
        
5. **比特流生成（bitstream）与烧录**
    
    - 最终生成 `.bit` 文件用于烧写到 FPGA 上
        

---

## Vivado 使用流程简要图

1. **新建工程** →
    
2. **添加设计文件（Verilog/VHDL）** →
    
3. **添加 IP 核（可选）** →
    
4. **综合（Synthesis）** →
    
5. **实现（Implementation）** →
    
6. **生成比特流（Bitstream）** →
    
7. **下载到 FPGA（硬件调试）**
    

---

Vivado 特别适合基于 **Zynq 系列 SoC** 的开发，因为它可以和 **Vitis（软件开发工具）** 联合使用，支持软硬件协同开发。
