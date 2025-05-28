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
