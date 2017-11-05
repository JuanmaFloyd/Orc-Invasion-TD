package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;

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
		
	}
}
