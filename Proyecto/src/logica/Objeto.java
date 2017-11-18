package logica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Clase Objeto
 * Representa un objeto dentro del juego
 *
 */
public abstract class Objeto {
	//atributos
	protected Tile miTile;
	protected BufferedImage image;
	protected int ancho;
	protected int alto;
	
	//metodos
	/**
	 * Consulta la imagen del objeto
	 * @return imagen
	 */
	public BufferedImage getImage(){
		return image;
	}
	
	/**
	 * Consulta el tile en el que se encuentra el objeto
	 * @return tile
	 */
	public Tile getTile(){
		return miTile;
	}
	
	/**
	 * Le setea un tile al objeto
	 * @param t nuevo tile
	 */
	public void setTile(Tile t){
		miTile=t;
	}
	
	/**
	 * Consulta el ancho del objeto
	 * @return ancho
	 */
	public int getAncho(){
		return ancho;
	}
	
	/**
	 * Consulta el alto del objeto
	 * @return alto
	 */
	public int getAlto(){
		return alto;
	}
	
	/**
	 * Agrega al objeto en un Tile del mapa
	 * @param tien tienda del juego
	 * @param t tile 
	 */
	public abstract void agregar(Tienda tien, Tile t);
	
	/**
	 * Dibuja al objeto en el mapa
	 * @param g Graphics donde dibujar
	 */
	public void dibujar(Graphics g){}
	
	/**
	 * clona al objeto
	 * @return clon
	 */
	public abstract Objeto clone();
}
