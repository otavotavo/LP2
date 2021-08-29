package figures;

import java.awt.*;

public class Square {
    int x, y;
    int l;			// tamanho do lado do quadrado
	
	int rCf,gCf,bCf;	//rgb da Cor de fundo
	int rCc,gCc,bCc;	//rgb da Cor de contorno

	Square (int x, int y, int l, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
        this.x = x;
        this.y = y;
        this.l = l;
	this.rCf=rCf;
	this.gCf=gCf;	
	this.bCf=bCf;
	this.rCc=rCc;
	this.gCc=gCc;
	this.bCc=bCc;

    }

public     void print () {
        System.out.format("Quadrado de tamanho (%d) na posicao (%d,%d).\n",
            this.l, this.x, this.y);
    }




   public void paint (Graphics g) {
	g.setColor(new Color(this.rCf,this.gCf,this.bCf));
        g.drawRect(this.x,this.y, this.l,this.l);
	g.setColor(new Color(this.rCc, this.gCc,this.bCc));
	g.fillRect(this.x,this.y, this.l,this.l);

    }
}
