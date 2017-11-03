package logica.visitor;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorClick extends Visitor{
	
	//metodos
	public void afectar(Aliado a) {
	}
	public void afectar(Enemigo e) {
		System.out.println(e.getVida());
	}
	public void afectar(OMConVida omcv) {
	}
	public void afectar(Premio p) {
		p.serClickeado();
		p.eliminar();
	}

}
