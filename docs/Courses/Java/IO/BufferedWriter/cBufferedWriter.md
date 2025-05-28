---
doc: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
---

# Buffered Writer

`BufferedWriter` 是一个**带缓冲区**的字符输出流，作用是**包装其他 Writer（如 FileWriter）来提高写入效率**。

- 它内部有一个缓冲区，暂时存储写入的数据。
    
- 调用 `flush()` 或 `close()` 才会真正写入文件。
    
- 特别适合频繁写小段文本的情况。

![](assets/Pasted%20image%2020250527150932.png)

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("example.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hello, BufferedWriter!\n");
            bw.write("This is more efficient.\n");

            bw.close(); // 会自动 flush 并关闭 FileWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## BufferedWriter vs. FileWriter

如果只是写入少量内容，可以用 `FileWriter`。  

如果要写入多次，尤其是循环写入，**推荐使用 `BufferedWriter`** 来提升性能。

| 特性              | FileWriter  | BufferedWriter          |
| --------------- | ----------- | ----------------------- |
| 作用              | 写入**字符**到文件 | 提高写入效率，包装其他 Writer      |
| 是否带缓冲区          | 否           | 是                       |
| 是否需要包装其他 Writer | 否           | 是（通常包装 FileWriter）      |
| 性能              | 写入频繁时效率低    | 写入频繁时效率高                |
| flush 机制        | 写一次就写入文件    | 缓存中先保存，`flush()` 后才写入文件 |