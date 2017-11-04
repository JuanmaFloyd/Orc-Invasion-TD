package game.gfx;

import java.awt.Graphics;
import logica.Logica;


	
public class GameGraphics {
	
	private Logica logic;
	private Graphics g;
	
	public GameGraphics(Logica logic){
		this.logic = logic;
	}
	
	public void setGraphics(Graphics g){
		this.g = g;
	}
	
	public void dibujarMapa(){
		int filas = logic.getFilas();
		int columnas = logic.getColumnas();
		for (int i = 0; i < filas ; i++){
			for (int j = 0; j < columnas; j++){
				g.drawImage(ImageLoader.tierra, j*64, i*64, 64, 64, null );
				if ((logic.getTile(i, j).getComponenteAtravesable())!=null){
					//g.drawImage(logic.getTile(i, j).getComponenteAtravesable().getImage(), j*64, i*64, 64,64, null);
					logic.getTile(i, j).getComponenteAtravesable().dibujar(g);
					//logic.getTile(i, j).getComponenteAtravesable().getImage().drawrAtk(g);
				}
			}
		}
		
		for (int i = 0; i < filas ; i++){
			for (int j = 0; j < columnas; j++){
				
				if ((logic.getTile(i, j).getComponente())!=null){
					logic.getTile(i,j).getComponente().dibujar(g);
					//g.drawImage(logic.getTile(i, j).getComponente().getImage(), j*64, i*64, logic.getTile(i, j).getComponente().getAncho()*64,logic.getTile(i, j).getComponente().getAlto()*64, null);
				}
			}
		}
	}
	

}
