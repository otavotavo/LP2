import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import java.io.*;

class ListApp {
    public static void main (String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}

class Frame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Button> buts = new ArrayList<Button>();
	Random rand = new Random();
	Button focus_but = null;
	Figure focus =  null;
	boolean aumentar, diminuir = false;
	int indexAtual=-1, indexFocus=0 ;  		// index da posiçao do loop que detecta o clique na figura atual  
	int xm, ym;					// posiçao constante do mouse na tela
	boolean redimensionar=false;			// boleano para setar se a figura esta sendo redimensionada ou nao

    Frame () {

	buts.add(new Button(0, new Rect(0,0,0,0,255,255,255, 0,0,0)));
	buts.add(new Button(1, new Ellipse(0,0,0,0,255,255,255, 0,0,0)));
	buts.add(new Button(2, new Seta(0,0,0,0,255 ,255,255, 0,0,0)));
	buts.add(new Button(3, new Triangle(0,0,0,0, 255,255,255, 0,0,0)));
	buts.add(new Button(4, new Plus(0,0,0,0, 255,255,255, 0,0,0)));
	buts.add(new Button(5, new Minus(0,0,0,0, 255,255,255, 0,0,0)));



	try {
	  FileInputStream      f = new FileInputStream("proj.bin");
	  ObjectInputStream    o = new ObjectInputStream(f);
	  this.figs = (ArrayList<Figure>) o.readObject();
	  o.close();
      } catch (Exception x) {
	  System.out.println("ERRO!");
      }	  

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {

			try {
				FileOutputStream    f = new FileOutputStream("proj.bin");
				ObjectOutputStream  o = new ObjectOutputStream(f);
				o.writeObject(figs);
				o.flush();
				o.close();
		     }  catch (Exception x) {
		     }
     
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
				
				if(aumentar){
				focus.w +=30;
				focus.h +=30;
				}
	
				if(diminuir){
				focus.w -=30;
				focus.h -=30;
				}

				}


				if(fig.clicked_resize(x,y))									 
				redimensionar=true;
			

			}

			for (Button but: buts){
				if(but.clicked(x,y)){

					aumentar = false;
					diminuir = false;

					if(focus_but != null){					// checando se o clique foi feito ou no mais 
						if(focus_but.idx == 4 && but.idx == 4){		// ou no menos enquanto algum deles estava em
							focus_but = null;			// foco para desablitar
							break;
						};
						if(focus_but.idx == 5 && but.idx == 5){
							focus_but = null;
							break;
						};
					};	

					focus_but = but;
					
					if(focus_but.idx == 4)
						aumentar = true;


					if(focus_but.idx == 5)
						diminuir = true;
				}
			}



		if(focus != null){										// é setado o foco na ultima 
		figs.remove(indexFocus);									// Ela é removida do vetor
		figs.add(focus);										// e adicionada ao final.
		indexFocus--;											//Diminuindo indexFocus para
		}												//a figura que foi pulado



		if(focus_but != null && !( (0<x && x<300) && (0<y && y<77))){



			int botao_x= evt.getX();
			int botao_y= evt.getY();
			int w= 30 + rand.nextInt(50);
			int h= 30 +rand.nextInt(50);
			int rCf= rand.nextInt(180);
			int gCf= rand.nextInt(255);
			int bCf= rand.nextInt(255);
			int rCc= rand.nextInt(180);
			int gCc= rand.nextInt(255);
			int bCc= rand.nextInt(255);
	
			int botao_clique = focus_but.idx;
	
			switch(botao_clique) { 
        	
			case 0:
				figs.add(new Rect(evt.getX(),evt.getY(), 50,50,255,255,255, 0,0,0));
			break;

			case 1:
				figs.add(new Ellipse(botao_x,botao_y,50,50, 255,255,255,0,0,0));
			break;
			
			case 2:
				figs.add(new Seta(botao_x,botao_y,50,50, 255,255,255,0,0,0));
			break;

			case 3:
				figs.add(new Triangle(botao_x,botao_y,50,50, 255,255,255,0,0,0));
			break;
			}

		if(!(aumentar || diminuir))							//nao tirando de foco quando o mais ou menos
			focus_but = null;							//estao ativados


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
					Rect r = new Rect(x,y,50,50, 255,255,255, 0,0,0);
					figs.add(r);
				}if(evt.getKeyChar() == 'e'){
					figs.add(new Ellipse(x,y,50,50, 255,255,250,0,0,0));
				}if(evt.getKeyChar() == 't'){
					Triangle tr= new Triangle(x,y,50,50,255,255,255,0,0,0);
					figs.add(tr);
				}if(evt.getKeyChar() == 's'){
					figs.add(new Seta(x,y,50,50, 255,255,250,0,0,0));
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
					
					if( indexFocus >= (figs.size() - 1))			//checando se o indexFocus é igual 
						indexFocus = -1;				//ao ultimo da fila ou maior.

					indexFocus++;
					focus = figs.get(indexFocus);
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
		fig.paint(g, fig == focus);
	}

	for(Button but: this.buts){
		but.paint(g, but == focus_but);

	}
	
	
	}



}
