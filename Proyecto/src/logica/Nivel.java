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
		
		random = new Random();
		
		while(!nivelFinalizado){
			
			try {
				Thread.sleep(3000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			numeroRandom = random.nextInt(6);
			if (!oleada1.oleadaFinalizada() || !logicaJuego.noHayEnemigos()){
				if (!oleada1.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(),logicaJuego.getTile(numeroRandom, 0));
			}
			else{
				modificarMapa();
				if(!oleada2.oleadaFinalizada()){
				logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(),logicaJuego.getTile(numeroRandom, 0));
				}
				else if(!oleada3.oleadaFinalizada()){
					logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(),logicaJuego.getTile(numeroRandom, 0));
				}
				else{
					nivelFinalizado = true;
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
			logicaJuego.getTile(x, y).setComponenteAtravesable(new Lava(logicaJuego.getTile(x, y)));
		}
		
	}
	
	public boolean nivelFinalizado(){
		return nivelFinalizado;
	}
	
	
	
}
