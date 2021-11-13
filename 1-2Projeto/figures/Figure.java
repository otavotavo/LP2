package figures;

import ivisible.IVisible;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable{
	
	public  boolean invertido = false;
	public  boolean contorno_tela= false;
	public  int z_Order=0;
	public	int x, y;
	public	int w, h;
	public	int rCf,gCf,bCf;	//rgb da Cor de fundo
	public	int rCc,gCc,bCc;	//rgb da Cor de contorno
	public  int distanciaX, distanciaY; //distancia do clique até as bordas
	public  int mudou_estado = 0;	

	public boolean clicked (int x, int y){
		return  (this.x <= x && x <= this.x + this.w && this.y<=y && y<=this.y+this.h);
	} 

	public boolean clicked_resize (int x, int y) {
		return (  ((this.x + this.w) - this.w/6) < x && x < (this.x + this.w ) &&  
                          ((this.y + this.h) - this.h/6) < y && y < (this.y + this.h));
	}        
	
	public abstract void resize(int new_w, int new_h);

	public abstract void drag(int mouseX, int MouseY);

}
