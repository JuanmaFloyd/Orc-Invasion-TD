package logica.visitor;

import game.gfx.EfectoGrafico;
import game.gfx.EfectosManager;
import game.gfx.ImageLoader;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorEscudo extends Visitor{

	@Override
	public void afectar(Aliado a) {
		a.crearEscudo();
		EfectosManager.agregarEfecto(new EfectoGrafico( a.getTile().getColumna()*64, a.getTile().getFila()*64 + 128, 1.0f, ImageLoader.shield));
	}
	public void afectar(Enemigo e) {}
	public void afectar(OMConVida omcv) {}
	public void afectar(Premio p) {}

}
