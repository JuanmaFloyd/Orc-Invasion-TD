package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	
	protected BufferedImage ataque[];
	protected int x, y, index, totalImages, indexTime;
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
	
	public void drawrAtk(Graphics g){
		g.drawImage(ataque[index], x, y, 64 , 64 , null);
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
}
