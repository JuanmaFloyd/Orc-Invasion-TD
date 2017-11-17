package objeto.atravesable;

import game.gfx.Animation;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorPeste;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.Premios.Peste;

public class CharcoPeste extends ObjetoAtravesable{
	private VisitorPeste visitor;
	private Peste p;
	
	public CharcoPeste(Peste p, Tile t){
		miTile = t;
		t.setComponenteAtravesable(this);
		visitor = new VisitorPeste(p);
		image = ImageLoader.peste;
		animation = new Animation(t.getColumna()*64, t.getFila()*64, 0.5f, ImageLoader.pesteMov);
		animation.setYOffset(128);
	}
	@Override
	public void modificar(ObjetoNoAtravesable p) {
		p.accept(visitor);
	}

	@Override
	public Objeto clone() {
		return new CharcoPeste(p, null);
	}

}
