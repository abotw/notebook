import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("请输入一行文字：");
            String line = br.readLine();
            System.out.println("你输入的是: " + line);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}