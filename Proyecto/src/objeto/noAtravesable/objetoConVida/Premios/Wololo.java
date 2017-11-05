package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;

public class Wololo extends Premio{
	//atributos
	protected VisitorWololo vw;
	
	public Wololo(){
		super();
		image = ImageLoader.pWololo;
		b = PremioManager.wololo;
		vw = new VisitorWololo();
	}
	public Objeto clone() {
		return new Wololo();
	}
	public void efecto(Tile t) {
		if (t.getComponente()!=null){
			t.getComponente().accept(vw, t);
		}
	}
}
