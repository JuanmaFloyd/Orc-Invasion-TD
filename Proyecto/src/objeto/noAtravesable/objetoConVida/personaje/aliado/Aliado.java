package objeto.noAtravesable.objetoConVida.personaje.aliado;

import java.awt.Graphics;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Comprable;
import logica.Tienda;
import logica.Tile;
import logica.visitor.*;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.personaje.Personaje;

public abstract class Aliado extends Personaje implements Comprable {
	//atributos
	protected VisitorAliado v;
	protected Animation animation;
	protected int valor;
	
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
			miTile.destruirAliado(this);
			miTile = null;
		}
	}
	public void sumarVida(int v){
		vida+=v;
		if(vida>maxVida)
			vida=maxVida;
	}
	
	public void modificarAtaque(float modVelAtk){
		velocidadAt = (velAtMaxima / modVelAtk);
		animation.setAtkSpeed(velocidadAt);
	}
	
	public void normalizarAtaque(){
		velocidadAt = velAtMaxima;
		animation.setAtkSpeed(velocidadAt);
	}	
	
	public void accept(Visitor o){
		o.afectar(this);
	}
	
	public void dibujar(Graphics g){
		state.draw(g, this);
		g.drawImage(ImageLoader.vida[1], getTile().getColumna() * 64, getTile().getFila() * 64 + 128, 40, 4, null);
		g.drawImage(ImageLoader.vida[0], getTile().getColumna() * 64, getTile().getFila() * 64 + 128, (40*vida)/maxVida, 4, null);
		if(escudo>0)
			g.drawImage(ImageLoader.vida[2], getTile().getColumna() * 64, (getTile().getFila() * 64) + 135, (40*escudo)/maxEscudo, 4, null);
	}
	
	public void agregar(Tienda tien, Tile t){
		if(t.getComponente()==null){
			super.agregar(tien, t);
			tien.comprar(this);
			animation.setPos(t.getColumna(), t.getFila());
		}
	}
	
	public void setTile(Tile t){
		super.setTile(t);
		animation.setPos(t.getColumna(), t.getFila());
	}
	
	public int getPrecio(){
		return valor;
	}
	public int getPrecioVenta() {
		if(fullVida()){
			return valor;
		}
		else
			return valor/2;
	}
	public void remover(){
		miTile.destruirAliado(this);
		miTile.setComponente(null);
		miTile=null;
	}
}
