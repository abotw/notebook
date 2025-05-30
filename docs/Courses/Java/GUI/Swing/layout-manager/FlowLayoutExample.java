import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 示例");
        frame.setLayout(new FlowLayout());  // 设置为 FlowLayout

        frame.add(new JButton("按钮 1"));
        frame.add(new JButton("按钮 2"));
        frame.add(new JButton("按钮 3"));

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}