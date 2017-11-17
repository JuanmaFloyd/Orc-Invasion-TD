package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorPortal;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class PortalIn extends ObjetoAtravesable{
	protected VisitorPortal v;
	
	public PortalIn(VisitorPortal v, Tile t){
		ancho=1;
		alto=1;
		this.v = v;
		miTile = t;
		t.setComponenteAtravesable(this);
		animation = new Animation(t.getColumna()*64, t.getFila()*64, 0.7f, ImageLoader.portalBlue);
		animation.setYOffset(128);
	}
	
	public void setVP(VisitorPortal v){
		this.v = v;
	}
	
	public void modificar(ObjetoNoAtravesable o) {
		o.accept(v);
	}
	public Objeto clone(){
		return new PortalIn(null, new Tile(null, 0, 0));
	}
	
}
