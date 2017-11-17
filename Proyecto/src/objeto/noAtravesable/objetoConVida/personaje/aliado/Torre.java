package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Torre extends Aliado{
	public Torre(Tile t){
		super();
		miTile=t;
		velocidadAt=1.25f;
		velAtMaxima=1.25f;
		t.setComponente(this);
		image=ImageLoader.torre;
		vida=150;
		maxVida=150;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=8;
		alcance=5;
		valor=150;
		v=new VisitorAliado(this);
		animation = new Animation(t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.torreAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new Torre(new Tile(null,0,0));
	}
}
