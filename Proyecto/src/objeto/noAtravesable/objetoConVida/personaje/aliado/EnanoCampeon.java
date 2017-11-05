package objeto.noAtravesable.objetoConVida.personaje.aliado;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorAliado;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class EnanoCampeon extends Aliado{
	public EnanoCampeon(Tile t){
		super();
		miTile=t;
		velocidadAt=1.5f;
		velAtMaxima=1.5f;
		t.setComponente(this);
		image=ImageLoader.campeonEnano;
		vida=130;
		maxVida=130;
		escudo = 0;
		maxEscudo = (int)(maxVida*0.2);
		ancho=1;
		alto=1;
		impacto=40;
		alcance=1;
		valor=65;
		v=new VisitorAliado(this);
		animation = new Animation(t.getFila() * 64,t.getColumna()*64, velocidadAt, ImageLoader.campeonEnanoAtk);
	}
	public ObjetoNoAtravesable clone(){
		return new EnanoCampeon(new Tile(null, 0, 0));
	}
	
	@Override
	public int getPrecio() {
		return valor;
	}
}
