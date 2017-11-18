package logica;

/**
 * Interfaz Comprable
 * Representa un elemento comprable del juego
 *
 */
public interface Comprable {

	/**
	 * Consulta el precio del objeto
	 * @return precio
	 */
	public int getPrecio();
	
	/**
	 * Clona al objeto
	 * @return clone
	 */
	public Objeto clone();
	
	/**
	 * Consulta el precio de venta del objeto
	 * @return precio de venta
	 */
	public int getPrecioVenta();
	
	/**
	 * Remueve al objeto del mapa
	 */
	public void remover();
}
