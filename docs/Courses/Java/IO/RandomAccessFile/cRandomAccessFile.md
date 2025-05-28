---
aliases:
  - 随机流
---

# RandomAccessFile

`RandomAccessFile` 是 Java 中一个用于**随机读写文件**的类，它既可以读取也可以写入数据，**不像普通流那样只能顺序访问**。

它的主要特点是：

- 支持**随机定位**（通过 `seek(long pos)` 方法）
    
- 同时支持**读写操作**
    
- 可以操作**二进制数据**（如 `int`、`long`、`byte[]`）
    

它属于 `java.io` 包，并不是继承自 `InputStream` 或 `OutputStream`，而是实现了 `DataInput` 和 `DataOutput` 接口。

## 构造方法

```java
RandomAccessFile file = new RandomAccessFile(String name, String mode);
RandomAccessFile file = new RandomAccessFile(File file, String mode);
```

### 模式说明

|模式|含义|
|---|---|
|`"r"`|只读模式（read-only）|
|`"rw"`|可读可写模式（read/write）|
|`"rws"`|同步读写文件内容和元数据|
|`"rwd"`|同步读写文件内容，但不一定同步元数据（性能略高）|

## 常用方法

### 基本操作

```java
void seek(long pos)           // 设置文件指针位置
long getFilePointer()         // 获取当前文件指针位置
long length()                 // 获取文件长度
void close()                  // 关闭文件
```

### 读数据

```java
int read()                    // 读取一个字节（返回 -1 表示 EOF）
int read(byte[] b)            // 读取字节数组
String readLine()             // 按行读取（已过时，不支持 UTF-8）
int readInt(), readLong(), readUTF() 等 // 读取各种类型数据
```

### 写数据

```java
void write(int b)             // 写入一个字节
void write(byte[] b)          // 写入字节数组
void writeInt(int v), writeLong(long v), writeUTF(String str) 等 // 写入各种类型数据
```

## 示例代码

```java
import java.io.*;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("example.txt", "rw");

            // 写入数据
            raf.writeInt(123);     // 写 4 字节的整数
            raf.writeUTF("Hello"); // 写入 UTF-8 字符串

            // 定位到文件开头
            raf.seek(0);

            // 读取数据
            int num = raf.readInt();
            String text = raf.readUTF();

            System.out.println("Read int: " + num);
            System.out.println("Read string: " + text);

            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 使用场景

- 实现简单的数据库或索引文件（比如根据 ID 直接定位数据）
    
- 修改大型文件的中间某一部分（不必读取整个文件）
    
- 文件打补丁或二进制编辑
    
- 实现记录追加和更新日志功能

## 注意事项

- `RandomAccessFile` 不适合用于高并发读写，**不是线程安全的**
    
- `readLine()` 方法使用本地字符集，不推荐用于 UTF-8 文件
    
- 手动管理文件指针，**不当使用可能导致读取异常或数据错位**
