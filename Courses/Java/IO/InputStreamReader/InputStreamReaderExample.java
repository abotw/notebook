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