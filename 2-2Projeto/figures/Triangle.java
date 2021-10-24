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

/*	System.out.format("x:%d y: %d  w:%d  h:%d\n",this.x, this.y, this.w, this.h);
	if( this.h < 0){
	this.y = this.y + this.h;
	this.h = this.h * -1;
	};
*/

//	System.out.format("x:%d y: %d  w:%d  h:%d\n",this.x, this.y, this.w, this.h);
      };


    public void drag(int mouseX, int mouseY){

	this.xPoints[0] = (mouseX - this.distanciaX);
	this.xPoints[1] = (mouseX - this.distanciaX)+(this.w/2);
	this.xPoints[2] = this.w+(mouseX - this.distanciaX);

	this.yPoints[0] = (mouseY - this.distanciaY);
	this.yPoints[1] = (mouseY - this.distanciaY)+this.h;
	this.yPoints[2] = (mouseY - this.distanciaY);

	this.x=(mouseX - this.distanciaX);
	this.y=(mouseY - this.distanciaY);

   };


    public void paint (Graphics g) {
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 3);
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 3);
	if (contorno_tela==true){
		g.setColor(Color.black);
		g.drawRect(this.x,this.y,this.w,this.h);
//		g.drawLine(x, y, x+w, y);
//		g.drawLine(x+w, y, x+w, y+h);
//		g.drawLine(x+w, y+h, x, y+h);
//		g.drawLine(x, y, x+w, y);

		g.setColor(Color.black);
		g.drawRect((this.x + this.w) - (this.w/6),(this.y + this.h) - (this.h/6),this.w/6,this.h/6);
	}
	if( contorno_foco == true){
		g.setColor(Color.red);
		g.drawRect(this.x,this.y,this.w,this.h);
//		g.drawLine(x, y, x+w, y);
    }

    }
}
