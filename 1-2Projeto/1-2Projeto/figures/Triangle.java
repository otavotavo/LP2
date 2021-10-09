package figures; 

import java.awt.*;

public class Triangle extends Figure {
	
	int[] xPoints = new int[2];
	int[] yPoints = new int[2];

	public	Triangle (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
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


	this.xPoints = new int[] {this.x, this.x+(this.w/2) ,this.w + this.x};
	this.yPoints = new int[] {this.y,  this.y + this.h, this.y};

	
    }






    public void print () {
        System.out.format("quadrado x0:%d x1:%d  x2:%d  y0:%d  y1:%d  y2:%d  \n",
            this.xPoints[0], this.xPoints[1],this.xPoints[2], this.yPoints[0], this.yPoints[1],this.yPoints[2]);
    }
	
    public void resize(int new_w, int new_h){
          new_w = new_w - this.xPoints[0];
          new_h = new_h - this.yPoints[0];
  
          this.w= new_w;
          this.h= new_h;
          
	this.xPoints[1] = this.x+(new_w/2);
	this.xPoints[2] = new_w+this.x;

	this.yPoints[1] = this.y+ new_h;
      };


    public void drag(int mouseX, int mouseY){

	this.xPoints[0] = mouseX;
	this.xPoints[1] = mouseX+(this.w/2);
	this.xPoints[2] = this.w+mouseX;

	this.yPoints[0] = mouseY;
	this.yPoints[1] = mouseY+this.h;
	this.yPoints[2] = mouseY;

	this.x=mouseX;
	this.y=mouseY;

   };


    public void paint (Graphics g) {
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 3);
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 3);
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
