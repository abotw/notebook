
# Summary

1. 仔细读题，细心计算，验算。
2. 铅笔画图。

---

1. Intro
2. Num
	1. 表示
		1. 原补反移
		2. 定点浮点
	2. 运算
		1. 原码乘除
		2. 浮点加减
3. Storage
	1. Mem2CPU
4. ISA
	1. 寻址方式
	2. 指令格式
5. CPU
	1. 指令周期
	2. 微操作命令 / 控制信号 / 节拍安排
6. IO
	1. 控制方式（查询、中断、DMA）
7. Bus
	1. 通信控制（同步、异步、仲裁）

## 宿宁 | 25Sp | Final

1. **(30') 分析简答题** \[[宿宁25-分析题](Misc/宿宁25-分析题/宿宁25-分析题-LaTex.pdf)\] \[[sol](Misc/宿宁25-分析题/宿宁25-分析题-sol.pdf)\]
	1. (6') 什么是计算机系统、计算机硬件和计算机软件？硬件和软件哪个更重要？
	   \[[p1.1-tang3-p19](1-Intro/psets/p1.1-tang3-p19-计算机系统/p1.1-tang3-p19-计算机系统.md)\]
	2. (6') 画图说明异步通信中请求与回答有哪几种互锁关系。(p61-p62)
	   \[[p3.7-tang3-p66](7-Bus/psets/p3.7-tang3-p66-异步通信/p3.7-tang3-p66-异步通信.md)\]
	3. (6') [4.3.1 Cache Metrics](3-Storage/2-Cache/1-CacheMatrics/cache-metrics.md)
	   \[[CacheMetrics-tang3.pdf](3-Storage/2-Cache/1-CacheMatrics/assets/CacheMetrics-tang3.pdf)\]
		1. [e4.7-tang3-p111](3-Storage/2-Cache/1-CacheMatrics/psets/e4.7-tang3-p111/e4.7-tang3-p111.md)
		2. [e4.10-tang3-p121](3-Storage/2-Cache/1-CacheMatrics/psets/e4.10-tang3-p121/e4.10-tang3-p121.md)
		3. [e4.6-tang2psets-p52](3-Storage/2-Cache/1-CacheMatrics/psets/e4.6-tang2psets-p52/e4.6-tang2psets-p52.md)
		4. [e4.12-tang2psets-p54](3-Storage/2-Cache/1-CacheMatrics/psets/e4.12-tang2psets-p54/e4.12-tang2psets-p54.md)
		5. **[e4.13-tang2psets-p54](3-Storage/2-Cache/1-CacheMatrics/psets/e4.13-tang2psets-p54/e4.13-tang2psets-p54.md)**
	4. (6') I/O设备与主机交换信息时，共有哪几种控制方式？简述它们的特点。
	   \[[p5.3-tang3-p210](6-IO/psets/p5.3-tang3-p210-IO控制方式/p5.3-tang3-p210-IO控制方式.md)\]
	5. (6') 画出指令周期的流程图，分别说明图中每个子周期的作用。
	   \[[p8.3-tang3-p370](4-ISA/指令周期/psets/p8.3-tang3-p370-指令周期/p8.3-tang3-p370-指令周期.md)\]
	   \[[InstructionCycle-tang3.pdf](4-ISA/指令周期/assets/InstructionCycle-tang3.pdf)\]
2. **(30') 计算题**
	1. (10', AB) 4.2.6 存储器的校验（汉明码） **
	   \[[worksheet](3-Storage/1-Mem/2-HammingCode/assets/hamming-code-worksheet.pdf)\]
	   \[[Hamming-tang3.pdf](3-Storage/1-Mem/2-HammingCode/assets/Hamming-tang3.pdf)\]
		1. (5') [e4.4-tang3-p102](3-Storage/1-Mem/2-HammingCode/psets/e4.4-tang3-p102/e4.4-tang3-p102.md) (检错、纠错)
		2. (5') [e4.5-tang3-p102](3-Storage/1-Mem/2-HammingCode/psets/e4.5-tang3-p102/e4.5-tang3-p102.md) (配奇、配偶)
	2. (10', AB) 6.2.3 数的定点表示和浮点表示 **
	   \[[worksheet](../../Courses/ICS/3-NumSys/2-定浮表示/psets/assets/float-worksheet.pdf)\]
	   \[[FixFloatNum-tang3.pdf](../../Courses/ICS/3-NumSys/2-定浮表示/assets/FixFloatNum-tang3.pdf)\]
		1. [e6.3-tang3-p231](../../Courses/ICS/3-NumSys/2-定浮表示/psets/e6.3-tang3-p231/e6.3-tang3-p231.md)
		2. [e6.4-tang3-p232](../../Courses/ICS/3-NumSys/2-定浮表示/psets/e6.4-tang3-p232/e6.4-tang3-p232.md)
		3. [e6.5-tang3-p232](../../Courses/ICS/3-NumSys/2-定浮表示/psets/e6.5-tang3-p232/e6.5-tang3-p232.md)
	3. (10', AB) 6.3.4 定点除法运算 / 原码一位除（加减交替法） **
	   \[[worksheet](2-Num/1-定点运算/定点除法/assets/定点除法-worksheet.pdf)\]
	   \[[Div-tang3.pdf](2-Num/1-定点运算/定点除法/assets/Div-tang3.pdf)\]
		1. [e6.25-tang3-p261](2-Num/1-定点运算/定点除法/psets/e6.25-tang3-p261-加减交替法/e6.25-tang3-p261-加减交替法.md)
	4. (10', B) [6.4.1 浮点加减运算 ](2-Num/2-浮点运算/浮点加减/浮点加减.md) **
	   \[[worksheet](2-Num/2-浮点运算/浮点加减/assets/浮点加减-worksheet.pdf)\]
	   \[[FloatAddSub-tang3](2-Num/2-浮点运算/浮点加减/assets/FloatAddSub-tang3.pdf)\]
		1. [e6.29-tang3-p271](2-Num/2-浮点运算/浮点加减/psets/e6.29-tang3-p271/e6.29-tang3-p271.md)
		2. [e6.30-tang3-p272](2-Num/2-浮点运算/浮点加减/psets/e6.30-tang3-p272/e6.30-tang3-p272.md)
		3. [e6.31-tang3-p274](2-Num/2-浮点运算/浮点加减/psets/e6.31-tang3-p274/e6.31-tang3-p274.md)
		4. [e6.32-tang3-p274](2-Num/2-浮点运算/浮点加减/psets/e6.32-tang3-p274/e6.32-tang3-p274.md)
3. **(40') 综合应用题**
	1. (10', AB) [4.2.5 存储器(芯片)与CPU的连接](3-Storage/1-Mem/1-Mem2CPU/mem2cpu.md) *
	   \[[Mem2CPU-tang3.pdf](3-Storage/1-Mem/1-Mem2CPU/assets/Mem2CPU-tang3.pdf)\]
		1. [e4.1-tang3-p94](3-Storage/1-Mem/1-Mem2CPU/psets/e4.1-tang3-p94/e4.1-tang3-p94.md)
		2. [e4.2-tang3-p95](3-Storage/1-Mem/1-Mem2CPU/psets/e4.2-tang3-p95/e4.2-tang3-p95.md)
		3. [11-12-2A-5.1](3-Storage/1-Mem/1-Mem2CPU/psets/11-12-2A-5.1/11-12-2A-5.1.md)
		4. [15-16-1B-5.1](3-Storage/1-Mem/1-Mem2CPU/psets/15-16-1B-5.1/15-16-1B-5.1.md)
	2. (10', AB) [4.3.2 Cache—主存地址映射](3-Storage/2-Cache/2-Cache2Mem/cache2mem.md) *
	   \[[Cache2Mem-tang3.pdf](3-Storage/2-Cache/2-Cache2Mem/assets/Cache2Mem-tang3.pdf)\]
		1. [e4.8-tang3-p120](3-Storage/2-Cache/2-Cache2Mem/psets/e4.8-tang3-p120/e4.8-tang3-p120.md)
		2. [e4.9-tang3-p120](3-Storage/2-Cache/2-Cache2Mem/psets/e4.9-tang3-p120/e4.9-tang3-p120.md)
		3. [e4.11-tang3-p121](3-Storage/2-Cache/2-Cache2Mem/psets/e4.11-tang3-p121/e4.11-tang3-p121.md)
	3. (10', AB) 7.4.3 指令格式设计
	   \[[InstructionFormatDesing-tang3.pdf](4-ISA/指令格式设计/assets/InstructionFormatDesing-tang3.pdf)\]
		1. [e7.4-tang3-p322](4-ISA/指令格式设计/psets/e7.4-tang3-p322/e7.4-tang3-p322.md)
		2. [e7.5-tang3-p323](4-ISA/指令格式设计/psets/e7.5-tang3-p323/e7.5-tang3-p323.md)
		3. [e7.6-tang3-p324](4-ISA/指令格式设计/psets/e7.6-tang3-p324/e7.6-tang3-p324.md)
		4. [e7.7-tang3-p325](4-ISA/指令格式设计/psets/e7.7-tang3-p325/e7.7-tang3-p325.md)
	4. (10', AB) 8.4.6 中断屏蔽技术 *
	   \[[InterruptShielding-tang3.pdf](5-CPU/1-中断屏蔽技术/assets/InterruptShielding-tang3.pdf)\]
		1. [e8.2-tang3-p368](5-CPU/1-中断屏蔽技术/psets/e8.2-tang3-p368/e8.2-tang3-p368.md) (4', 屏蔽字; 6', CPU执行程序轨迹)
	5. (10', AB) Part 4. 控制单元 *
		1. [e9.1-tang3-p382-微操作](5-CPU/2-CU/psets/e9.1-tang3-p382-微操作/e9.1-tang3-p382-微操作.md)
		2. [e9.2-tang3-p383-控制信号](5-CPU/2-CU/psets/e9.2-tang3-p383-控制信号/e9.2-tang3-p383-控制信号.md)
		3. [e9.3-tang3-p387](5-CPU/2-CU/psets/e9.3-tang3-p387/e9.3-tang3-p387.md)
		4. [e10.1-tang3-p398-节拍安排](5-CPU/2-CU/psets/e10.1-tang3-p398-节拍/e10.1-tang3-p398.md)
		5. [e10.2-tang3-p399-节拍安排](5-CPU/2-CU/psets/e10.2-tang3-p399-节拍/e10.2-tang3-p399.md)
		6. [11-12-2A-5.2](5-CPU/2-CU/psets/11-12-2A-5.2/11-12-2A-5.2.md)
		7. [15-16-1B-5.3](5-CPU/2-CU/psets/15-16-1B-5.3/15-16-1B-5.3.md)

---

![](5-CPU/1-中断屏蔽技术/assets/CPU执行程序轨迹.drawio.svg)



