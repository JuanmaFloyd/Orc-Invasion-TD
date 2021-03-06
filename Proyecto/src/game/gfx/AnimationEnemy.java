package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

/**
 * Clase AnimationEnemy
 * Extiende a la clase Animation
 * Representa la animacion de un enemigo
 *
 */
public class AnimationEnemy extends Animation {

	protected BufferedImage movement[];
	protected int pixelTime, pixelCounter;
	protected long movementTimer;
	protected Enemigo myEnemy;
	protected boolean stopped;
	
	public AnimationEnemy(Enemigo enemy, int x, int y, float atSpd, float movSpd , BufferedImage[] att, BufferedImage[] mov){
		super(x,y,atSpd,att);
		movement = mov;
		pixelTime = (int) ((1000 * movSpd) / 64);
		movementTimer = 1;
		myEnemy = enemy;
		pixelCounter = 0;
		stopped = false;
	}
	
	/**
	 * Cambia el estado de movimiento entre detenido y no detenido
	 */
	public void switchMovementState(){
		stopped = !stopped;
	}
	
	/**
	 * Dibuja una imagen del movimiento del enemigo y pasa a la siguiente imagen de la animacion
	 * @param g Graphics donde dibujar
	 */
	public void drawMove(Graphics g){
		if (!stopped){
			g.drawImage(movement[index], x + xOffset - (movement[index].getWidth() - 64), y + yOffset - (movement[index].getHeight() - 64), movement[index].getWidth() , movement[index].getHeight(), null);
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
			}
			if (timer > indexTime){
				index = (index + 1) % totalImages;
				timer = 0;
			}
		}
		else {
			g.drawImage(movement[index], x + xOffset - (movement[index].getWidth() - 64), y + yOffset - (movement[index].getHeight() - 64), ataque[index].getWidth() , movement[index].getHeight(), null);
		}
	}
	
	/**
	 * Setea la velocidad de la animacion de movimiento
	 * @param value velocidad
	 */
	public void setMovSpeed(float value){
		pixelTime = (int) ((1000 * value) / 64);
	}
	
	public void drawrAtk(Graphics g){
		g.drawImage(ataque[index], x + xOffset - (ataque[index].getWidth() - 64), y + yOffset - (ataque[index].getHeight() - 64), ataque[index].getWidth() , ataque[index].getHeight(), null);
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (timer > indexTime){
			index = (index + 1) % totalImages;
			timer = 0;
		}
	}

}
