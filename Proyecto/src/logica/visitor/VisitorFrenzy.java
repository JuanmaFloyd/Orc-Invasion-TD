package logica.visitor;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Frenzy;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorFrenzy extends Visitor {

	private Frenzy frenzy;
	
	public VisitorFrenzy(Frenzy frenzy){
		this.frenzy = frenzy;
	}
	
	@Override
	public void afectar(Aliado a) {
		frenzy.agregarALista(a);
	}

	@Override
	public void afectar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(OMConVida omcv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Premio p) {
		// TODO Auto-generated method stub
		
	}

}
