package game.display;

import game.Game;
import logica.Logica;
import objeto.noAtravesable.objetoConVida.personaje.Mago;

public class StrategyMago extends Strategy{
	//atributos
	protected Game g;
	
	//constructor
	public StrategyMago(Game ga){
		g = ga;
	}
	
	//metodos
	public void comprar(int x, int y){
		Mago m = new Mago(g.getLogica().getTile(x, y));
		g.getLogica().getTienda().comprar(m, x, y);
	}
}
