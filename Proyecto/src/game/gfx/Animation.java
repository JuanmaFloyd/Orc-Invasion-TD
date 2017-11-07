package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import logica.Objeto;

public class Animation {
	
	protected BufferedImage ataque[];
	protected int x, y, index, totalImages, indexTime, xOffset, yOffset;
	protected long lastTime, now, timer;
	protected Objeto o;
	
	public Animation (Objeto ob, int x, int y, float atkSpeed , BufferedImage[] anim){
		o=ob;
		ataque = anim;
		this.x = x;
		this.y = y;
		totalImages = anim.length;
		index = 0;
		indexTime = (int) (1000 * atkSpeed / totalImages);
		timer = 1;
		lastTime = System.currentTimeMillis();
	}
	
	public void drawrAtk(Graphics g){
		g.drawImage(ataque[index], x + xOffset , y + yOffset-((o.getAlto()-1)*64), o.getAncho()*64 , o.getAlto()*64 , null);
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (timer > indexTime){
			index = (index + 1) % totalImages;
			timer = 0;
		}
	}
	
	public void setAtkSpeed(float value){
		indexTime = (int) (1000 * value / totalImages);
	}
	
	public void setPos(int a, int b){
		x = a*64;
		y = b*64;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	public void setXOffset(int x){
		xOffset = x;
	}
	
	public void setYOffset(int y){
		yOffset = y;
	}
}
