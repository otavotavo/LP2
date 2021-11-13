package figures; 

import java.awt.*;

public class Plus extends Figure {
	
	int[] xPoints = new int[12];
	int[] yPoints = new int[12];


	public	Plus (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
	this.rCf=rCf;
	this.gCf=gCf;	
	this.bCf=bCf;
	this.rCc=rCc;
	this.gCc=gCc;
	this.bCc=bCc;
	this.x=x;
	this.y=y;
	this.w=w;
	this.h=h;



	
    }


	public  void resize(int new_w, int new_h){
	System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n");
	};
	
	public  void drag(int mouseX, int MouseY){
	System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n");

	};



    public void paint (Graphics g, boolean focused) {

	Graphics2D g2d = (Graphics2D) g;


	int xPoints[] = {this.x, this.x+(this.w/3) ,this.x+(this.w/3), this.x+(this.w/3 * 2),this.x+(this.w/3 *2), this.x+this.w, 
	this.x+this.w, this.x+(this.w/3 *2),this.x+(this.w/3 * 2),this.x+(this.w/3), this.x+(this.w/3), this.x};
	
	int yPoints[] = {this.y+(this.h/3),this.y+(this.h/3),  this.y, this.y, this.y+(this.h/3),this.y+(this.h/3),
	this.y+(this.h/3 *2), this.y+(this.h/3 *2), this.y+this.h, this.y+this.h,this.y+(this.h/3 *2),  this.y+(this.h/3 *2)};  


	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 12);
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 12);

	}

}
