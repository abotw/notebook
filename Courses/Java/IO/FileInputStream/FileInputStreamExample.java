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
