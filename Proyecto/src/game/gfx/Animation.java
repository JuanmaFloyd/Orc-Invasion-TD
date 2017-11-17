package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Clase Animation
 * Representa una animacion del juego
 *
 */
public class Animation {
	
	protected BufferedImage ataque[];
	protected int x, y, index, totalImages, indexTime, xOffset, yOffset;
	protected long lastTime, now, timer;
	
	public Animation (int x, int y, float atkSpeed , BufferedImage[] anim){
		ataque = anim;
		this.x = x;
		this.y = y;
		totalImages = anim.length;
		index = 0;
		indexTime = (int) (1000 * atkSpeed / totalImages);
		timer = 1;
		lastTime = System.currentTimeMillis();
	}
	
	/**
	 * Dibuja la animacion en el mapa
	 * @param g Graphics donde dibujar
	 * @param img Imagen a dibujar
	 */
	public void draw(Graphics g, BufferedImage img){
		g.drawImage(img, x + xOffset, y + yOffset - (img.getHeight() - 64), img.getWidth() , img.getHeight(), null);
	}
	
	/**
	 * Dibuja una imagen de la animacion y pasa a la siguiente
	 * @param g
	 */
	public void drawrAtk(Graphics g){
		BufferedImage img = ataque[index];
		g.drawImage(img, x + xOffset, y + yOffset - (img.getHeight() - 64), img.getWidth() , img.getHeight(), null);
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (timer > indexTime){
			index = (index + 1) % totalImages;
			timer = 0;
		}
	}
	
	/**
	 * setea la velocidad de la animacion
	 * @param value velocidad
	 */
	public void setAtkSpeed(float value){
		indexTime = (int) (1000 * value / totalImages);
	}
	
	/**
	 * setea la posicion de la animacion
	 * @param a columna
	 * @param b fila
	 */
	public void setPos(int a, int b){
		x = a*64;
		y = b*64;
	}
	
	/**
	 * Consulta la posicion en x
	 * @return x
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Consulta la posicion en y
	 * @return y
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Setea un offset para x
	 * @param x offset
	 */
	public void setXOffset(int x){
		xOffset = x;
	}
	
	/**
	 * Setea un offset para y
	 * @param y offset
	 */
	public void setYOffset(int y){
		yOffset = y;
	}
}
