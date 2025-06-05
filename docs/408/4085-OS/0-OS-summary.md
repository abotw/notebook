
# Summary

## PS: CPU/process scheduling | 调度算法

- worksheet \[[pdf](2-PS/2-Scheduling/psets/assets/CPU-scheduling-p.pdf)\] \[[docx](2-PS/2-Scheduling/psets/assets/CPU-scheduling.docx)\]

---

- [https://os.seofernando.com/tools/scheduling](https://os.seofernando.com/tools/scheduling)
- [http://aadhil2k4.github.io/Process_Scheduling_Calculator/](http://aadhil2k4.github.io/Process_Scheduling_Calculator/)
- [http://cpuburst.com/ganttcharts.html](http://cpuburst.com/ganttcharts.html)

## PS: semaphore | 信号量

## PS: banker's algorithm | 银行家算法

- worksheet \[[pdf](2-PS/5-Deadlock/psets/assets/banker-tables-54-p.pdf)\]  \[[docx](2-PS/5-Deadlock/psets/assets/banker-tables-54.docx)\] 

## Mem: page replacement | 页面置换算法

- worksheet \[[pdf](3-Mem/psets/P3-PageReplacement/assets/page-replacement-tables-p.pdf)\]

---

- [page-replacement-JC25-OS.pdf](3-Mem/psets/P3-PageReplacement/assets/page-replacement-JC25-OS.pdf)
- [https://os.seofernando.com/tools/page-replacement](https://os.seofernando.com/tools/page-replacement)
- [https://hansalshah007.github.io/osvirtuallab/pagereplacement_index.html](https://hansalshah007.github.io/osvirtuallab/pagereplacement_index.html)
- [https://page-replacement.fun/](https://page-replacement.fun/)
- [https://os.seofernando.com/tools/page-replacement](https://os.seofernando.com/tools/page-replacement)

## FS: inode & file size & bock visits

## IO: disk scheduling | 磁盘调度算法

- worksheet \[[pdf](5-IO/1-Disk/psets/P1-DiskScheduling/assets/disk-scheduling-tables-p.pdf)\]

---

- [https://hansalshah007.github.io/osvirtuallab/diskscheduling_index.html](https://hansalshah007.github.io/osvirtuallab/diskscheduling_index.html)
- [https://disk-scheduling-algorithms-visualizer.netlify.app/](https://disk-scheduling-algorithms-visualizer.netlify.app/)
- [https://khushalip.github.io/OS-lab/diskAlgo/disk.html](https://khushalip.github.io/OS-lab/diskAlgo/disk.html)
- [https://www.algorithmroom.com/calculator/disk-scheduling](https://www.algorithmroom.com/calculator/disk-scheduling)

## 张召霞 | 25Sp | Final

1. **(17') 简答**
	1. (4') 在创建一个进程时，OS 需要完成的主要工作是什么？
	2. (4') 若信号量的初值为 2，当前值为 -1，则表示有多少个等待进程？请分析。
	3. (4') 为什么说分段系统较分页系统更易实现信息共享与保护？
	4. (5') 设备中断处理程序通常须完成哪些工作？它对中断进行处理的过程包含哪些步骤？
2. **(19') 算法**
	1. (5') Precedence Graph | 前驱图
	2. (14') [Banker's Algorithm](2-PS/5-Deadlock/psets/P1-bankers-algorithm.md)
3. **(32') 计算**
	1. (12') Memory Address Translation
		1. **[paging](3-Mem/psets/P-Paging/P-Paging.md)**
		2. [segmentation](3-Mem/psets/P-Segmentation/P-Segmentation.md)
	2. (12') [Page Replacement ](3-Mem/psets/P3-PageReplacement/P3-PageReplacement.md)
		1. Keys
			1. (3') a series of referenced page numbers
			2. (3') Page Faults / Page Fault Rate
		2. Algo.
			1. **(6')** $FIFO\text{↘}$ (Fist-In-First-Out, 先进先出) - **oldest**
			2. (6') $\overset{\rightarrow}{\text{OPT}}$ (MIN, Optimal, 最佳) - not used for the longest time in **future**
			3. **(6')** $\overset{\leftarrow}{\text{LRU}}$ (Least Recently Used, 最近最久未使用) - not used for the longest time in **past**
	3. (8') [FS](4-FS/psets/P2-混合索引分配的计算/P2-混合索引分配的计算.md)
		1. **(4') direct**
		2. **(4') max file size**
		3. (4') disk visits
4. **(32') 综合**
	1. (10') [PV](2-PS/4-Sync/2-SyncPsets/pv.md) - 父母儿女吃水果
	2. (10') [CPU Scheduling](2-PS/2-Scheduling/psets/psets-cpu-scheduling.md)
		1. Keys
			1. (2') **调度顺序**
			2. (2') **指标：AWTT, 平均带权周转时间** (arrival -> waiting -> start -> burst -> end)
				1. 周转时间 (Turnaround Time)：$TT= Finish - Arrival$
				2. 带权周转时间 (Weighted Turnaround Time)：$WTT = \frac{TT}{\text{Burst}}$
				3. 平均带权周转时间 (Average Weighted Turnaround Time)：$AWTT = \frac{ATT}{N_p}$
				4. 等待时间 (Waiting Time): $WT=Start-Arrival$
		2. Algo.
			1. FCFS (First-Come First-Served, 先来先服务) - arrival time
			2. **SJF (Shortest Job First, 最短运行时间优先)** - burst time
			3. STCF (Shortest Time-to-Completion First, 最短剩余时间优先, = **SJF-P**) - remaining burst time
			4. RR (Round Robin, 时间片轮转) - quantum / time slice
			5. Priority (优先级) - priority
	3. (12') [Disk Scheduling ](5-IO/1-Disk/psets/P1-DiskScheduling/P1-disk-scheduling.md)
		1. Keys
			1. (3') sequence of seeks
			2. (3') movements
		2. Algo.
			1. **(6') FCFS (First Come First Service)**
			2. (6') SSTF (Shortest Seek Time First)
			3. (6') SCAN
			4. (6') CSCAN
			5. **(6') LOOK**
			6. (6') CLOOK