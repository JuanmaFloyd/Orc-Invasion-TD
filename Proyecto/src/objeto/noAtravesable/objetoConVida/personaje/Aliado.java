package objeto.noAtravesable.objetoConVida.personaje;

import java.awt.Graphics;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tienda;
import logica.Tile;
import logica.visitor.*;
import objeto.noAtravesable.ObjetoNoAtravesable;

public abstract class Aliado extends Personaje {
	//atributos
	protected VisitorAliado v;
	protected Animation animation;
	
	public Aliado(){
		super();
		state = stateStatic;
	}
	
	//metodos
	public void atacar(ObjetoNoAtravesable e){
		if(reloj==0){
			e.accept(v);
		}
	}
	
	public Animation getAnimation(){
		return animation;
	}
	
	public void restarVida(int v){
		vida-=v;
		if(vida<=0){
			miTile.destruirAliado(this);
			miTile = null;
		}
	}
	public void sumarVida(int v){
		vida+=v;
		if(vida>maxVida)
			vida=maxVida;
	}
	
	public void accept(Visitor o){
		o.afectar(this);
	}
	
	public void dibujar(Graphics g){
		g.drawImage(ImageLoader.vida[1], getTile().getColumna() * 64, getTile().getFila() * 64, 40, 4, null);
		g.drawImage(ImageLoader.vida[0], getTile().getColumna() * 64, getTile().getFila() * 64, (40*vida)/maxVida, 4, null);
		state.draw(g, this);
	}
	public void agregar(Tienda tien, Tile t){
		miTile=t;
		t.setComponente(this);
		tien.comprar(this);
		animation.setPos(t.getColumna(), t.getFila());
	}
}
