package objeto.noAtravesable.objetoConVida.OMConVida;

import game.gfx.ImageLoader;
import logica.Comprable;
import logica.Objeto;
import logica.Tile;

public class Barricada extends OMConVida implements Comprable{
	public Barricada(){
		vida = 200;
		maxVida = 200;
		alto = 1;
		ancho = 1;
		image = ImageLoader.barricada;
	}
	
	public void agregar(Tile t){
		t.setComponente(this);
		miTile = t;
	}
	
	public Objeto clone() {
		return new Barricada();
	}

	@Override
	public int getPrecio() {
		return 150;
	}

	@Override
	public int getPrecioVenta() {
		return 150;
	}

	@Override
	public void remover() {
		miTile.destruirObjeto(this);
		miTile.setComponente(null);
		miTile = null;
	}
}
