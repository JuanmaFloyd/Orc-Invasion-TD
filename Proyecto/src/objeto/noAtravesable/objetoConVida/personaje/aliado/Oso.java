package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Oso extends Aliado{
	//constructor
	public Oso(Tile t){
		super();
		miTile=t;
		velocidadAt=1.6f;
		velAtMaxima=1.6f;
		t.setComponente(this);
		image=ImageLoader.oso;
		vida=60;
		maxVida=60;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=30;
		alcance=1;
		valor=0;
		v=new VisitorAliado(this);
		animation = new Animation(t.getColumna() * 64,t.getFila()*64, velocidadAt, ImageLoader.mageAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new Oso(new Tile(null, 0, 0));
	}
}
