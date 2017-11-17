package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.EfectoGrafico;
import game.gfx.EfectosManager;
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
		EfectosManager.agregarEfecto(new EfectoGrafico(t.getColumna()*64, t.getFila()*64 + 128, 1.0f, ImageLoader.efectoMeteorito));
		if (t.getComponente() != null)
			t.getComponente().restarVida(40);
	}
}
