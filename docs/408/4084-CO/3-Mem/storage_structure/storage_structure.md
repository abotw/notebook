# Storage Structure, 存储结构

## Storage Structure 1

- Storage systems organized in hierarchy, 存储系统结构化组织
	- speed, 速度
	- cost, 成本
	- ==volatility==

![[Pasted image 20240409141655.png]]
- registers, 寄存器
- cache, 缓存
- main memory, 主存储器
- solid-state disk, 固态硬盘
- hard disk, 硬盘
- optical disk, 光盘
- magnetic tapes, 磁带

## Main Memory, 主存储器

- CPU can load instructions only from memory (only ==large storage media== that the CPU can access directly)
- Random access, typically small size and ==volatile==
- All forms of memory provide an array of bytes
	- Each byte has its own address
	- Interaction: load & store (memory <-> register)

## Instruction-execution cycle

- Fetch an instruction from memory and store in register
- Decode instruction (fetch operands if necessary)
- Store result back to memory

## Secondary storage, 

## Caching, 缓存

• Caching – copying information into faster storage system; main memory can be viewed as a cache for secondary storage • Faster storage (cache) checked first to determine if information is there – If it is, information used directly from the cache (fast) – If not, data copied to cache and used there • Cache smaller than storage being cached – Cache management important design problem – Cache size and replacement policy • Important principle, performed at many levels in a computer (in hardware, operating system, software)

## I/O Structure

• Storage is only one of many types of I/O devices • Device controller – More than one device may be attached – Local buffer storage & a set of registers • Device driver: for each device controller to manage I/O, provides uniform interface between controller and kernel • Interrupt-driven I/O – Device driver loads registers within the controller – Controller examines the registers to decide what action to take – Device controller starts data transfer to its local buffer – Informs driver via an interrupt and returns control to OS

## Direct Memory Access Structure

• Used for high-speed I/O devices able to transmit information at close to memory speeds • Device controller transfers blocks of data from buffer storage directly to main memory without CPU intervention • Only one interrupt is generated per block, rather than the one interrupt per byte
