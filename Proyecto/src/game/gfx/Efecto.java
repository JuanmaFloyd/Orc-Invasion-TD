package game.gfx;

import java.awt.image.BufferedImage;

import logica.Objeto;

public class Efecto extends Animation {

	public Efecto(Objeto ob, int x, int y, float atkSpeed, BufferedImage[] anim) {
		super(x, y, atkSpeed, anim);
	}

	public boolean efectoFinalizado(){
		return index == totalImages-1;
	}
	
}
