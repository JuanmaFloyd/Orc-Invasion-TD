package logica.visitor;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objetosTemporales.EfectoPeste;

public class VisitorPeste extends Visitor{
	
	public VisitorPeste(){}
	
	public void afectar(Aliado a){
		boolean afecte = false;
		if (!afecte && a != null){
			EfectoPeste ef = new EfectoPeste(600, a);
			afecte = true;
		}
		if (afecte && a == null){
			afecte = false;
		}
	}
	
	public void afectar(Enemigo e){
		boolean afecte = false;
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
