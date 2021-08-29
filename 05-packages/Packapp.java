import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import figures.*;

class Packapp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Square  s1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50,50, 100,30,  0,255,0,  255,0,0 );
        this.e2 = new Ellipse(280,30, 55,110,  43,2,87,  202,16,16 );
        this.e3 = new Ellipse(80,290, 200,70,  54,65,73,  255,51,255 );

        this.s1 = new Square(80,150, 20,  54,65,73,  255,51,255 );
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);

        this.s1.paint(g);
    }
}

