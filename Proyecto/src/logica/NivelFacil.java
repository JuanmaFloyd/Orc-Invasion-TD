package logica;

import java.util.Random;
import java.util.LinkedList;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Goblin;

public class NivelFacil extends Nivel{

	@Override
	public void init() {
		
		random = new Random();
		numeroRandom = random.nextInt(6);
		LinkedList<Enemigo> lista = new LinkedList<Enemigo>();
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		numeroRandom = random.nextInt(6);
		lista.addLast(new Goblin(logicaJuego.getTile(numeroRandom, 0)));
		
		oleada1 = new Oleada(lista);
		oleada2 = new Oleada(lista);
		oleada3 = new Oleada(lista);
	}

}
