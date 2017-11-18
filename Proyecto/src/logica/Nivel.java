package logica;

import java.util.LinkedList;
import java.util.Random;

import game.gfx.EfectoGrafico;
import game.gfx.EfectosManager;
import game.gfx.ImageLoader;
import objeto.atravesable.Lava;

/**
 * Clase Nivel
 * Implmenta la interfaz Runnable de Java
 * Representa un nivel del juego
 *
 */
public abstract class Nivel implements Runnable{

	protected static Logica logicaJuego = Logica.getLogica();
	
	protected Oleada oleada1, oleada2, oleada3;
	protected boolean running = false;
	private Nivel siguiente;
	private int monedas;
	
	protected LinkedList<Lava> listaLava;
	
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
		while(running){
			
			try {
				Thread.sleep(6000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			numeroRandom = random.nextInt(6);
			Tile tile = logicaJuego.getTile(numeroRandom,0);
			while (tile.getComponente() != null){
				numeroRandom = random.nextInt(6);
				tile = logicaJuego.getTile(numeroRandom,0);
			}
			if (!oleada1fin){
				if(!oleada1.oleadaFinalizada()){
					logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(), tile);
				}
				else if (logicaJuego.noHayEnemigos()){
					oleada1fin = true;
					reestablecerMapa();
					modificarMapa();
				}
			} else if (oleada1fin && !oleada2fin){
			if(!oleada2.oleadaFinalizada())
				logicaJuego.agregarEnemigo(oleada2.liberarEnemigo(),tile);
				else if (logicaJuego.noHayEnemigos()){
					oleada2fin = true;
					reestablecerMapa();
					modificarMapa();
				}
			} else if (!oleada3fin && oleada1fin && oleada2fin){
				if(!oleada3.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada3.liberarEnemigo(), tile);
					else if (logicaJuego.noHayEnemigos()){
						oleada3fin = true;
					}
				}
		}
	}
	
	/**
	 * Modifica el mapa entre oleadas
	 */
	public void modificarMapa(){
		Random r = new Random();
		for (int i = 0; i<3; i++){
			int x = r.nextInt(6);  //fila
			int y = r.nextInt(11) + 1;  //Columna
			EfectosManager.agregarEfecto(new EfectoGrafico(y*64, x*64 + 128, 1.0f, ImageLoader.efectoMeteorito));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (logicaJuego.getTile(x, y).getComponente() != null)
				logicaJuego.getTile(x, y).getComponente().restarVida(10000);
			Lava l = new Lava(logicaJuego.getTile(x, y));
			if (logicaJuego.getTile(x, y).getComponenteAtravesable() != null){
				logicaJuego.agregarAtravesableABorrar(logicaJuego.getTile(x, y).getComponenteAtravesable());
			}
			logicaJuego.getTile(x, y).setComponenteAtravesable(l);
			logicaJuego.agregarAtravesable(l);
			listaLava.addLast(l);
		}
		
	}
	
	/**
	 * Reestablece el mapa luego que paso una oleada
	 */
	public void reestablecerMapa(){
		for(Lava l:listaLava){
			l.remover();
		}
	}
	
	/**
	 * Consulta si se gano el nivel
	 * @return ganado
	 */
	public boolean ganado(){
		if(oleada3!=null)
			return oleada3.oleadaFinalizada() && logicaJuego.noHayEnemigos() && logicaJuego.getVidas()>0;
		else
			return false;
	}
	
	/**
	 * Consulta si se perdio el nivel
	 * @return perdido
	 */
	public boolean perdido(){
		if(oleada3!=null)
			return !oleada3.oleadaFinalizada() && logicaJuego.getVidas()==0;
		else
			return false;
	}
	
	/**
	 * Setea un nivel como siguiente
	 * @param n siguiente
	 */
	public void setSiguiente(Nivel n){
		siguiente=n;
	}
	
	/**
	 * Consulta el nivel siguiente
	 * @return siguiente
	 */
	public Nivel getSiguiente(){
		return siguiente;
	}
	
	/**
	 * Setea una cantidad de monedas de inicio del nivel
	 * @param m monedas de inicio
	 */
	public void setMonedasInicio(int m){
		monedas=m;
	}
	
	/**
	 * Consulta la cantidad de monedas de inicio
	 * @return monedas de inicio
	 */
	public int getMonedasInicio(){
		return monedas;
	}
	
}
