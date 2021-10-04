package figures;

import java.awt.Graphics;

public abstract class Figure {
	
	public  int z_Order=0;
	public	int x, y;
	public	int w, h;
	public	int rCf,gCf,bCf;	//rgb da Cor de fundo
	public	int rCc,gCc,bCc;	//rgb da Cor de contorno


	public abstract void paint (Graphics g);
}
