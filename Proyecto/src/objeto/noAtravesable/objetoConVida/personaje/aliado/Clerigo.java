package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorClerigo;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Clerigo extends Aliado {
	
	//constructor
	public Clerigo(Tile t){
		super();
		miTile=t;
		velocidadAt=1f;
		velAtMaxima=1f;
		t.setComponente(this);
		image=ImageLoader.monje;
		vida=30;
		maxVida=30;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=5;
		alcance=1;
		valor=40;
		v=new VisitorClerigo(this);
		animation = new Animation(t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.monkAtk);
		animation.setYOffset(128);
	}
	
	public ObjetoNoAtravesable clone(){
		return new Clerigo(new Tile(null, 0, 0));
	}
}
