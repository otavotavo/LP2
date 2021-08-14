import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.magenta);
        int w = getWidth();
        int h = getHeight();
	g2d.fillRect(0,0,w,h);
	g2d.setPaint(Color.green);
        g2d.drawLine(0,h, w/2,0);
        g2d.drawLine(w/2,0, w,h);
	g2d.drawLine(0,h,w,h);
	g2d.setPaint(Color.black);
	g2d.drawRect(0,0,120,90);
    }

}
