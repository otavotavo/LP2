import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {

    static int coord_x = 0;
    static int coord_y = 37;
    static int lado = 50;  
    static int borda = 10;

    public  int    idx;
    private Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;

        this.fig.x = coord_x + borda + idx*lado;
        this.fig.y = borda + coord_y;
        this.fig.w = lado - (borda*2);
        this.fig.h = lado - (borda*2);



    }

    public boolean clicked (int x, int y) {


	return ( coord_x + (this.idx * lado) <= x && x <= coord_x +  ((this.idx + 1) * lado) && coord_y <= y && y <= coord_y + lado);

    }





    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;



	if(focused){
		g2d.setColor(Color.GRAY);
        	g2d.fillRect( coord_x + (this.idx * lado) , coord_y , lado , lado);
	}else{
		g2d.setColor(Color.LIGHT_GRAY);
        	g2d.fillRect( coord_x + (this.idx * lado) , coord_y , lado , lado);
	}



        g2d.setColor(Color.BLACK);
        g2d.drawRect( coord_x + (this.idx * lado) , coord_y , lado , lado);

        this.fig.paint(g, false);
    }
}
