package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorPeste;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class CharcoPeste extends ObjetoAtravesable{
	private VisitorPeste visitor;
	
	public CharcoPeste(Tile t){
		miTile = t;
		visitor = new VisitorPeste();
		image = ImageLoader.peste;
		animation = new Animation(this, t.getColumna()*64, t.getFila()*64, 0.5f, ImageLoader.pesteMov);
		animation.setYOffset(128);
	}
	@Override
	public void modificar(ObjetoNoAtravesable p) {
		p.accept(visitor);
	}

	@Override
	public Objeto clone() {
		return new CharcoPeste(null);
	}

}
