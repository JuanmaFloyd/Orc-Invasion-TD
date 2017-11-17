package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Arquero extends Aliado{
	//constructor
		public Arquero(Tile t){
			super();
			miTile=t;
			velocidadAt=1.0f;
			velAtMaxima=1.0f;
			t.setComponente(this);
			image=ImageLoader.arquero;
			vida=50;
			maxVida=50;
			escudo = 0;
			maxEscudo = (int)(maxVida*0.2);
			ancho=1;
			alto=1;
			impacto=5;
			alcance=3;
			valor=40;
			v=new VisitorAliado(this);
			animation = new Animation(t.getColumna() * 64,t.getFila()*64, velocidadAt, ImageLoader.arqueroAtk);
			animation.setYOffset(128);
		}
		
		public ObjetoNoAtravesable clone(){
			return new Arquero(new Tile(null, 0, 0));
		}
}
