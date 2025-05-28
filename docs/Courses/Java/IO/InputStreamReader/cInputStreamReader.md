
# InputStreamReader

`InputStreamReader` 是一个**字节流 → 字符流的桥梁**。

- 它把 `InputStream`（如 `System.in` 或 `FileInputStream`）中的**字节**转换成**字符**。
    
- 可以指定编码（如 UTF-8）。

```java
import java.io.InputStreamReader;
import java.io.IOException;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            System.out.print("输入内容：");
            int ch = reader.read();
            System.out.println("你输入的是: " + (char) ch);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
