package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import logica.Objeto;

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
	
	public void draw(Graphics g, BufferedImage img){
		g.drawImage(img, x + xOffset, y + yOffset - (img.getHeight() - 64), img.getWidth() , img.getHeight(), null);
	}
	
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
