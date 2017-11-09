package game;

import logica.*;
import logica.visitor.VisitorClick;
import objeto.noAtravesable.ObjetoNoAtravesable;
import game.display.Display;
import game.gfx.GraphicsManager;
import game.gfx.ImageLoader;

/**
 * 
 * Clase Game
 * se encarga de correr el juego
 *
 */
public class Game implements Runnable{

	private Display display;
	public int width,height;
	public String title;
	private Logica myLogic;
	private GraphicsManager graphicsManager;
	private VisitorClick v;
	private UIState state;
	
	private Nivel nivel;
	
	private boolean running=false;
	private Thread thread;
	
	//Variables de prueba
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		
		ImageLoader.init(); 
		myLogic = Logica.getLogica();
		myLogic.generarMapa();
		graphicsManager = new GraphicsManager();
		
		display = new Display(title , width , height, this);
		display.setMenu();
		
		state = new MenuState();
		
		graphicsManager.setState(state);
		v = new VisitorClick();
	}
	
	private void update(){
		state.actualizar();
	}

	
	public void run(){
		
		init();
		graphicsManager.start();
		// Aca estabilizamos la cantidad de fps de la ejecucion del juego.
		
		int fps=60;
		double timePerTick = 1000000000/fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while(running){
			
			now = System.nanoTime();	
			delta += (now - lastTime) / timePerTick; // delta va a ir aumentando lentamente por cada vuelta del ciclo while
			lastTime = now;   

			if(delta >= 1){		// Cuando delta llegue a 1, llamo a los metodos update y render
				update();
				delta--;
			}
		}
		
		stop();
		
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
	
	/**
	 * Interactua con el mapa en un punto (x, y)
	 * @param x 
	 * @param y
	 */
	public void interaccion(int x, int y){
		Tile tile = myLogic.getTile(y/64, x/64);
			System.out.println("Orden de interactuar en "+ y/64+", "+x/64);
			if(tile.getComponente()!=null){
				ObjetoNoAtravesable o=tile.getComponente();
				o.accept(v);
			}
	}
	/**
	 * Retorna la logica
	 * @return logica
	 */
	public Logica getLogica(){
		return myLogic;
	}
	
	/**
	 * comienza un nivel n
	 * @param n
	 */
	public void empezarNivel(Nivel n){
		display.setJuego(v);
		nivel=n;
		
		graphicsManager = new GraphicsManager();
		graphicsManager.start();
		
		state = display.getState();
		graphicsManager.setState(state);
		nivel.start();
	}
}
