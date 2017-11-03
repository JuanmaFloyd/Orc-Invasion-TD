package logica.visitor;

import objeto.atravesable.Lava;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorLava extends Visitor {
	//atributos
	protected Lava lava;
	
	//constructor
	public VisitorLava(Lava l){
		lava=l;
	}
	public void afectar(Aliado a) {
		a.restarVida(lava.getImpacto());
	}
	public void afectar(Enemigo e) {
		e.restarVida(lava.getImpacto());
	}
	public void afectar(OMConVida omcv) {
		omcv.restarVida(lava.getImpacto());
	}
	public void afectar(Premio p) {
		p.eliminar();
	}
	
}
