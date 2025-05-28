import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("fw-example.txt");
            writer.write("Hello, FileWriter!\n");
            writer.close(); // 记得关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
