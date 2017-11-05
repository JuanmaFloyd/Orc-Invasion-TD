package logica;

import java.util.Random;

import objeto.atravesable.Lava;

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
		boolean oleada1fin = false, oleada2fin = false, oleada3fin = false;
		random = new Random();
		while(!nivelFinalizado){
			
			try {
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			numeroRandom = random.nextInt(6);
			if (!oleada1fin){
				if(!oleada1.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(), logicaJuego.getTile(numeroRandom, 0));
				else if (logicaJuego.noHayEnemigos()){
					oleada1fin = true;
					modificarMapa();
				}
			} else if (oleada1fin && !oleada2fin){
			if(!oleada2.oleadaFinalizada())
				logicaJuego.agregarEnemigo(oleada2.liberarEnemigo(), logicaJuego.getTile(numeroRandom, 0));
				else if (logicaJuego.noHayEnemigos()){
					oleada2fin = true;
					modificarMapa();
				}
			} else if (!oleada3fin && oleada1fin && oleada2fin){
				if(!oleada3.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada3.liberarEnemigo(), logicaJuego.getTile(numeroRandom, 0));
					else if (logicaJuego.noHayEnemigos()){
						oleada3fin = true;
						modificarMapa();
					}
				}
		}
	}
	
	public void modificarMapa(){
		Random r = new Random();
		for (int i = 0; i<3; i++){
			int x = r.nextInt(6);
			int y = r.nextInt(12);
			if (logicaJuego.getTile(x, y).getComponente() != null)
				logicaJuego.getTile(x, y).getComponente().restarVida(10000);
			Lava l = new Lava(logicaJuego.getTile(x, y));
			logicaJuego.getTile(x, y).setComponenteAtravesable(l);
			logicaJuego.agregarAtravesable(l);
		}
		
	}
	
	public boolean nivelFinalizado(){
		return nivelFinalizado;
	}
	
	
	
}
