import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SumApplet extends Applet implements ActionListener {
    TextField input1, input2, result;
    Button calcButton;

    public void init() {
        // 设置一行横向布局
        setLayout(new FlowLayout());

        // 初始化输入框和按钮
        input1 = new TextField(5);   // 第一个加数
        input2 = new TextField(5);   // 第二个加数
        result = new TextField(5);   // 显示结果
        result.setEditable(false);   // 不允许用户手动修改结果

        calcButton = new Button("计算");

        // 添加组件到 Applet
        add(input1);
        add(new Label("+"));
        add(input2);
        add(new Label("="));
        add(result);
        add(calcButton);

        // 添加按钮事件监听器
        calcButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(input1.getText().trim());
            int num2 = Integer.parseInt(input2.getText().trim());
            int sum = num1 + num2;
            result.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
            result.setText("错误");
        }

        validate();  // 确保界面刷新
        repaint();
    }
}
