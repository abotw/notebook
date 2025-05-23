---
aliases:
  - XDC
  - Xilinx Design Constraints
---

Xilinx 的约束文件，用来指定**引脚映射**、**I/O 电平标准**等  
比如 `set_property PACKAGE_PIN R6 [get_ports {A[0]}]` 把 `A[0]` 信号连到 FPGA 板上的 `R6` 引脚。