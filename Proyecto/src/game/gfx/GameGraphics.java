package game.gfx;

import java.awt.Graphics;
import logica.Logica;

/**
 * Clase GameGraphics
 * Representa los graficos del juego
 *
 */
public class GameGraphics {
	
	private Logica logic = Logica.getLogica();
	private Graphics g;
	
	public void setGraphics(Graphics g){
		this.g = g;
	}
	
	/**
	 * Dibuja el mapa del juego
	 */
	public void dibujarMapa(){
		g.drawImage(ImageLoader.fondo, 0, 0, ImageLoader.fondo.getWidth()*2,ImageLoader.fondo.getHeight()*2, null);
		int filas = logic.getFilas();
		int columnas = logic.getColumnas();
		for (int i = 0; i < filas ; i++){
			for (int j = 0; j < columnas; j++){
				if ((logic.getTile(i, j).getComponenteAtravesable())!=null){
					logic.getTile(i, j).getComponenteAtravesable().dibujar(g);
				}
			}
		}
		
		for (int i = 0; i < filas ; i++){
			for (int j = 0; j < columnas; j++){	
				if ((logic.getTile(i, j).getComponente())!=null){
					logic.getTile(i,j).getComponente().dibujar(g);
					
				}
			}
		}
		EfectosManager.dibujarEfectos(g);
		g.drawImage(ImageLoader.castillo, 0,0,ImageLoader.castillo.getWidth()*2, ImageLoader.castillo.getHeight()*2, null);
	}
	

}
