package objeto.noAtravesable.objetoConVida.Premios;

import java.util.LinkedList;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Logica;
import logica.Objeto;
import logica.Tile;
import objeto.atravesable.CharcoPeste;
import objetosTemporales.EfectoCharcoPeste;

public class Peste extends Premio{
	//atributos
	private LinkedList<CharcoPeste> charcos;
	
	//constructor
	public Peste(){
		super();
		EfectoCharcoPeste e = new EfectoCharcoPeste(this, 600);
		charcos = new LinkedList<CharcoPeste>();
		image = ImageLoader.pPeste;
		b = PremioManager.peste;
	}
	
	//metodos
	public Objeto clone() {
		return new Peste();
	}

	public void efecto(Tile t) {
		int x=t.getFila();
		int y=t.getColumna();
		
		if (t.getComponenteAtravesable() == null){
			CharcoPeste cp = new CharcoPeste(this, t);
			t.setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (x != 0 && y != 0 && t.getLeft().getArriba().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getLeft().getArriba());
			t.getLeft().getArriba().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (x != 0 && t.getArriba().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getArriba());
			t.getArriba().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (x != 0 && y != 11 && t.getArriba().getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getArriba().getRight());
			t.getArriba().getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (y != 0 && t.getLeft().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getLeft());
			t.getLeft().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (x != 5 && y != 0 && t.getAbajo().getLeft().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getAbajo().getLeft());
			t.getAbajo().getLeft().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
			
		}
		
		if (x != 5 && t.getAbajo().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getAbajo());
			t.getAbajo().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (x != 5 && y != 11 && t.getAbajo().getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getAbajo().getRight());
			t.getAbajo().getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
		
		if (y != 11 && t.getRight().getComponenteAtravesable()==null){
			CharcoPeste cp = new CharcoPeste(this, t.getRight());
			t.getRight().setComponenteAtravesable(cp);
			Logica.getLogica().agregarAtravesable(cp);
			charcos.addLast(cp);
		}
	}
	public void removerCharcos(){
		for(CharcoPeste cp: charcos){
			cp.getTile().destruirAtravesable(cp);
		}
	}
}
