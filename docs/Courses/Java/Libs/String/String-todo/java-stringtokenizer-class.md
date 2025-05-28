# Java 中的 StringTokenizer 类解析（StringTokenizer Class）

## 一、概述与考纲定位

`StringTokenizer` 是 Java 提供的**字符串分词工具类（String Tokenizing Utility Class）**，用于按照指定分隔符将字符串分割为多个标记（token）。虽然 Java 语言在 408 考研中非核心考点，但**字符串解析、分割与处理是程序设计基础的重要体现**，涉及**字符串处理算法、数据结构（如队列、栈）及状态自动机建模等知识点**，具有较高的间接考查价值。

------

## 二、StringTokenizer 类的基本特性

### 1. 类定义与构造方法

```java
public class StringTokenizer extends Object implements Enumeration<Object>
```

-   位于 `java.util` 包中
-   实现了**枚举接口（Enumeration Interface）**，可使用 `hasMoreTokens()` 和 `nextToken()` 方法进行迭代

### 2. 常用构造方法

```java
StringTokenizer st = new StringTokenizer(String str);
StringTokenizer st = new StringTokenizer(String str, String delim);
StringTokenizer st = new StringTokenizer(String str, String delim, boolean returnDelims);
```

参数说明：

-   `str`：待分割的原始字符串
-   `delim`：分隔符（delimiter），默认是空格 `" "`
-   `returnDelims`：是否将分隔符作为 token 返回（默认为 false）

------

## 三、常用方法速览

| 方法                                  | 功能                             |
| ------------------------------------- | -------------------------------- |
| `hasMoreTokens()`                     | 是否还有更多标记                 |
| `nextToken()`                         | 返回下一个标记                   |
| `countTokens()`                       | 返回剩余标记数                   |
| `hasMoreElements()` / `nextElement()` | 与枚举接口一致，用于通用集合遍历 |

------

## 四、经典例题与解析

### 例题1：【基本分词操作】

```java
String str = "CS408 Java C++ OS";
StringTokenizer st = new StringTokenizer(str);
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
// 输出：CS408 → Java → C++ → OS
```

**考点意义：**

-   考查默认分隔符（空格）
-   强调与 `split()` 方法的区别：`split()` 返回数组，而 `StringTokenizer` 提供更灵活的迭代机制，内存占用更少。

------

### 例题2：【自定义分隔符】

```java
String data = "id=123&name=tom&score=98";
StringTokenizer st = new StringTokenizer(data, "&=");
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
// 输出：id → 123 → name → tom → score → 98
```

**考点意义：**

-   分隔符可以为多个字符集合（非单一字符）
-   该结构在**解析 URL 参数、配置文件、命令行输入**等场景中广泛应用

------

## 五、与其他字符串分割方式的比较

| 分割方式                     | 返回类型            | 是否支持正则 | 性能             | 灵活性           |
| ---------------------------- | ------------------- | ------------ | ---------------- | ---------------- |
| `StringTokenizer`            | 枚举（Enumeration） | 否           | 高               | 中（不支持正则） |
| `String.split(String regex)` | 数组                | 是 ✅         | 中等             | 高 ✅             |
| `Scanner` 类                 | 流式读取            | 是 ✅         | 低（需创建对象） | 高 ✅             |

------

## 六、与 408 其他模块的联系

-   **数据结构（Data Structures）**：`StringTokenizer` 本质上是对字符串线性结构的**顺序遍历操作**，使用迭代模式管理状态，可类比于**队列（Queue）**结构；
-   **编译原理（Compiler Theory）**（虽然非 408 科目，但拓展有助理解）：分词过程类似**词法分析器（Lexical Analyzer）**的构造，即 DFA（Deterministic Finite Automaton，确定有限自动机）在状态切换时识别 token；
-   **操作系统（Operating System）**：命令解析如 `ls -l /home/user`，需字符串解析以识别指令与参数；
-   **程序设计能力训练**：常用于模拟命令行解析、简单脚本语言解释器实现等编程题中，考查**字符串操作能力与状态管理能力**。

------

## 七、注意事项与易错点

-   `StringTokenizer` 已被 Java 官方标注为**legacy（过时但仍可用）**类，推荐在新项目中使用 `String.split()` 或 `Scanner` 替代；
-   `StringTokenizer` 不支持正则表达式（Regular Expression），不能处理复杂分隔规则；
-   多个连续分隔符会被视作一个（与 `split()` 的行为不同）；
-   不可修改 token 内容，若需替换或处理，需手动存储后操作。

------

## 八、总结与备考建议

-   掌握 `StringTokenizer` 用法对于处理**输入字符串中的多字段提取问题**具有直接帮助；
-   可在数据结构题、模拟类题目、字符串处理等方向进行实战练习；
-   建议掌握其与 `split()`、`Scanner` 等的异同，构建更全面的**字符串分割技术图谱**。

------

如需进一步提升，可配合手动实现分词器（基于状态转移或字符扫描）理解其底层机制，有助于加深对**字符串处理与状态建模的掌握**，提高综合解题能力。