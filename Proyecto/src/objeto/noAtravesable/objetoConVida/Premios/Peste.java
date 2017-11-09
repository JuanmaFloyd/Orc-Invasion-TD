package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Logica;
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
		
		if (t.getComponenteAtravesable() == null){
			CharcoPeste cp = new CharcoPeste(t);
			t.setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (x != 0 && y != 0 && t.getLeft().getArriba().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getLeft().getArriba());
			t.getLeft().getArriba().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (x != 0 && t.getArriba().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getArriba());
			t.getArriba().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (x != 0 && y != 11 && t.getArriba().getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getArriba().getRight());
			t.getArriba().getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (y != 0 && t.getLeft().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getLeft());
			t.getLeft().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (x != 5 && y != 0 && t.getAbajo().getLeft().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getAbajo().getLeft());
			t.getAbajo().getLeft().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			
		}
		
		if (x != 5 && t.getAbajo().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getAbajo());
			t.getAbajo().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (x != 5 && y != 11 && t.getAbajo().getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getAbajo().getRight());
			t.getAbajo().getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
		
		if (y != 11 && t.getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(t.getRight());
			t.getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
		}
	}
}
