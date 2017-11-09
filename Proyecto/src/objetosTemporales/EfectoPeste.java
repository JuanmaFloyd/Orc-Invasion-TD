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

}
