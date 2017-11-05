package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import logica.visitor.VisitorEscudo;

public class Escudo extends Premio{
	protected VisitorEscudo visitor;

	public Escudo(){
		super();
		visitor = new VisitorEscudo();
		image = ImageLoader.pEscudo;
		b = PremioManager.escudo;
	}
	public Objeto clone() {
		return new Escudo();
	}
	public void efecto(Tile t) {
		if(t.getComponente()!=null)
			t.getComponente().accept(visitor);
		int x=t.getFila();
		int y=t.getColumna();
		if (x != 0 && y != 0 && t.getLeft().getArriba().getComponente()!=null)
			t.getLeft().getArriba().getComponente().accept(visitor);
		if (x != 0 && t.getArriba().getComponente()!=null)
			t.getArriba().getComponente().accept(visitor);
		if (x != 0 && y != 11 && t.getArriba().getRight().getComponente()!=null)
			t.getArriba().getRight().getComponente().accept(visitor);
		if (y != 0 && t.getLeft().getComponente()!=null)
			t.getLeft().getComponente().accept(visitor);
		if (x != 5 && y != 0 && t.getAbajo().getLeft().getComponente()!=null)
			t.getAbajo().getLeft().getComponente().accept(visitor);
		if (x != 5 && t.getAbajo().getComponente()!=null)
			t.getAbajo().getComponente().accept(visitor);
		if (x != 5 && y != 11 && t.getAbajo().getRight().getComponente()!=null)
			t.getAbajo().getRight().getComponente().accept(visitor);
		if (y != 11 && t.getRight().getComponente()!=null)
			t.getRight().getComponente().accept(visitor);
	}
}
