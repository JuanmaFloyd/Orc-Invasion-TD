package game;

/**
 * 
 * Interfaz UIState
 * Representa un estado del juego (menu principal, juego)
 *
 */
public interface UIState {
	
	/**
	 * Cambia los graficos necesarios
	 */
	public void render();
	/**
	 * Actualiza la logica cuando sea necesario
	 */
	public void actualizar();
	/**
	 * Pierde el nivel
	 */
	public void perderNivel();
	/**
	 * Gana el nivel
	 */
	public void ganarNivel();
	
}
