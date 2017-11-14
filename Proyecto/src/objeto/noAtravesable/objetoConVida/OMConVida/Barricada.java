package objeto.noAtravesable.objetoConVida.OMConVida;

import game.gfx.ImageLoader;
import logica.Objeto;
import logica.Tile;

public class Barricada extends OMConVida{
	public Barricada(){
		vida = 200;
		maxVida = 200;
		alto = 1;
		ancho = 1;
		image = ImageLoader.arbol;
	}
	
	public void agregar(Tile t){
		t.setComponente(this);
		miTile = t;
		Barricada n = new Barricada();
		if (t.getFila() < 5){
			miTile.getArriba().setComponente(n);
			n.setTile(t.getArriba());
		} else {
			miTile.getAbajo().setComponente(n);
			n.setTile(t.getAbajo());
		}
	}
	
	public Objeto clone() {
		return new Barricada();
	}
}
