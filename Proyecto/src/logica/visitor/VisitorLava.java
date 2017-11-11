package logica.visitor;

import logica.Logica;
import objeto.atravesable.Lava;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorLava extends Visitor {
	//atributos
	protected Lava lava;
	protected int n;
	
	//constructor
	public VisitorLava(Lava l){
		lava=l;
		n = 0;
	}
	public void afectar(Aliado a) {
		if (n % 10 == 0)
			a.restarVida(lava.getImpacto());
		n = n+1;
	}
	public void afectar(Enemigo e) {
		if (n % 10 == 0)	
			e.restarVida(lava.getImpacto());
		n = n+1;
	}
	public void afectar(OMConVida omcv) {
		omcv.restarVida(lava.getImpacto());
	}
	public void afectar(Premio p) {
		p.eliminar();
	}
	
}
