package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;

public class Fireball extends Premio{
	public Fireball(){
		super();
		image = ImageLoader.pBolaDeFuego;
		b = PremioManager.fireball;
	}
	public Objeto clone() {
		return new Fireball();
	}
	public void efecto(Tile t) {
		if (t.getComponente() != null)
			t.getComponente().restarVida(40);
	}
}
