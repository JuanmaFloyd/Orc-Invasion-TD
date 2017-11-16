package logica;

import java.util.LinkedList;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;

public class NivelVacio extends Nivel{

	@Override
	public void init() {
		
		logicaJuego.setVidas(5);
		
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista2 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista3 = new LinkedList<Enemigo>();
		
		oleada1 = new Oleada(lista1);
		oleada2 = new Oleada(lista2);
		oleada3 = new Oleada(lista3);
	}

}
