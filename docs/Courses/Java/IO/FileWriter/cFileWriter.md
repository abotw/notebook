---
doc: https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
---

# FileWriter

`FileWriter` 是 Java IO（输入输出）系统中用来**向文件中写入字符数据**的类。

- 它属于 `java.io` 包。
    
- 适合写入**字符流**（而不是字节流）。
    
- 每次写数据时，会**直接写入文件**（没有缓冲区）。

![](assets/Pasted%20image%2020250527150833.png)

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, FileWriter!\n");
            writer.close(); // 记得关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```