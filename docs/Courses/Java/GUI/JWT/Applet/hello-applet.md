---
tags:
  - sdkman
  - applet
---

# Hello Applet

可以把 Applet 当作普通 Java 程序来运行，**通过 `AppletViewer` 工具或封装为 JFrame 运行**。

## A. 使用 `AppletViewer` 工具（Java 8 提供）

> ⚠️ 需要安装 Oracle JDK 8 或 OpenJDK 8。

1. 安装 Java 8（建议用 **SDKMAN** 或 AdoptOpenJDK）；
2. 编写 Applet 代码，例如 `HelloApplet.java`；
3. 创建 HTML 文件 `HelloApplet.html`；
4. 编译并使用 `appletviewer` 运行。

### `HelloApplet.java`

```java
import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, Applet!", 20, 20);
    }
}
```

### `HelloApplet.html`

```html
<html>
  <body>
    <applet code="HelloApplet.class" width="300" height="100"></applet>
  </body>
</html>
```

### compile and run

```bash
javac HelloApplet.java
appletviewer HelloApplet.html
```

---

## B. 将 Applet 改为 Swing 程序

```java
import javax.swing.*;
import java.awt.*;

public class AppletToFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet Replacement");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, Applet!", SwingConstants.CENTER);
        frame.add(label);
        frame.setVisible(true);
    }
}
```

---

## 总结

由于 Applet 技术已经终结，最好使用更现代的 GUI 框架：

| 框架             | 适用场景                       |
| -------------- | -------------------------- |
| **Swing**      | 学习经典 Java GUI、**考试**或老系统维护 |
| **JavaFX**     | 创建现代桌面应用，图形丰富、布局灵活         |
| **HTML5 + JS** | 如果目标是网页交互式程序，推荐使用 Web 技术   |
