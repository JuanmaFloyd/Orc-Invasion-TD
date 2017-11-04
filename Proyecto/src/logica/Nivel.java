package logica;

import java.util.Random;

public abstract class Nivel implements Runnable{

	protected static Logica logicaJuego = Logica.getLogica();
	
	protected Oleada oleada1, oleada2, oleada3;
	private boolean nivelFinalizado = false, running = false;
	
	protected Random random;
	protected int numeroRandom;
	
	private Thread thread;
	
	public abstract void init();
	
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
		
		init();
		
		while(!nivelFinalizado){
			
			try {
				Thread.sleep(6000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (!oleada1.oleadaFinalizada()){
				logicaJuego.agregarEnemigo(oleada1.liberarEnemigo());
			}
			else if(!oleada2.oleadaFinalizada()){
				logicaJuego.agregarEnemigo(oleada2.liberarEnemigo());
			}
			else if(!oleada3.oleadaFinalizada()){
				logicaJuego.agregarEnemigo(oleada3.liberarEnemigo());
			}
			else{
				nivelFinalizado = true;
			}
		}
	}
	
	public boolean nivelFinalizado(){
		return nivelFinalizado;
	}
	
	
	
}
