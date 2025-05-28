
# Swing

Java 的 **Swing** 是在 AWT 基础上开发的更强大的 GUI 工具包，属于 Java Foundation Classes（JFC）的一部分。Swing 提供了 **丰富、灵活、可定制**的图形用户界面组件，是构建 Java 桌面应用程序的核心工具。

---

### 🧱 1. Swing 的基本特征

- **轻量级组件**：不像 AWT 使用操作系统的原生组件，Swing 组件完全由 Java 实现，因此跨平台外观一致。
    
- **高度可定制**：支持外观与感觉（Look and Feel），可以模拟不同系统风格或自定义主题。
    
- **与 AWT 兼容**：Swing 组件都是 AWT 容器的一部分，使用上可以混合（不推荐混用）。
    

---

### 🧩 2. 常用 Swing 组件

#### 📦 顶层容器

- `JFrame`：主窗口
    
- `JDialog`：对话框
    
- `JApplet`：小程序（已过时）
    

#### 🧱 常见组件

|组件名|功能|
|---|---|
|`JLabel`|显示文本或图片|
|`JButton`|按钮|
|`JTextField`|单行文本输入|
|`JTextArea`|多行文本输入|
|`JCheckBox`|多选框|
|`JRadioButton`|单选按钮|
|`JComboBox`|下拉列表|
|`JList`|列表|
|`JTable`|表格组件|
|`JTree`|树形结构|
|`JScrollPane`|滚动面板|
|`JPanel`|容器，用于布局管理|

---

### 🧭 3. Swing 简单示例

```java
import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Demo");
        JButton button = new JButton("Click Me");

        button.setBounds(100, 100, 100, 40);
        frame.add(button);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));
    }
}
```

---

### 🧩 4. Swing 的事件处理

Swing 使用 Java 的事件模型（基于监听器）来响应用户操作：

```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // 事件响应代码
    }
});
```

也可以使用 Lambda 表达式（Java 8+）简化代码。

---

### 🎨 5. Look and Feel（外观与风格）

Swing 支持设置不同的风格，如 Windows、Motif、Nimbus：

```java
UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
```

---

### ⚖️ 6. Swing 的优缺点

|优点|缺点|
|---|---|
|平台外观一致|性能不如原生 GUI（适中）|
|丰富的组件库|比 JavaFX 更复杂一些|
|可自定义界面风格|不适合现代 Web 风格界面|

---

### ✅ 总结

Swing 是 Java GUI 编程的主流框架之一，功能远强于 AWT，适合构建中等复杂度的桌面应用。虽然 Swing 不再是 Java GUI 的前沿（JavaFX 更现代），但它仍在很多应用中被广泛使用，尤其在教育、企业级工具、IDE 插件等领域。

对于学习 Java 桌面开发来说，**理解 Swing 是基础，精通 Swing 是加分项**。