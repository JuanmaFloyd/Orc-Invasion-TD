package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;

public class Bomba extends Premio{
	
	public Bomba(){
		super();
		image = ImageLoader.pBomba;
		b = PremioManager.bomba;
	}
	
	public Objeto clone() {
		return new Bomba();
	}
	
	public void efecto(Tile t) {
		
		if (t.getComponente() != null)
			t.getComponente().restarVida(60);
		
		if (t.getColumna() != 0 && t.getLeft().getComponente() != null)
			t.getLeft().getComponente().restarVida(35);
		
		if (t.getColumna() != 11 && t.getRight().getComponente() != null)
			t.getRight().getComponente().restarVida(35);
		
		if (t.getFila() != 0 && t.getArriba().getComponente() != null)
			t.getArriba().getComponente().restarVida(35);
		
		if (t.getFila() != 5 && t.getAbajo().getComponente() != null)
			t.getAbajo().getComponente().restarVida(35);
	}
}
