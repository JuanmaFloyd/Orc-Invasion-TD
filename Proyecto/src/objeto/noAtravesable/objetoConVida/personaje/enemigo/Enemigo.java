package objeto.noAtravesable.objetoConVida.personaje.enemigo;

import logica.*;
import logica.visitor.*;
import objeto.noAtravesable.ObjectState;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.Personaje;

import java.awt.Graphics;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;

public abstract class Enemigo extends Personaje{
	//atributos
	protected float velocidadMov;
	protected float velMovMaxima;
	protected int puntaje;
	protected int coins, relojMov;
	protected VisitorEnemigo v;
	protected ObjectState stateMoving;
	protected AnimationEnemy animation;
	protected boolean detenido;
	protected Premio premio;

	public Enemigo(){
		super();
		stateMoving = new ObjectStateMoving();
		state = stateMoving;
		detenido = false;
		relojMov = 1;
	}
	
	//metodos
	public int getPuntaje(){
		return puntaje;
	}
	
	public ObjectState getMovingState(){
		return stateMoving;
	}
	
	public void atacar(ObjetoNoAtravesable ona){
		if(reloj==0){
			ona.accept(v);
		}
		reloj=(reloj+1)%(int)(velocidadAt*60);
	}
	
	public void modificarVelocidad(float rall){
		velocidadAt=(rall*velAtMaxima);
		velocidadMov=(velMovMaxima*rall);
		animation.setAtkSpeed(velocidadAt);
		animation.setMovSpeed(velocidadMov);
	}
	
	public void normalizarVelocidad(){
		velocidadMov=velMovMaxima;
		velocidadAt=velAtMaxima;
		animation.setAtkSpeed(velocidadAt);
		animation.setMovSpeed(velocidadMov);
	}
	
	public void avanzar(){
		if(!detenido && relojMov==0 && miTile.getRight().getComponente()==null){
			Tile sig = miTile.getRight();
			miTile.setComponente(null);
			miTile = sig;
			sig.setComponente(this);
			this.setTile(sig);
			normalizarVelocidad();
			animation.switchMovementState();
		}
		relojMov = (relojMov+1)%(int)(velocidadMov*60);
		if (detenido) relojMov = 0;
	}
	
	public void restarVida(int v){
		if(escudo > 0){
			escudo -= v;
			if(escudo < 0){
				vida += escudo;
				escudo = 0;
			}
		}
		else{
			vida-=v;
		}
		if(vida<=0){
			try{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("muerteEnem.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl = 
				(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-10.0f); 
				clip.start();
			} catch(Exception e){}
			miTile.destruirEnemigo(this);
			miTile = null;
		}
	}
	
	public int getCoins(){
		Random r = new Random();
		double ran = (r.nextInt((int) (0.2 * coins)) - (0.1 * coins));
		return (int) ran + coins;
	}
	
	public AnimationEnemy getAnimation(){
		return animation;
	}
	
	public void accept(Visitor o){
		o.afectar(this);
	}
	
	public void dibujar(Graphics g){
		state.draw(g, this);
		g.drawImage(ImageLoader.vida[1], animation.getX(), animation.getY() + 128, 40, 4, null);
		g.drawImage(ImageLoader.vida[0], animation.getX(), animation.getY() + 128, (40*getVida())/getMaxVida(), 4, null);
		if(escudo>0)
			g.drawImage(ImageLoader.vida[2], getTile().getColumna() * 64, (getTile().getFila() * 64) + 135, (40*escudo)/maxEscudo, 4, null);
	}
	
	public void switchMovementState(){
		detenido = !detenido;
	}
	
	public void setTile(Tile t){
		super.setTile(t);
		animation.setPos(t.getColumna(), t.getFila());
	}
	
	public void dropear(){
		Random r = new Random();
		int prob = r.nextInt(10);
		if (prob == 4){
			miTile.setComponente(premio);
			premio.setTile(miTile);
			System.out.println("dropie");
		}
	}
}
