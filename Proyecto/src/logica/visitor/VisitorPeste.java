package logica.visitor;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objetosTemporales.EfectoPeste;

public class VisitorPeste extends Visitor{
	
	private boolean afecte;
	
	public VisitorPeste(){
		afecte = false;
	}
	
	public void afectar(Aliado a){
		if (!afecte && a != null){
			EfectoPeste ef = new EfectoPeste(600, a);
			afecte = true;
		}
		if (afecte && a == null){
			afecte = false;
		}
	}
	
	public void afectar(Enemigo e){
		if (!afecte && e != null){
			EfectoPeste ef = new EfectoPeste(600, e);
			afecte = true;
		}
		if (afecte && e == null){
			afecte = false;
		}
	}
	
	public void afectar(OMConVida omcv){}
	
	public void afectar(Premio p){}
}
