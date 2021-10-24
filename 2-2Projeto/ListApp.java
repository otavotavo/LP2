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
	int indexAtual=-1, indexFocus=0 ;  		// index da posiçao do loop que detecta o clique na figura atual  
	int xm, ym;					// posiçao constante do mouse na tela
	boolean redimensionar=false;			// boleano para setar se a figura esta sendo redimensionada ou nao

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
			
			int x = evt.getX();
			int y = evt.getY();

			if(focus != null)			
			focus.contorno_foco = false;


			redimensionar =false;
			focus = null;
			indexAtual=-1;
			indexFocus=-1;

			for ( Figure fig: figs){
				indexAtual++;
				fig.distanciaX = 0;
				fig.distanciaY = 0;

				if(fig.clicked(x,y)){										
				focus = fig;							
				indexFocus = indexAtual;
				focus.distanciaX = x - focus.x;
				focus.distanciaY = y - focus.y;
				}


				if(fig.clicked_resize(x,y))									 
				redimensionar=true;
			

			}

		

		if(focus != null){										// é setado o foco na ultima 
		focus.contorno_foco = true;									// figura dentro do clique. 
		figs.remove(indexFocus);									// Ela é removida do vetor
		figs.add(focus);										// e adicionada ao final
		}

			repaint();
		}
	});



	this.addMouseMotionListener ( new MouseMotionAdapter() {
		public void mouseDragged (MouseEvent evt) {
			

			if(focus != null && redimensionar == true){						// Checando  se existe uma
														// figura em foco e se ela
														// foi setada para redimensio-
			focus.resize(evt.getX(), evt.getY());							// nar. Chamando funçao de 
			repaint();										// redimensionar

			}  

				
				if( focus != null && redimensionar == false ){					// Checando se existe figura 
				focus.drag(evt.getX(),evt.getY());			
				repaint();									// função para arrastar
				};										
			
}		


	

		public void mouseMoved (MouseEvent evt) {

		xm= evt.getX();											// variaveis guardando posiçao
		ym= evt.getY();											// global do mouse

		
		for ( Figure fig: figs){
			fig.contorno_tela=false;
			if ((fig.x < evt.getX() && evt.getX() < (fig.x + fig.w )) &&				// loop checando se a posiçao
			(fig.y < evt.getY() && evt.getY() < (fig.y + fig.h ))) {				// do mouse esta em cima de 
														// alguma figura e setando 
			fig.contorno_tela=true;									// contorno preto
			};

			
}

			repaint();
}

});


	this.addKeyListener(
		new KeyAdapter (){
			public void keyPressed (KeyEvent evt){


					int x= xm;
					int y= ym;
					int w= 30 + rand.nextInt(50);
					int h= 30 +rand.nextInt(50);
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
					figs.add(new Seta(x,y,w,h, rCf,gCf,bCf, rCc,gCc,bCc));
				}if(evt.getKeyChar() == 'm'){
					if( focus != null){
					focus.rCf= rand.nextInt(180);
					focus.gCf= rand.nextInt(255);
					focus.bCf= rand.nextInt(255);
					focus.rCc= rand.nextInt(180);
					focus.gCc= rand.nextInt(255);
					focus.bCc= rand.nextInt(255);
					}
				
					
				}
				int keycode= evt.getKeyCode();
				if(focus != null){
				focus.distanciaX = 0;
				focus.distanciaY = 0;
				switch( keycode) { 
        	
				case KeyEvent.VK_DELETE:
					figs.remove(focus);
					break;

				case KeyEvent.VK_SHIFT:
					
					if( indexFocus == (figs.size() - 1))
						indexFocus = -1;

					focus.contorno_foco = false;
					indexFocus++;
					focus = figs.get(indexFocus);
					focus.contorno_foco = true;
					break;
	
        			case KeyEvent.VK_UP:
         				focus.drag(focus.x, focus.y - 5); 
        	    			break;

       				case KeyEvent.VK_DOWN:
         				focus.drag(focus.x, focus.y + 5); 
	        			break;

      				case KeyEvent.VK_LEFT:
        				focus.drag(focus.x - 5, focus.y); 
          				break;	
    
  				case KeyEvent.VK_RIGHT :
         				focus.drag(focus.x + 5, focus.y); 
           				break;	
    			}
		}

				repaint();
			}
		});

}


    public void paint (Graphics g) {
        super.paint(g);
	
	
	for(Figure fig: this.figs){
	
		
		fig.paint(g);
	}
	
	
	}
}
