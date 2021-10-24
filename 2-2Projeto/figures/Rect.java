package figures; 

import java.awt.*;

public class Rect extends Figure {

	public  Rect (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
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


    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }


    public void drag(int mouseX, int mouseY){
	this.x=mouseX - this.distanciaX;
	this.y=mouseY - this.distanciaY;
   };



    public void resize(int new_w, int new_h){
	
	new_w = new_w - this.x;
	new_h = new_h - this.y;

	this.w= new_w;
	this.h= new_h;
    };	

    public void paint (Graphics g) {
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillRect(this.x,this.y, this.w,this.h);
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawRect(this.x,this.y, this.w,this.h);
	if (contorno_tela==true){
		g.setColor(Color.black);
		g.drawRect(this.x,this.y,this.w,this.h);
		g.setColor(Color.black);
		g.drawRect((this.x + this.w) - (this.w/6),(this.y + this.h) - (this.h/6),this.w/6,this.h/6);
	}

	if( contorno_foco == true){
		g.setColor(Color.red);
		g.drawRect(this.x,this.y,this.w,this.h);
    }

    }
}
