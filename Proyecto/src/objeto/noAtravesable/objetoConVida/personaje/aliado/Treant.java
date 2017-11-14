package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Treant extends Aliado{
	public Treant(Tile t){
		super();
		miTile=t;
		t.setComponente(this);
		velocidadAt=1.8f;
		velAtMaxima=1.8f;
		image=ImageLoader.treant;
		vida=100;
		maxVida=100;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=15;
		alcance=1;
		valor=0;
		v=new VisitorAliado(this);
		animation = new Animation(this, t.getColumna() * 64, t.getFila()*64, velocidadAt, ImageLoader.mageAtk);
		animation.setYOffset(128);
	}
	public ObjetoNoAtravesable clone(){
		return new EnanoCampeon(new Tile(null, 0, 0));
	}
	
	@Override
	public int getPrecio() {
		return valor;
	}
}
