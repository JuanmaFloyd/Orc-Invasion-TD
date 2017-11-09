package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;
import objeto.atravesable.CharcoPeste;

public class Peste extends Premio{
	
	public Peste(){
		super();
		image = ImageLoader.pPeste;
		b = PremioManager.peste;
	}
	
	public Objeto clone() {
		return new Peste();
	}

	public void efecto(Tile t) {
		int x=t.getFila();
		int y=t.getColumna();
		
		if (x != 0 && y != 0 && t.getLeft().getArriba().getComponenteAtravesable()!=null)
			t.getLeft().setComponenteAtravesable(new CharcoPeste());
		
		if (x != 0 && t.getArriba().getComponenteAtravesable()!=null)
			t.getArriba().setComponenteAtravesable(new CharcoPeste());
		
		if (x != 0 && y != 11 && t.getArriba().getRight().getComponenteAtravesable()!=null)
			t.getArriba().setComponenteAtravesable(new CharcoPeste());
		
		if (y != 0 && t.getLeft().getComponenteAtravesable()!=null)
			t.getLeft().setComponenteAtravesable(new CharcoPeste());
		
		if (x != 5 && y != 0 && t.getAbajo().getLeft().getComponenteAtravesable()!=null)
			t.getAbajo().setComponenteAtravesable(new CharcoPeste());
		
		if (x != 5 && t.getAbajo().getComponenteAtravesable()!=null)
			t.getAbajo().setComponenteAtravesable(new CharcoPeste());
		
		if (x != 5 && y != 11 && t.getAbajo().getRight().getComponenteAtravesable()!=null)
			t.getAbajo().setComponenteAtravesable(new CharcoPeste());
		
		if (y != 11 && t.getRight().getComponenteAtravesable()!=null)
			t.getRight().setComponenteAtravesable(new CharcoPeste());
	}
}
