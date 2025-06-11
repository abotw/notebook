# SumApplet

> 设计 Java Applet 程序，允许用户输入两个加数，点击“计算”按钮后显示它们的和。

- 功能需求分析
	- 两个输入框：输入加数 A 和加数 B
	- 一个按钮：“计算”
	- 一个文本区域/标签：显示结果

## sum.html

```html
<!DOCTYPE html>
<html>
<head><title>Sum Applet</title></head>
<body>
    <h3>两个数相加：</h3>
    <applet code="SumApplet.class" width="400" height="150">
        您的浏览器不支持 Java Applet。
    </applet>
</body>
</html>
```

## `SumApplet.java`

```java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SumApplet extends Applet implements ActionListener {
    TextField input1, input2;
    Button calcButton;
    Label resultLabel;

    public void init() {
        // 设置布局
        setLayout(new GridLayout(4, 2, 5, 5));  // 使用网格布局，美观且整齐

        // 初始化组件
        input1 = new TextField();
        input2 = new TextField();
        calcButton = new Button("计算");
        resultLabel = new Label("结果：");

        // 添加组件到 Applet
        add(new Label("加数 A："));
        add(input1);

        add(new Label("加数 B："));
        add(input2);

        add(calcButton);
        add(new Label(""));  // 占位用

        add(resultLabel);
        add(new Label(""));  // 占位用

        // 添加事件监听器
        calcButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(input1.getText().trim());
            int num2 = Integer.parseInt(input2.getText().trim());
            int sum = num1 + num2;
            resultLabel.setText("结果：" + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("请输入有效整数！");
        }

        // 强制重绘组件，确保 Label 更新
        validate();
        repaint();
    }
}
```

## compile and run

```sh
javac SumApplet.java && appletviewer sum.html
```






