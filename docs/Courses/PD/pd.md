---
date: 2025-06-11T08:39:00
---

## PD | Program Design | 程序设计

程序设计可分为下面6个部分：

1. 基础程序设计（Basic Program Design: Grammar）
	1. 基本：常量、变量（作用域）、数据类型、赋值、操作符、表达式、类型转换、位运算
	2. 控制
		1. 选择 (if-else-if, switch)
		2. 循环 (while, do-while, for, foreach)
		3. 异常处理 (try-catch-finally)
			1. 异常捕获与抛出
			2. 自定义异常类
	3. 抽象
		1. 内存抽象：内存模型（栈、堆、指针）
		2. 数据抽象（数据结构抽象）
			1. 字符串（对**字符集合**的抽象）
			2. 数组（对**更一般数据集合**的抽象）
			3. 自定义数据类型（`struct`）
		3. 过程抽象：函数/方法（既是**抽象**，又是**封装**）
	4. 递归
	5. IO
		1. 流模型（顺序访问的数据通道）
		2. 标准输入输出（如：`cin/cout`、`scanf/printf`、`System.in/out`）
		3. 文件读写（文本 vs 二进制）
2. 面对对象程序设计（Object-Oriented Programming, OOP）（灵活性、模块化 -> 可重用性）（过程抽象 -> 模型抽象）
	1. 三大特性（封装、继承、多态）
		1. 封装（具体 -> 抽象）
			1. 对象（状态 + 行为）
			2. 类（生命周期：构造、析构函数）
		2. 继承
		3. 多态（重载、重写）
			1. 方法重载（Overload）
			2. 方法重写（Override）
	2. 抽象类；接口（继承、多态）
3. 图形用户界面设计（Graphical User Interface, GUI）
	1. 事件驱动模型：程序逻辑由用户或系统事件触发执行
	2. **布局**
	3. **控件**：按钮、输入框、列表框、窗口
	4. **框架**（Java Swing / Java FX / Tkinter / Qt）
4. 高级程序设计（Advanced Programming Topics）
	1. 并发设计
		1. **线程**创建与管理
		2. 同步机制（**锁、互斥**）
	2. 数据库设计：SQLite（Python）、MySQL（Java JDBC）
	3. 网络通信
		1. Socket 通信
		2. C/S模型
	4. Web设计
		1. 前后端交互（HTTP、REST API）
		2. Web 框架（Spring Boot、Flask）
5. 软件工程基础（Software Engineering Basics）
	1. 项目开发流程（需求分析、设计、编码、测试、部署）
	2. 模块化与复用
	3. 风格规范：代码、注释、文档
	4. 代码管理：版本控制（Git）与协作（GitHub、Issue）
	5. 测试：单元测试与调试（Test、Debug）
6. 综合应用与项目实战（Practical Projects & Integration）
	1. 简单项目（命令行工具、Todo 应用）
	2. 中级项目（信息管理系统、聊天室）
	3. 高级项目（Web 后台管理系统）

