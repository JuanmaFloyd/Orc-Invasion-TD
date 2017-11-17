package objeto.noAtravesable.objetoConVida.Premios;

import game.display.PremioManager;
import game.gfx.EfectoGrafico;
import game.gfx.EfectosManager;
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
		
		if (t.getComponente() != null){
			t.getComponente().restarVida(60);
			EfectosManager.agregarEfecto(new EfectoGrafico(t.getColumna()*64, t.getFila()*64 + 128, 1.5f, ImageLoader.bomb));
		}
		
		if (t.getColumna() != 0 && t.getLeft().getComponente() != null){
			t.getLeft().getComponente().restarVida(35);
			EfectosManager.agregarEfecto(new EfectoGrafico(t.getLeft().getColumna()*64, t.getLeft().getFila()*64 + 128, 1.5f, ImageLoader.bomb));
		}
		
		if (t.getColumna() != 11 && t.getRight().getComponente() != null){
			t.getRight().getComponente().restarVida(35);
			EfectosManager.agregarEfecto(new EfectoGrafico(t.getRight().getColumna()*64, t.getRight().getFila()*64 + 128, 1.5f, ImageLoader.bomb));
		}
		
		if (t.getFila() != 0 && t.getArriba().getComponente() != null){
			t.getArriba().getComponente().restarVida(35);
			EfectosManager.agregarEfecto(new EfectoGrafico(t.getArriba().getColumna()*64, t.getArriba().getFila()*64 + 128, 1.5f, ImageLoader.bomb));
		}
		
		if (t.getFila() != 5 && t.getAbajo().getComponente() != null){
			t.getAbajo().getComponente().restarVida(35);
			EfectosManager.agregarEfecto(new EfectoGrafico(t.getAbajo().getColumna()*64, t.getAbajo().getFila()*64 + 128, 1.5f, ImageLoader.bomb));
		}
	}
}
