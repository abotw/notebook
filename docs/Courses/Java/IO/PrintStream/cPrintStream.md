
# PrintStream

在 Java 中，`PrintStream` 是一个常用的输出流类，属于 `java.io` 包，用于将数据以可打印的形式输出到各种目标（如控制台、文件等）。

---

## 基本介绍

- **类名**：`java.io.PrintStream`
    
- **继承关系**：  
    `java.lang.Object` → `java.io.OutputStream` → `java.io.FilterOutputStream` → `java.io.PrintStream`
    

---

## 主要特点

1. **支持多种数据类型的输出**：  
    可以直接输出 `int`、`float`、`double`、`char`、`boolean`、`String` 等类型，无需手动转换。
    
2. **自动刷新（optional）**：  
    可以设置在输出换行符（如 `println()`）、写入字节数组或写入 `\n` 时自动刷新缓冲区。
    
3. **不会抛出 IOException**：  
    方法内部会捕获 IO 异常并通过 `checkError()` 方法报告，而不会向外抛出。
    
4. **常用于标准输出**：  
    `System.out` 就是一个 `PrintStream` 实例，默认连接到控制台。
    

---

## 常用构造方法

```java
PrintStream(OutputStream out)
PrintStream(OutputStream out, boolean autoFlush)
PrintStream(String fileName) throws FileNotFoundException
```

---

## 常用方法

|方法|描述|
|---|---|
|`print(...)`|打印数据，不换行|
|`println(...)`|打印数据并换行|
|`printf(...)`|格式化输出|
|`flush()`|强制刷新缓冲区|
|`close()`|关闭流|
|`checkError()`|检查是否有错误发生|

---

## 示例代码

```java
import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) {
        PrintStream ps = System.out;

        ps.print("Hello, ");
        ps.println("world!");
        ps.printf("Pi ≈ %.2f\n", 3.14159);
    }
}
```

输出：

```
Hello, world!
Pi ≈ 3.14
```

---

如需将输出写入文件，可以这样做：

```java
PrintStream ps = new PrintStream("output.txt");
ps.println("写入文件的内容");
ps.close();
```
