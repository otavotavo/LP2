import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;

    RectEllipseFrame () {
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
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
	  int rCf,gCf,bCf;	//rgb da Cor de fundo
	  int rCc,gCc,bCc;	//rgb da Cor de contorno

	Rect (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	      this.rCf=rCf;
	      this.gCf=gCf;	
	      this.bCf=bCf;
      	this.rCc=rCc;
      	this.gCc=gCc;
      	this.bCc=bCc;

    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
       	g.setColor(new Color(this.rCf,this.gCf,this.bCf));
        g.drawRect(this.x,this.y, this.w,this.h);
      	g.setColor(new Color(this.rCc, this.gCc,this.bCc));
      	g.fillRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;
	  int rCf,gCf,bCf;	//rgb da Cor de fundo
  	int rCc,gCc,bCc;	//rgb da Cor de contorno

    Ellipse  (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	      this.rCf=rCf;
      	this.gCf=gCf;	
      	this.bCf=bCf;
      	this.rCc=rCc;
      	this.gCc=gCc;
      	this.bCc=bCc;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
      	g.setColor(new Color(this.rCf,this.gCf,this.bCf));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
      	g.setColor(new Color(this.rCc, this.gCc,this.bCc));
      	g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
