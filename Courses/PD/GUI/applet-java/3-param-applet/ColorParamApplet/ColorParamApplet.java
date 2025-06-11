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