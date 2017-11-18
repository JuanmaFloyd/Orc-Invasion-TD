package logica;

/**
 * Clase ObjetoTemporal
 * Representa un objeto temporal del juego
 *
 */
public abstract class ObjetoTemporal {

	protected int reloj;
	protected static Logica logica = Logica.getLogica();
	
	public ObjetoTemporal(int reloj){
		this.reloj = reloj;
		logica.agregarObjetoTemporal(this);
	}
	
	/**
	 * Hace un efecto en la creacion del objeto
	 */
	public abstract void efectoInicial();
	
	/**
	 * Hace un efecto mientras el objeto siga vivo
	 */
	public abstract void efecto();
	
	/**
	 * Hace un efecto cuando el objeto muere
	 */
	public abstract void efectoFinal();
	
	/**
	 * Decrementa el reloj del objeto
	 */
	public void decrementarReloj(){
		reloj--;
		if (reloj == 0){
			efectoFinal();
			logica.agregarObjetoTemporalABorrar(this);
		}
		efecto();
	}
	
}
