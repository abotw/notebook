// HelloApplet.java

import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="HelloApplet.class" width="300" height="100"></applet>
*/

public class HelloApplet extends Applet {
	public void paint(Graphics g) {
		g.drawString("Hello, Applet!", 50, 50);
	}
}