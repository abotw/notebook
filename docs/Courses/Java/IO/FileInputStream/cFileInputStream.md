
# FileInputStream

`FileInputStream` 用于从文件中**读取字节数据**，是面向**字节**的输入流。

- 常用于读取二进制文件或按字节处理文本。
    
- 每次 `read()` 会返回一个字节（0~255 的 int 值）。

```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("example.txt");
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b); // 逐个字节转为字符打印
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```