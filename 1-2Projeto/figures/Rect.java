package figures; 

import java.awt.*;

public class Rect extends Figure {
	

	public	Rect (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
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




    public void paint (Graphics g) {
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawRect(this.x,this.y, this.w,this.h);
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillRect(this.x,this.y, this.w,this.h);

    }
}
