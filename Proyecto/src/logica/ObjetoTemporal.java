package logica;

public abstract class ObjetoTemporal {

	protected int reloj;
	protected static Logica logica = Logica.getLogica();
	
	public ObjetoTemporal(int reloj){
		this.reloj = reloj;
		logica.agregarObjetoTemporal(this);
	}
	
	public abstract void efectoInicial();
	
	public abstract void efecto();
	
	public abstract void efectoFinal();
	
	public void decrementarReloj(){
		reloj--;
		if (reloj == 0){
			efectoFinal();
			logica.agregarObjetoTemporalABorrar(this);
		}
		efecto();
	}
	
}
