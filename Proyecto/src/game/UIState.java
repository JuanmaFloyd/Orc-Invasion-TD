package game;

import java.awt.Graphics;

public interface UIState {
	
	
	public void render(Graphics g);
	
	public void actualizar();
	
	public void interactuar();
	
}
