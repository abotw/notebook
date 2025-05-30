import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout 示例");
        frame.setLayout(new GridLayout(2, 3));  // 2 行 3 列的网格

        for (int i = 1; i <= 6; i++) {
            frame.add(new JButton("按钮 " + i));
        }

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}