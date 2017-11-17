package game.gfx;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Clase EfectosManager
 * Se encarga de dibujar los efectos graficos
 *
 */
public class EfectosManager {
	
	
	private static LinkedList<EfectoGrafico> efectos = new LinkedList<EfectoGrafico>();
	private static LinkedList<EfectoGrafico> efectosAEliminar = new LinkedList<EfectoGrafico>();
	
	/**
	 * Agrega un efecto grafico al juego
	 * @param ef efecto
	 */
	public static void agregarEfecto(EfectoGrafico ef){
		efectos.addLast(ef);
	}
	
	/**
	 * Dibuja los efectos que hay en el juego
	 * @param g Graphics donde dibujar
	 */
	public static void dibujarEfectos(Graphics g){
		for(EfectoGrafico ef:efectos){
			ef.drawrAtk(g);
			if (ef.efectoFinalizado()){
				efectosAEliminar.addLast(ef);
			}
		}
		for (EfectoGrafico ef:efectosAEliminar){
			efectos.remove(ef);
		}
		efectosAEliminar.clear();
	}
	
}
