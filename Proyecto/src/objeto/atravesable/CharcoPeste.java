package objeto.atravesable;

import game.gfx.ImageLoader;
import logica.Objeto;
import logica.visitor.VisitorPeste;
import objeto.noAtravesable.ObjetoNoAtravesable;

public class CharcoPeste extends ObjetoAtravesable{
	private VisitorPeste visitor;
	
	public CharcoPeste(){
		visitor = new VisitorPeste();
		image = ImageLoader.peste;
	}
	@Override
	public void modificar(ObjetoNoAtravesable p) {
		p.accept(visitor);
	}

	@Override
	public Objeto clone() {
		return new CharcoPeste();
	}

}
