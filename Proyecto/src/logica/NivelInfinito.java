package logica;

import java.util.LinkedList;
import java.util.Random;
import objeto.atravesable.Lava;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Brujo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Golem;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.JefeOrco;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.OrcoConBallesta;

/**
 * Clase NivelInfinito
 * Extiende a la clase Nivel
 * Representa un nivel infinito
 *
 */
public class NivelInfinito extends Nivel{
	
	public void init() {
		
		listaLava=new LinkedList<Lava>();
		
		logicaJuego.setVidas(5);
		
		generarOleada1();
		generarOleada2();
		generarOleada3();
	}
	public void run() {		
		
		init();
		boolean oleada1fin = false, oleada2fin = false, oleada3fin = false;
		random = new Random();
		while(running){
			
			try {
				Thread.sleep(500);
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
				if(!oleada1.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada1.liberarEnemigo(), tile);
				else if (logicaJuego.noHayEnemigos()){
					oleada1fin = true;
					reestablecerMapa();
					modificarMapa();
				}
			} else if (oleada1fin && !oleada2fin){
			if(!oleada2.oleadaFinalizada())
				logicaJuego.agregarEnemigo(oleada2.liberarEnemigo(), tile);
				else if (logicaJuego.noHayEnemigos()){
					oleada2fin = true;
					reestablecerMapa();
					modificarMapa();
				}
				generarOleada1();
			} else if (!oleada3fin && oleada1fin && oleada2fin){
				if(!oleada3.oleadaFinalizada())
					logicaJuego.agregarEnemigo(oleada3.liberarEnemigo(), tile);
					else if (logicaJuego.noHayEnemigos()){
						oleada3fin = true;
						reestablecerMapa();
						modificarMapa();
						generarOleada3();
					}
				}
				generarOleada1();
				generarOleada2();
		}
	}
	
	private void generarOleada1(){
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(17);
			int esc = r.nextInt(10);
			if(e<3)
				lista1.addLast(new Goblin());
			else
				if(e<8)
					lista1.addLast(new JefeOrco());
				else
					if(e<12)
						lista1.addLast(new Brujo());
					else 
						if(e<15)
							lista1.addLast(new Golem());
						else
							lista1.addLast(new OrcoConBallesta());
			if(esc<1)
				lista1.getLast().crearEscudo();
		}
		oleada1 = new Oleada(lista1);
	}
	private void generarOleada2(){
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(15);
			int esc = r.nextInt(10);
			if(e<3)
				lista1.addLast(new Goblin());
			else
				if(e<8)
					lista1.addLast(new JefeOrco());
				else
					if(e<12)
						lista1.addLast(new Brujo());
					else 
						if(e<15)
							lista1.addLast(new Golem());
						else
							lista1.addLast(new OrcoConBallesta());
			if(esc<1)
				lista1.getLast().crearEscudo();
		}
		oleada2 = new Oleada(lista1);
	}
	private void generarOleada3(){
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(15);
			int esc = r.nextInt(10);
			if(e<3)
				lista1.addLast(new Goblin());
			else
				if(e<8)
					lista1.addLast(new JefeOrco());
				else
					if(e<12)
						lista1.addLast(new Brujo());
					else 
						if(e<15)
							lista1.addLast(new Golem());
						else
							lista1.addLast(new OrcoConBallesta());
			if(esc<1)
				lista1.getLast().crearEscudo();
		}
		oleada3 = new Oleada(lista1);
	}
}
