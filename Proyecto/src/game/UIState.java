package game;

/**
 * 
 * Interfaz UIState
 * representa un estado del juego (menu principal, juego, etc.)
 *
 */
public interface UIState {
	
	
	public void render();
	
	public void actualizar();
	
	public void interactuar();
	
}
