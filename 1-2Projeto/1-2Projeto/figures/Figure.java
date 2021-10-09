package figures;

import java.awt.Graphics;

public abstract class Figure {
	

	public  boolean contorno_foco= false;
	public  boolean contorno_tela= false;
	public  int z_Order=0;
	public	int x, y;
	public	int w, h;
	public	int rCf,gCf,bCf;	//rgb da Cor de fundo
	public	int rCc,gCc,bCc;	//rgb da Cor de contorno

			
	public abstract void resize(int new_w, int new_h);

	public abstract void drag(int mouseX, int MouseY);

	public abstract void paint (Graphics g);
}
