
# Class Initializer

在 Java 中，**类初始化器（Class Initializer）** 是一个非常特殊的概念，它指的是**在类被加载后进行初始化的过程**，尤其是**静态初始化块（static initializer block）** 的执行。

---

## 什么是类初始化器？

类初始化器是 JVM 在类加载后自动执行的一段代码，用于初始化类的静态成员变量和执行静态代码块。

它不是 Java 语言层面的显式构造函数，但在 JVM 层面上存在，其对应的是字节码中的 `<clinit>` 方法（**class initializer method**）。

---

## 类初始化器的来源（static 块）

类初始化器通常由以下两部分组成：

1. **静态变量的赋值语句**
    
2. **静态代码块（`static { ... }`）**
    

```java
public class Example {
    static int value = 42;

    static {
        System.out.println("类被初始化：value = " + value);
    }
}
```

---

## 类初始化器的触发时机

类的初始化（即执行类初始化器）在以下**首次主动使用**类的时机发生：

|触发方式|是否会初始化类|
|---|---|
|创建类的实例（`new`）|✅ 是|
|访问类的静态字段/方法|✅ 是|
|使用 `Class.forName()`|✅ 是|
|子类初始化时父类先初始化|✅ 是|
|访问常量（`final static` 基本类型）|❌ 否（编译期已内联）|

---

### 会触发类初始化的例子

```java
Example e = new Example();       // new 对象，初始化
int x = Example.value;           // 访问静态变量，初始化
Class<?> cls = Class.forName("Example");  // 反射，初始化
```

### 不会触发类初始化的例子

```java
public class Example {
    public static final int CONST = 100;
}

// 编译器将 100 直接写死进字节码中，不会初始化类
int c = Example.CONST;
```

---

## 类初始化器的执行顺序

1. 静态字段按照**代码顺序**初始化
    
2. 静态代码块按照**代码顺序**执行
    
3. 所有这些内容合并生成一个 `<clinit>` 方法
    

例如：

```java
public class Test {
    static int a = 10;

    static {
        System.out.println("静态块，a = " + a);
        a = 20;
    }

    static int b = 30;

    public static void main(String[] args) {
        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 30
    }
}
```

---

## 小结

|类初始化器特点|描述|
|---|---|
|存在于 JVM 字节码中，方法名为 `<clinit>`|不是 Java 显式定义的|
|只执行一次|每个类初始化器最多执行一次（首次主动使用类时）|
|包含静态变量初始化和 `static {}` 代码块|两者按顺序合并|
