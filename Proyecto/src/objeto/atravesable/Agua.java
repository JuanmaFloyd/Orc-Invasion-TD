package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.*;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.personaje.Personaje;

public class Agua extends ObjetoAtravesable{
	//atributos
	protected float rall;
	protected VisitorAgua v;
	
	//constructor
	public Agua(Tile t){
		rall=1.5f;
		v=new VisitorAgua(this);
		miTile = t;
		animation = new Animation(t.getColumna()*64, t.getFila()*64, 0.5f, ImageLoader.aguaMov);
	}
	
	//metodos
	public void modificar(ObjetoNoAtravesable o){
		o.accept(v);
	}
	public float getRall(){
		return rall;
	}
	public Objeto clone() {
		return new Agua(new Tile(null, 0, 0));
	}

}
