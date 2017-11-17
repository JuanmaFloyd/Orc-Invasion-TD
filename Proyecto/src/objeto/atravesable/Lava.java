package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorLava;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class Lava extends ObjetoAtravesable{
	//atributos
	protected VisitorLava v;
	protected int impacto;
	
	public Lava(Tile t){
		ancho=1;
		alto=1;
		miTile = t;
		impacto = 1;
		v = new VisitorLava(this);
		animation = new Animation(t.getColumna()*64, t.getFila()*64, 0.5f, ImageLoader.lava);
		animation.setYOffset(128);
	}
	public void modificar(ObjetoNoAtravesable o){
		o.accept(v);
	}
	public int getImpacto(){
		return impacto;
	}
	public Objeto clone() {
		return new Lava(new Tile(null, 0, 0));
	}
	public void remover() {
		miTile.destruirAtravesable(this);
	}
}
