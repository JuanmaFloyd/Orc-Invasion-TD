package objetosTemporales;

import logica.ObjetoTemporal;
import objeto.noAtravesable.objetoConVida.Premios.Peste;

public class EfectoCharcoPeste extends ObjetoTemporal{
	
	private Peste p;
	
	public EfectoCharcoPeste(Peste p, int reloj) {
		super(reloj);
		this.p = p;
	}

	@Override
	public void efectoInicial(){}

	@Override
	public void efecto() {}

	@Override
	public void efectoFinal() {
		p.removerCharcos();
	}
	
	public void decrementarReloj(){
		reloj--;
		if (reloj == 0){
			efectoFinal();
			logica.agregarObjetoTemporalABorrar(this);
		}
	}

}
