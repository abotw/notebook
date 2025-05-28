
# BufferedReader

`BufferedReader` 是一个**带缓冲区的字符输入流**，它可以包装任何 `Reader` 类，如 `FileReader`、`InputStreamReader` 等。

提供缓冲 + `readLine()` 的高级读取方式：

- 用于**高效地读取字符、数组、或整行字符串**。
    
- 有一个很常用的方法 `readLine()`，可以一行一行读取文本。

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("请输入一行文字：");
            String line = br.readLine();
            System.out.println("你输入的是: " + line);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 技巧

读取用户输入（如命令行输入）时，我们经常这样写：

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

这意味着：

1. `System.in` 是一个字节流（`InputStream`）；
    
2. `InputStreamReader` 把字节转为字符；
    
3. `BufferedReader` 提供缓存和 `readLine()` 方法。

## readLine

![](assets/Pasted%20image%2020250527152218.png)

## BufferedReader vs. InputStreamReader

| 特性              | BufferedReader              | InputStreamReader                        |
| --------------- | --------------------------- | ---------------------------------------- |
| 作用              | 提供带缓冲的一次读取多字符（特别是按行）        | 将字节流转换为字符流                               |
| 常用于包装           | Reader（如 InputStreamReader） | InputStream（如 System.in、FileInputStream） |
| 是否有缓冲           | 是，效率更高                      | 否                                        |
| 是否支持 readLine() | 是，最常用方法之一                   | 否                                        |
| 编码控制            | 不处理编码，依赖它包装的 Reader         | 支持指定编码（如 UTF-8）                          |