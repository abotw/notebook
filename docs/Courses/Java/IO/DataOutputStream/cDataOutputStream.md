
# DataOutputStream

## methods

```java
writeInt(int v)
writeDouble(double v)
writeBoolean(boolean v)
writeUTF(String s)
writeChar(int v)
writeLong(long v)
```

## ex

```java
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
            dos.writeInt(123);
            dos.writeDouble(3.14);
            dos.writeUTF("Hello");
            dos.writeBoolean(true);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

写入的是**原始的二进制数据**，不是文本，所以不能用记事本直接打开看懂内容。