package logica;

import java.util.LinkedList;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;

public class NivelFacil extends Nivel{

	@Override
	public void init() {
		
		LinkedList<Enemigo> lista = new LinkedList<Enemigo>();
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		lista.addLast(new Goblin());
		
		oleada1 = new Oleada(lista);
		oleada2 = new Oleada(lista);
		oleada3 = new Oleada(lista);
	}

}
