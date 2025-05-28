
# DataInputStream

## methods

```java
readInt()
readDouble()
readUTF()
readBoolean()
readChar()
readLong()
```

## ex

```java
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {
    public static void main(String[] args) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"));
            int i = dis.readInt();
            double d = dis.readDouble();
            String s = dis.readUTF();
            boolean b = dis.readBoolean();
            dis.close();

            System.out.println("读取结果：");
            System.out.println("int = " + i);
            System.out.println("double = " + d);
            System.out.println("String = " + s);
            System.out.println("boolean = " + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```