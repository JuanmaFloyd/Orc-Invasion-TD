package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Espadachin extends Aliado{
	//constructor
	public Espadachin(Tile t){
		super();
		miTile=t;
		velocidadAt=1.25f;
		velAtMaxima=1.25f;
		t.setComponente(this);
		image=ImageLoader.espadachin;
		vida=65;
		maxVida=65;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=20;
		alcance=1;
		valor=20;
		v=new VisitorAliado(this);
		animation = new Animation(t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.warriorAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new Espadachin(new Tile(null,0,0));
	}
}
