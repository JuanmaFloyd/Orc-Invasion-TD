package game.gfx;

import java.awt.Graphics;
import java.util.LinkedList;

public class Efectos {
	
	
	private static LinkedList<Efecto> efectos = new LinkedList<Efecto>();
	private LinkedList<Efecto> efectosAEliminar = new LinkedList<Efecto>();
	
	public static void agregarEfecto(Efecto ef){
		efectos.addLast(ef);
	}
	
	public void dibujarEfectos(Graphics g){
		for(Efecto ef:efectos){
			ef.drawrAtk(g);
		}
	}
	
	
	
}
