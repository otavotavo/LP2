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
	  int positionX, positionY;

          positionX = new_w - this.x;
          positionY = new_h - this.y;

          this.w= positionX;
          this.h= positionY;
          
	this.xPoints[1] = this.x+(positionX/2);
	this.xPoints[2] = positionX+this.x;
	


	if(mudou_estado == 0){
	if( new_h < this.y &&  this.invertido == false){		// codigo pra inverter no negativo
	this.h = this.h * -1;
	this.yPoints[0] = this.y + this.h;
	this.yPoints[1] = this.y;
	this.yPoints[2] = this.y + this.h;
		this.invertido = true;
	mudou_estado = 1;
		}else if( new_h < this.y &&  this.invertido == true){
	
	this.h = this.h * -1;
	this.yPoints[0] = this.y;
	this.yPoints[1] = this.y + this.h;
	this.yPoints[2] = this.y;
		this.invertido = false;
	mudou_estado = 1;
	}
	}

	if(this.invertido == false){			//codigo do resize
	this.yPoints[1] = this.y + this.h;
	}else{
	this.yPoints[0] = this.y + this.h;
	this.yPoints[2] = this.y + this.h;
	}

      };


    public void drag(int mouseX, int mouseY){

	this.xPoints[0] = (mouseX - this.distanciaX);
	this.xPoints[1] = (mouseX - this.distanciaX)+(this.w/2);
	this.xPoints[2] = this.w+(mouseX - this.distanciaX);

	if(this.invertido == false){
	this.yPoints[0] = (mouseY - this.distanciaY);
	this.yPoints[1] = (mouseY - this.distanciaY)+this.h;
	this.yPoints[2] = (mouseY - this.distanciaY);
	}else{
	this.yPoints[0] = (mouseY - this.distanciaY)+this.h;
	this.yPoints[1] = (mouseY - this.distanciaY);
	this.yPoints[2] = (mouseY - this.distanciaY)+this.h;
	}

	this.x=(mouseX - this.distanciaX);
	this.y=(mouseY - this.distanciaY);

   };


    public void paint (Graphics g, boolean focused) {

	Graphics2D g2d = (Graphics2D) g;


	int xPoints[] = {this.x, this.x+(this.w/2) ,this.w + this.x};				// preenchendo os arrays pois as figuras
	int yPoints[] = {this.y,  this.y + this.h, this.y};					// na intancia dos botoes pulam essa parte


	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 3);
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 3);
	if (contorno_tela==true){
		g.setColor(Color.black);
		g.drawRect(this.x,this.y,this.w,this.h);
		g.drawLine(x, y, x+w, y);
		g.drawLine(x+w, y, x+w, y+h);
		g.drawLine(x+w, y+h, x, y+h);
		g.drawLine(x, y, x+w, y);

		g.setColor(Color.black);
		g.drawRect((this.x + this.w) - (this.w/6),(this.y + this.h) - (this.h/6),this.w/6,this.h/6);
	}
	if (focused == true){
		g.setColor(Color.red);
		g.drawRect(this.x,this.y,this.w,this.h);
    }

    }
}
