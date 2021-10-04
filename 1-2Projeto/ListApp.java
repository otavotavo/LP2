import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Random rand = new Random();
	Figure focus =  null;
	int rCcAtual= 0, gCcAtual=0, bCcAtual=0;


    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );



        this.setTitle("1/2 Projeto");
        this.setSize(350, 350);



	this.addMouseListener ( new MouseAdapter() {
		public void mousePressed (MouseEvent evt){
			
			if(focus != null){			
			focus.rCc = rCcAtual;			
			focus.bCc = bCcAtual;			
			focus.gCc = gCcAtual;

			rCcAtual=0;			
			bCcAtual=0;			
			gCcAtual=0;
			};	
			

			focus = null;

			for ( Figure fig: figs){
				if ((fig.x < evt.getX() && evt.getX() < (fig.x + fig.w )) &&
				(fig.y < evt.getY() && evt.getY() < (fig.y + fig.h ))) {

					for ( Figure fig2 :figs){

						if ((fig2.x < evt.getX() && evt.getX() < (fig2.x + fig2.w )) &&
						(fig2.y < evt.getY() && evt.getY() < (fig2.y + fig2.h ))) {

							if( fig2.z_Order > fig.z_Order){ 
	
								fig2.z_Order=1;
								focus = fig2;

								rCcAtual= fig2.rCc;
								bCcAtual= fig2.bCc;
								gCcAtual= fig2.gCc;
								fig2.rCc =255;	
								fig2.bCc =0;	
								fig2.gCc =0;	

								fig.z_Order=0;

							}else{
								fig.z_Order=1;
								focus = fig;

								rCcAtual= fig.rCc;
								bCcAtual= fig.bCc;
								gCcAtual= fig.gCc;
								fig.rCc =255;	
								fig.bCc =0;	
								fig.gCc =0;	

								fig2.z_Order=0;
								
			}
		}
	}
					break;
}
	}
			repaint();
	}
	});




	this.addMouseMotionListener ( new MouseMotionAdapter() {
		public void mouseDragged (MouseEvent evt) {
			
				
				if( focus != null){
				focus.x= evt.getX();
				focus.y= evt.getY();
				repaint();
				};
			}
	
	});
			


	this.addKeyListener(
		new KeyAdapter (){
			public void keyPressed (KeyEvent evt){
					int x= rand.nextInt(350);
					int y= rand.nextInt(350);
					int w= rand.nextInt(50);
					int h= rand.nextInt(50);
					int rCf= rand.nextInt(180);
					int gCf= rand.nextInt(255);
					int bCf= rand.nextInt(255);
					int rCc= rand.nextInt(180);
					int gCc= rand.nextInt(255);
					int bCc= rand.nextInt(255);

				if (evt.getKeyChar() == 'r'){
					Rect r = new Rect(x,y,w,h, rCf,gCf,bCf, rCc,gCc,bCc);
					figs.add(r);
				}if(evt.getKeyChar() == 'e'){
					figs.add(new Ellipse(x,y,w,h, rCf,gCf,bCf, rCc,gCc,bCc));
				}if(evt.getKeyChar() == 't'){

					Triangle tr= new Triangle(x,y,w,h, rCf,gCf,bCf, rCc,gCc,bCc);
					figs.add(tr);
				}if(evt.getKeyChar() == 's'){
					int r= rand.nextInt(50);
					r= x+r;

					h=y+h;
					w= x+(2*(r-x));
					figs.add(new Seta(r,x,y,w,h, rCf,gCf,bCf, rCc,gCc,bCc));
				}if(evt.getKeyCode() == KeyEvent.VK_DELETE){
					if(focus != null){
						figs.remove(focus);
					}
				}


				repaint();
			}
		}
	);


    }



    public void paint (Graphics g) {
        super.paint(g);
	
	
	for(Figure fig: this.figs){
	
		
		fig.paint(g);
	}
	
	
	}
}

