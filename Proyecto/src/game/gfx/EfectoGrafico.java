package game.gfx;

import java.awt.image.BufferedImage;

import logica.Objeto;

public class EfectoGrafico extends Animation {

	public EfectoGrafico(int x, int y, float atkSpeed, BufferedImage[] anim) {
		super(x, y, atkSpeed, anim);
	}

	public boolean efectoFinalizado(){
		return index == totalImages-1;
	}
	
}
