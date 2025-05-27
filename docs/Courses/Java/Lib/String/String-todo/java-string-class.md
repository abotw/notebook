# Java 字符串类详解（String Class）

## 一、概述与考纲定位

Java 字符串类 `String` 是 Java 标准类库中最常用的类之一，作为对象不可变（Immutable）的代表，其特性在 **数据结构（Data Structures）** 与 **操作系统（Operating System）** 的内存管理理解中有广泛联系。考研 408 计算机组成部分不直接考 Java，但其字符串操作常出现在编程语言基础及应用题中，是**软件系统设计基础能力**的体现。

------

## 二、字符串的本质与不可变性

-   Java 中 `String` 实质是一个**字符序列（Character Sequence）**，底层使用 `char[]` 实现。

-   不可变性（Immutability）：`String` 对象一旦创建，内容不可更改；修改操作本质是新建对象。

    -   意义：线程安全（Thread-safe）、适合作为键（如哈希表键）使用。

    -   示例：

        ```java
        String a = "hello";
        a = a + "world"; // 新建了一个 String 对象，而不是修改原始的 a
        ```

------

## 三、字符串的创建方式及内存分配

### 1. 字面量创建（常量池）：

```java
String s1 = "hello";
```

-   位于字符串常量池（String Constant Pool）
-   相同字面量共享同一内存地址（节省内存）

### 2. new 关键字创建：

```java
String s2 = new String("hello");
```

-   创建两个对象：常量池中的 `"hello"` 和堆内的 `String` 对象
-   `s1 == s2` 结果为 `false`，需使用 `.equals()` 比较内容

------

## 四、常用字符串方法（常考）

| 方法                            | 含义                 |
| ------------------------------- | -------------------- |
| `length()`                      | 获取字符串长度       |
| `charAt(int index)`             | 返回指定索引字符     |
| `substring(int start, int end)` | 截取子串             |
| `indexOf(String str)`           | 查找子串首次出现位置 |
| `equals(Object obj)`            | 比较内容是否相等     |
| `equalsIgnoreCase(String)`      | 忽略大小写比较       |
| `compareTo(String)`             | 字典序比较           |
| `replace(char old, char new)`   | 替换字符             |
| `split(String regex)`           | 字符串分割           |
| `trim()`                        | 去除首尾空格         |
| `toCharArray()`                 | 转换为字符数组       |

>   📌 **常考点：字符串比较、截取、查找操作的使用与实现细节。**

------

## 五、经典例题与解析

### 例题1：【字符串比较陷阱】

```java
String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2);          // false
System.out.println(s1.equals(s2));     // true
```

**考点解析：**

-   `==` 比较的是地址（引用是否相同）
-   `.equals()` 比较的是内容
-   与 **Java 内存结构（Java Memory Model）** 和 **堆（Heap）/栈（Stack）** 分配有关

------

### 例题2：【常量池机制】

```java
String s1 = "a" + "b"; // 编译期优化，结果为 "ab"
String s2 = "ab";
System.out.println(s1 == s2); // true
```

**考点解析：**

-   编译期优化常量连接，`s1` 实际存储在常量池中
-   与 **编译原理（Compiler Principle）** 中的常量折叠（Constant Folding）有关

------

## 六、字符串类的相关类与区别

| 类名            | 特性   | 是否可变        | 应用场景             |
| --------------- | ------ | --------------- | -------------------- |
| `String`        | 不可变 | ❌               | 基础操作、键使用     |
| `StringBuilder` | 可变   | ✅（非线程安全） | 单线程环境中大量拼接 |
| `StringBuffer`  | 可变   | ✅（线程安全）   | 多线程环境中拼接需求 |

------

## 七、与408其他模块的联系

-   **操作系统（Operating System）**：理解字符串不可变性与线程安全机制相关。
-   **计算机组成原理（Computer Organization and Architecture）**：Java 字符串内存布局可与常量池、堆栈内存联系理解。
-   **数据结构（Data Structures）**：字符串本质为线性结构，可与数组、链表操作类比理解。
-   **编程语言基础与实践**：考查 Java 编程基本功，常用于填空、选择和编程题。

------

## 八、总结

-   `String` 类为 Java 中**重点、常考的类**，涉及对象管理、内存机制、API 操作、性能优化等多个维度。
-   备考时应**精通方法使用、掌握常见陷阱、理解底层实现**，并能快速解决字符串处理问题。
-   配合实际练习和例题演练，有助于提升**编程题得分率**和系统理解能力。

