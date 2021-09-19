package figures;

import java.awt.Graphics;

public abstract class Figure {
	
	int x, y;
	int w, h;
	int rCf,gCf,bCf;	//rgb da Cor de fundo
	int rCc,gCc,bCc;	//rgb da Cor de contorno


	public abstract void paint (Graphics g);
}
