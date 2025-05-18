
## 一、**异常体系结构（Exception Hierarchy）**

这是最基础的内容，必须理解：

- 所有异常都继承自 `Throwable`
    
    - `Error`：严重问题，程序无法处理（如 `OutOfMemoryError`），**通常不捕获**
        
    - `Exception`：程序可处理的异常
        
        - `Checked Exception`（受检异常）：**必须处理**（如 `IOException`, `SQLException`）
            
        - `Unchecked Exception`（运行时异常）：**可选处理**（如 `NullPointerException`, `ArrayIndexOutOfBoundsException`）
            

> ✅ 重点：区分 **受检异常** 和 **非受检异常**

---

## 二、**try-catch-finally 的语法结构**

### 基本形式：

```java
try {
    // 可能抛出异常的代码
} catch (ExceptionType e) {
    // 异常处理代码
} finally {
    // 一定会执行的代码（即使 catch 中 return 了）
}
```

- `try`：必须有，包裹可能出问题的代码
    
- `catch`：可以有多个，顺序从具体到抽象
    
- `finally`：可选但常用，**总会执行**，即使有 `return` 或 `exception`
    

> ✅ 重点理解：`finally` 一定会执行，但有极少数例外（如 `System.exit(0)`）

---

## 三、**throws 和 throw 的区别**

- `throws`：声明方法**可能抛出**的异常（通常是受检异常）
    

```java
public void readFile() throws IOException
```

- `throw`：**真正抛出**一个异常对象
    

```java
throw new IllegalArgumentException("参数不合法");
```

> ✅ 记忆：**throws 是声明，throw 是执行**

---

## 四、**自定义异常**

掌握如何创建自己的异常类（通常用于业务逻辑）：

```java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

> ✅ 如果是受检异常，继承 `Exception`；如果希望是运行时异常，继承 `RuntimeException`

---

## 五、**最佳实践与常见误区**

- 不要捕获 `Exception` 或 `Throwable` 除非你非常确定
    
- 避免**空的 catch 块**（会吞掉异常）
    
- 使用 `finally` 关闭资源；或使用 **try-with-resources**（Java 7+）
    

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // 自动关闭
}
```

> ✅ 记忆：`try-with-resources` 是最安全的资源关闭方式

---

## 六、常见异常类型（记忆）

你无需记住所有异常，但以下常见异常需要熟悉：

|异常类|类型|说明|
|---|---|---|
|`NullPointerException`|运行时异常|对空对象调用方法或访问字段|
|`ArrayIndexOutOfBoundsException`|运行时异常|数组越界|
|`ClassCastException`|运行时异常|类型转换失败|
|`IOException`|受检异常|文件/IO 相关错误|
|`FileNotFoundException`|受检异常|文件未找到（`IOException` 子类）|
|`SQLException`|受检异常|数据库错误|
|`IllegalArgumentException`|运行时异常|参数非法|

---

## 总结：核心理解 + 高频记忆清单

|要点|内容|
|---|---|
|核心理解|异常分类、处理机制、执行顺序|
|必须掌握|try-catch-finally 结构、throws vs throw、自定义异常|
|高频记忆|常见异常类型、受检与非受检区别、try-with-resources|
