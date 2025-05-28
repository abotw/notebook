
# FileOutputStream

`FileOutputStream` 用于**向文件写入字节数据**，是面向**字节**的输出流。

- 适合写入二进制内容。
    
- 写入时，如果文件不存在，会自动创建；存在则**默认会覆盖**（除非以追加模式打开）。

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            String data = "Hello, FileOutputStream!";
            fos.write(data.getBytes()); // 将字符串转为字节再写入
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```