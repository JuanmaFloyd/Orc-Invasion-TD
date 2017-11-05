package game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.UIState;
import game.display.Display;
import logica.Logica;

public class GraphicsManager implements Runnable{

	private GameGraphics myGraphics;
	private Display display;
	private boolean running = false;
	private Thread thread;
	private Logica myLogic;
	private BufferStrategy bs;
	private Graphics g;
	private UIState state;
	
	public GraphicsManager (Display display){
		this.display = display;
		myLogic = Logica.getLogica();
		myLogic.generarMapa();
	}
	
	public void setState(UIState state){
		this.state = state;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int fps = 60;
		double timePerTick = 1000000000/fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while(running){
			
			now = System.nanoTime();	
			delta += (now - lastTime) / timePerTick; // delta va a ir aumentando lentamente por cada vuelta del ciclo while
			lastTime = now;   

			if(delta >= 1){		// Cuando delta llegue a 1, llamo a los metodos update y render
				render();
				delta--;
			}
		}
		
		stop();
		
	}

	private void render(){
		
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//myGraphics.setGraphics(g);
		//myGraphics.dibujarMapa();
		
		state.render(g);
		
		bs.show();
		g.dispose();
	}
	
}
