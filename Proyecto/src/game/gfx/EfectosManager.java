package game.gfx;

import java.awt.Graphics;
import java.util.LinkedList;

public class EfectosManager {
	
	
	private static LinkedList<EfectoGrafico> efectos = new LinkedList<EfectoGrafico>();
	private static LinkedList<EfectoGrafico> efectosAEliminar = new LinkedList<EfectoGrafico>();
	
	public static void agregarEfecto(EfectoGrafico ef){
		efectos.addLast(ef);
	}
	
	public static void dibujarEfectos(Graphics g){
		for(EfectoGrafico ef:efectos){
			ef.drawrAtk(g);
			System.out.println("Dibuje");
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
