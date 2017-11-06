package logica.visitor;

import logica.Tile;
import objeto.noAtravesable.ObjectStateStatic;
import objeto.noAtravesable.objetoConVida.OMConVida.*;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorAliado extends Visitor {
	//atributos
	protected Aliado aliado;
	
	//constructor
	public VisitorAliado(Aliado a){
		aliado=a;
	}
	//metodos
	public void afectar(Aliado a) {}
	public void afectar(Enemigo e) {
		aliado.setState(aliado.getAttackingState());
		e.restarVida(aliado.getImpacto());
	}
	public void afectar(OMConVida omcv) {
		int pos = aliado.getTile().getColumna();
		int act = omcv.getTile().getColumna();
		Tile current = omcv.getTile().getLeft();
		boolean encontre = false;
		for (int i = pos-act; !encontre && i<aliado.getAlcance(); i++){
			if (current.getComponente()!=null){
				aliado.atacar(current.getComponente());
				encontre = true;
			}
			current = current.getLeft();
		}
		if (!encontre)	
			aliado.setState(new ObjectStateStatic());
	}
	public void afectar(Premio p) {
		int pos = aliado.getTile().getColumna();
		int act = p.getTile().getColumna();
		Tile current = p.getTile().getLeft();
		boolean encontre = false;
		for (int i = pos-act; !encontre && i<aliado.getAlcance(); i++){
			if (current.getComponente()!=null){
				aliado.atacar(current.getComponente());
				encontre = true;
			}
			current = current.getLeft();
		}
		if (!encontre)	
			aliado.setState(new ObjectStateStatic());
	}
}
