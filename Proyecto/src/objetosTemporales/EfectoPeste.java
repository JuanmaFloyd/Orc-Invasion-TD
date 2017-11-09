package objetosTemporales;

import logica.ObjetoTemporal;
import objeto.noAtravesable.objetoConVida.personaje.Personaje;

public class EfectoPeste extends ObjetoTemporal{
	
	Personaje j;
	
	public EfectoPeste(int reloj, Personaje j) {
		super(reloj);
		this.j = j;
	}

	@Override
	public void efectoInicial(){}

	@Override
	public void efecto() {
		j.restarVida(1);
	}

	@Override
	public void efectoFinal() {}
	
	public void decrementarReloj(){
		reloj--;
		if (reloj == 0){
			efectoFinal();
			logica.agregarObjetoTemporalABorrar(this);
		}
		if (reloj % 7 == 0 && j.getVida() > 0){
			efecto();
		}
	}

}
