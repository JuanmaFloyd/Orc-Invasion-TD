package logica.visitor;


import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Clerigo;


public class VisitorClerigo extends VisitorAliado{
	public VisitorClerigo(Clerigo a){
		super(a);
	}
	public void afectar(Aliado a) {
		if (a.getVida() < a.getMaxVida()){
			a.sumarVida(5);
			aliado.setState(aliado.getAttackingState());
		}
		else{
			aliado.setState(aliado.getStaticState());
		}
	}
}

