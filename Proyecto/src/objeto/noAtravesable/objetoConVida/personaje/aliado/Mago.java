package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.*;
import logica.*;
import logica.visitor.*;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Mago extends Aliado {
	//constructor
	public Mago(Tile t){
		super();
		miTile=t;
		velocidadAt=2.0f;
		velAtMaxima=2.0f;
		t.setComponente(this);
		image=ImageLoader.mago;
		vida=40;
		maxVida=40;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=10;
		alcance=4;
		valor=70;
		v=new VisitorAliado(this);
		animation = new Animation(this, t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.mageAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new Mago(new Tile(null, 0, 0));
	}
}
