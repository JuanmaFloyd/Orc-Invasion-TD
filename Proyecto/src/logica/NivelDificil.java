package logica;

import java.util.LinkedList;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.JefeOrco;

public class NivelDificil extends Nivel{
	
	public void init() {
		
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista2 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista3 = new LinkedList<Enemigo>();
		
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());
		lista1.addLast(new JefeOrco());

		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		lista2.addLast(new Goblin());
		
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		lista3.addLast(new Goblin());
		
		oleada1 = new Oleada(lista1);
		oleada2 = new Oleada(lista2);
		oleada3 = new Oleada(lista3);
	}

}
