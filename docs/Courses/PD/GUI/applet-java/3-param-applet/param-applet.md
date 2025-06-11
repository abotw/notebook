
# Applet 参数传递与颜色设置

HTML 向 Applet 传进三个参数：一个字符串 `label`；一个是背景颜色 `background`；再一个是前景颜色 `foreground`。在 Applet 侧接收并使用它们。

## `color-param-demo.html`

```html
<HTML>
<BODY>
    <applet
        code="ColorParamApplet.class"
        name="ColorParamApplet"
        width="320"
        height="200">
        <param name="label" value="这是从网页传过来的">
        <param name="background" value="804f00">
        <param name="foreground" value="FF00FF">
    </applet>
</BODY>
</HTML>
```

##  `ColorParamApplet.java`

```java
import java.awt.*;
import java.applet.*;

public class ColorParamApplet extends Applet {
    String st1 = new String();
    String receive;
    int red, green, blue;
    Font font = null;

    public void init() {
        String backcolor = getParameter("background");
        String forecolor = getParameter("foreground");
        receive = getParameter("label");

        this.setLayout(new BorderLayout());
        this.setLayout(null);

        Label Lab = new Label("看前景颜色对我的变化");
        Lab.setBounds(10, 60, 250, 30);

        red = Integer.decode("0x" + backcolor.substring(0, 2)).intValue();
        green = Integer.decode("0x" + backcolor.substring(2, 4)).intValue();
        blue = Integer.decode("0x" + backcolor.substring(4, 6)).intValue();
        this.setBackground(new Color(red, green, blue));

        red = Integer.decode("0x" + forecolor.substring(0, 2)).intValue();
        green = Integer.decode("0x" + forecolor.substring(2, 4)).intValue();
        blue = Integer.decode("0x" + forecolor.substring(4, 6)).intValue();

        font = new Font("TimesRoman", Font.BOLD, 18);
        this.setFont(font);
        this.setForeground(new Color(red, green, blue));

        this.add(Lab);
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.BOLD, 24));
        g.drawString(receive, 10, 25);
    }
} // end ColorParamApplet
```

## 实验步骤

1. 在编辑区先选中 `ColorParamApplet.java`，编译 Java 源文件，形成 `ColorParamApplet.class`。  
2. 再选中 `ColorParamDemo.html`，运行该程序。  
3. 每次修改 HTML 侧的 `background` 或 `foreground` 值，然后运行观察结果。

![](assets/Pasted%20image%2020250611153136.png)

![](assets/Pasted%20image%2020250611153214.png)

![](assets/Pasted%20image%2020250611153303.png)

![](assets/Pasted%20image%2020250611153351.png)

## 思考问题

1. 从 HTML 网页传过来的参数在 Applet 侧是如何获取、如何转换、如何利用的？  
2. 页面中显示了两个字符串，所用的方法有何不同？  
3. 使从 HTML 接受过来的字符串显示的字体和颜色与“看前景颜色对我的变化”字符串相同，怎样修改程序？

### 1. 从 HTML 网页传过来的参数在 Applet 侧是如何获取、如何转换、如何利用的？

**获取**：通过 `getParameter("参数名")` 方法获取 HTML 中 `<param>` 标签传来的参数值。

例如：

```java
String backcolor = getParameter("background");
```

**转换**：背景色和前景色是十六进制的字符串，需要转换为整数：

```java
red = Integer.decode("0x" + backcolor.substring(0, 2)).intValue();
```

每两位分别代表红、绿、蓝通道值。

**利用**：

- 将颜色转换为 `Color` 对象并用于设置背景和前景颜色：
    
    ```java
    this.setBackground(new Color(red, green, blue));
    ```
    
- 将 `label` 字符串用于 `drawString` 进行绘制输出：
    
    ```java
    g.drawString(receive, 10, 25);
    ```
    

---

### 2. 页面中显示了两个字符串，所用的方法有何不同？

- 第一个字符串 `"看前景颜色对我的变化"` 是通过创建 `Label` 组件并添加到 Applet 中显示的，属于 **组件化显示**。
    
    ```java
    Label Lab = new Label("看前景颜色对我的变化");
    this.add(Lab);
    ```
    
- 第二个字符串是 `label` 参数中的文本，通过 `Graphics.drawString()` 方法在 `paint()` 中绘制，属于 **图形绘制方式**。
    
    ```java
    g.drawString(receive, 10, 25);
    ```
    

两者的主要区别在于：前者是 GUI 控件，后者是手动绘图，前者更易管理和响应事件，后者更灵活但需手动控制位置与样式。

---

### 3. 使从 HTML 接受过来的字符串显示的字体和颜色与 “看前景颜色对我的变化” 字符串相同，怎样修改程序？

`Label Lab` 的字体和颜色是通过以下方式设置的：

```java
this.setFont(font);              // 设置整个 Applet 的字体
this.setForeground(new Color(...)); // 设置整个 Applet 的前景色
```

但 `paint()` 方法中单独设置了字体和颜色为：

```java
g.setColor(Color.blue);
g.setFont(new Font("TimesRoman", Font.BOLD, 24));
```

要让它与 `Label` 一致，**只需将 `paint()` 方法中对字体和颜色的设置移除或替换为相同设置**：

```java
public void paint(Graphics g) {
    g.drawString(receive, 10, 25);
}
```

或者用与 `init()` 中一致的设置（可复用 `font` 和前景色）：

```java
public void paint(Graphics g) {
    g.setColor(getForeground());
    g.setFont(getFont());
    g.drawString(receive, 10, 25);
}
```

## 总结

### 1. HTML 向 Java Applet 传递参数的机制

- 通过 `<param>` 标签向 Applet 传递字符串（如 `label`）以及颜色值（如 `background`、`foreground`）；
    
- 在 Applet 中使用 `getParameter(String name)` 方法接收参数；
    
- 体现了 Web 页面与嵌入式 Java 应用之间的简单通信方式。
    

---

### 2. 参数在 Applet 中的解析与使用方法

- 将传入的颜色字符串解析为 RGB 值，再转换为 `Color` 对象；
    
- 用 `setBackground()` 和 `setForeground()` 设置界面样式；
    
- 说明了如何将 HTML 的文本或配置参数直接影响 Java Applet 的外观和行为。
    

---

### 3. GUI 组件显示与图形绘制的区别

- 使用 `Label` 组件显示固定文本，展示了 AWT 控件的使用方式；
    
- 使用 `Graphics.drawString()` 显示参数文本，展示了图形绘制的灵活性；
    
- 对比了两种文本显示方式在样式控制和位置管理方面的差异。
    

---

### 综合说明

这个实验验证了 Java Applet 可以动态接收并解析 HTML 页面提供的参数，从而实现界面元素的个性化定制，体现了 Java 与 Web 集成的基本能力。同时也通过对字体、颜色、布局等的设置，锻炼了图形编程与组件编程的基础技巧。

