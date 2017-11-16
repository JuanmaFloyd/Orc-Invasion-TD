package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.DisplayJuego;
import game.gfx.GameGraphics;
import logica.Logica;
/**
 * 
 * Clase GameState
 * Representa el estado de juego
 *
 */
public class GameState implements UIState{

	private GameGraphics graphics;
	private static Logica logica = Logica.getLogica();
	private DisplayJuego display;
	private BufferStrategy bs;
	
	
	public GameState(DisplayJuego display){
		this.display = display;
		this.graphics = new GameGraphics();
		logica.generarMapa();
	}
	
	@Override
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		graphics.setGraphics(g);
		graphics.dibujarMapa();
		
		bs.show();
		g.dispose();
	}

	public void actualizar() {
		logica.actualizar();
		display.actualizarPuntaje(logica.getScore());
	}

	public void interactuar() {
		
	}

	public void perderNivel() {
		display.perderNivel();
		
	}

	public void ganarNivel() {
		display.ganarNivel();
	}

	
	
}
