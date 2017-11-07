package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class PortalOut extends ObjetoAtravesable{
	
	public PortalOut(Tile t){
		ancho=1;
		alto=1;
		miTile = t;
		t.setComponenteAtravesable(this);
		animation = new Animation(this, t.getColumna()*64, t.getFila()*64, 0.7f, ImageLoader.portalOrange);
		animation.setYOffset(128);
	}
	
	public void modificar(ObjetoNoAtravesable o){}
	public Objeto clone() {
		return new PortalOut(new Tile(null, 0, 0));
	}
}

