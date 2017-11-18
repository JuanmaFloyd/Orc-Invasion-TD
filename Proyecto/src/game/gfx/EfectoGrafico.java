package game.gfx;

import java.awt.image.BufferedImage;

/**
 * Clase EfectoGrafico
 * Extiende a la clase Animation
 * Representa un efecto grafico del juego(lluvia de meteoritos, escudo, etc.)
 *
 */
public class EfectoGrafico extends Animation {

	public EfectoGrafico(int x, int y, float atkSpeed, BufferedImage[] anim) {
		super(x, y, atkSpeed, anim);
	}
	/**
	 * Consulta si termino el efecto
	 * @return terminado
	 */
	public boolean efectoFinalizado(){
		return index == totalImages-1;
	}
	
}
