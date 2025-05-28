
# JWT

Java 的 **Abstract Window Toolkit（AWT）** 是 Java **最早期**用于构建图形用户界面（GUI）的工具包，属于 **Java 标准库(JSL)** 的一部分，位于 `java.awt` 包中。

---

### 🧱 1. **AWT 的基本概念**

- **AWT** 是 Java 的一个 **平台无关**的 GUI 工具包。
    
- 它是 Java Foundation Classes (JFC) 的一部分，另一个更现代的 GUI 工具包是 Swing。
    
- AWT 使用 **本地平台的 GUI 组件（native peers）**，即调用操作系统的本地窗口部件来绘制界面。
    
- 这意味着 AWT 程序在不同操作系统下可能表现略有不同（例如按钮样式不统一）。
    

---

### 🧩 2. **主要组件**

AWT 提供了构建 GUI 的基础组件和容器，包括：

#### 🖼️ 组件（Component 类的子类）

- `Button`
    
- `Label`
    
- `TextField`
    
- `TextArea`
    
- `Checkbox`
    
- `Choice`（下拉菜单）
    
- `List`
    

#### 📦 容器（Container 类的子类）

- `Panel`：基本的容器组件，用于组织组件布局。
    
- `Frame`：主窗口。
    
- `Dialog`：对话框窗口。
    
- `Applet`：用于嵌入网页的 GUI 程序（已过时）。
    

#### 🎨 图形绘制

- `Graphics` 类提供绘图功能（如 `drawLine()`、`drawRect()` 等）。
    
- 通常在组件的 `paint(Graphics g)` 方法中使用。
    

#### 🖱️ 事件处理

AWT 使用基于事件的模型来响应用户操作，如：

- `ActionListener`（按钮点击）
    
- `MouseListener`（鼠标事件）
    
- `KeyListener`（键盘事件）
    

---

### ⚙️ 3. **简单例子**

```java
import java.awt.*;
import java.awt.event.*;

public class AWTExample {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Demo");
        Button btn = new Button("Click Me");
        
        btn.setBounds(50, 100, 80, 30); // x, y, width, height
        frame.add(btn);
        
        frame.setSize(300, 200);
        frame.setLayout(null); // 使用绝对布局
        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // 关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
```

---

### ⚖️ 4. **AWT 的优缺点**

|优点|缺点|
|---|---|
|跨平台（运行在 JVM 上）|依赖操作系统的本地 GUI，表现不统一|
|使用简单，适合学习|功能有限，不适合复杂界面开发|
|集成在 Java 标准库中|已被 Swing 和 JavaFX 所取代|

---

### 🧭 5. **AWT 与 Swing、JavaFX 的比较**

|特性|AWT|Swing|JavaFX|
|---|---|---|---|
|GUI 风格|本地原生|轻量组件|现代化、高度可定制|
|灵活性|低|中|高|
|是否推荐|❌ 不推荐|✅ 可用|✅ 推荐（Java 8+）|

---

### ✅ 总结

AWT 是 Java GUI 编程的基础框架，适合简单应用和学习事件驱动模型。但现代 Java GUI 开发更推荐使用 **Swing** 或 **JavaFX**，因为它们提供更多组件、更好的一致性和现代化功能。AWT 仍有意义，尤其是理解 Java GUI 编程的历史和底层机制。