package figures; 

import java.awt.*;

public class Triangle extends Figure {
	
	int[] xPoints = new int[2];
	int[] yPoints = new int[2];
	int a;

	public	Triangle (int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
	this.rCf=rCf;
	this.gCf=gCf;	
	this.bCf=bCf;
	this.rCc=rCc;
	this.gCc=gCc;
	this.bCc=bCc;
	this.x=x;
	this.y=y;
	this.w=w+x;
	this.h=h+y;

	a=(x+((w-x)/2));

//	System.out.format("x:%d  y:%d  w:%d  h:%d\n",x,y,w,h);

	this.xPoints = new int[] {x, (x+((w-x)/2)) ,w};
	this.yPoints = new int[] {y, h, y};

	
    }






    public void print () {
        System.out.format("quadrado x0:%d x1:%d  x2:%d  y0:%d  y1:%d  y2:%d  \n",
            this.xPoints[0], this.xPoints[1],this.xPoints[2], this.yPoints[0], this.yPoints[1],this.yPoints[2]);
    }




    public void paint (Graphics g) {
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 3);
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 3);
//	System.out.format("paint x:%d  y:%d  w:%d  h:%d\n",this.x,this.y,this.w,this.h);

    }
}
