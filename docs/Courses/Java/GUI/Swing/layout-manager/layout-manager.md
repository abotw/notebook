
# Layout Manager

Java 中的 **LayoutManager** 是 AWT 和 Swing GUI 编程中用于控制组件在容器中布局的接口。Java 提供了多种常用的布局管理器（LayoutManager 的实现类），每种布局管理器都有其特点和使用场景。

---

## 一、常见的布局管理器

|布局管理器|说明|
|---|---|
|`FlowLayout`|按照组件添加的顺序，从左到右排列，默认换行。|
|`BorderLayout`|将容器分为东、南、西、北、中五个区域。|
|`GridLayout`|网格布局，所有组件大小相同，按行优先排列。|
|`BoxLayout`|垂直或水平地依次排列组件。|
|`GridBagLayout`|灵活但复杂的网格布局，支持组件跨行跨列。|
|`CardLayout`|组件堆叠，像卡片一样切换显示一个组件。|

---

## 二、示例代码

下面以常见的 `FlowLayout`、`BorderLayout` 和 `GridLayout` 为例：

### 1. FlowLayout 示例

```java
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
```

---

### 2. BorderLayout 示例

```java
import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 示例");
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("北"), BorderLayout.NORTH);
        frame.add(new JButton("南"), BorderLayout.SOUTH);
        frame.add(new JButton("东"), BorderLayout.EAST);
        frame.add(new JButton("西"), BorderLayout.WEST);
        frame.add(new JButton("中"), BorderLayout.CENTER);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

---

### 3. GridLayout 示例

```java
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
```

---

## 三、总结

|选择布局时考虑因素|推荐布局|
|---|---|
|简单横向或纵向排列|FlowLayout / BoxLayout|
|明确的区域划分|BorderLayout|
|等间距网格|GridLayout|
|灵活复杂布局|GridBagLayout|
|多页面切换|CardLayout|
