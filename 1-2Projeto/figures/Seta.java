package figures; 

import java.awt.*;

public class Seta extends Figure {
	
	int[] xPoints = new int[6];
	int[] yPoints = new int[6];
	int r;

	public	Seta (int r, int x, int y, int w, int h, int rCf, int gCf, int bCf, int rCc, int gCc, int bCc){
	this.rCf=rCf;
	this.gCf=gCf;	
	this.bCf=bCf;
	this.rCc=rCc;
	this.gCc=gCc;
	this.bCc=bCc;

	xPoints = new int[] {x, r, w, r+((w-r)/2), r+((w-r)/2) , x+((r-x)/2) ,x+((r-x)/2) };
	yPoints = new int[] {y+((h-y)/2), y, y+((h-y)/2), y+((h-y)/2) , h, h, y+((h-y)/2) };

    }






    public void print () {
        System.out.format("seta x0:%d x1:%d  x2:%d  y0:%d  y1:%d  y2:%d  \n",
            this.xPoints[0], this.xPoints[1],this.xPoints[2], this.yPoints[0], this.yPoints[1],this.yPoints[2]);
    }




    public void paint (Graphics g) {
	g.setColor(new Color(this.rCc,this.gCc,this.bCc));
        g.drawPolygon( xPoints, yPoints, 7);
	g.setColor(new Color(this.rCf, this.gCf,this.bCf));
	g.fillPolygon( xPoints, yPoints, 7);

    }
}
