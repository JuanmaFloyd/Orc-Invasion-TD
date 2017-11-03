package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class AnimationEnemy extends Animation {

	protected BufferedImage movement[];
	protected int pixelTime, pixelCounter;
	protected long movementTimer;
	protected Enemigo myEnemy;
	protected boolean stopped;
	
	public AnimationEnemy(Enemigo enemy, int x, int y, float atSpd, float movSpd , BufferedImage[] att, BufferedImage[] mov){
		super(x,y,atSpd,att);
		movement = mov;
		pixelTime = (int) ((1000 * movSpd) / 64);// System.out.println(pixelTime);
		movementTimer = 1;
		myEnemy = enemy;
		pixelCounter = 0;
		stopped = false;
	}
	
	public void switchMovementState(){
		stopped = !stopped;
	}

	public void drawMove(Graphics g){
		if (!stopped){
			g.drawImage(movement[index], x, y, myEnemy.getAncho()*64,myEnemy.getAlto()*64, null);
			movementTimer += System.currentTimeMillis() - lastTime;
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if (movementTimer > pixelTime){
				x++;
				if (pixelCounter == 0){
					myEnemy.switchMovementState();
				}
				if (pixelCounter == 63){
					myEnemy.switchMovementState();
					stopped = !stopped;
				}
				pixelCounter = (pixelCounter + 1) % 64;
				movementTimer = 0;
				g.drawImage(ImageLoader.vida[1], x, y, 40, 4, null);
				g.drawImage(ImageLoader.vida[0], x, y, (40*myEnemy.getVida())/myEnemy.getMaxVida(), 4, null);
			}
			if (timer > indexTime){
				index = (index + 1) % totalImages;
				timer = 0;
			}
		}
		else {
			g.drawImage(movement[0], x, y, 64,64, null);
			g.drawImage(ImageLoader.vida[1], x, y, 40, 4, null);
			g.drawImage(ImageLoader.vida[0], x, y, (40*myEnemy.getVida())/myEnemy.getMaxVida(), 4, null);
		}
	}
	
	public void setMovSpeed(float value){
		pixelTime = (int) ((1000 * value) / 64);
	}
}
