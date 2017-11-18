package logica;

import java.util.LinkedList;
import java.util.Random;

import objeto.atravesable.Lava;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.*;

/**
 * Clase NivelMedio
 * Extiende a la clase Nivel
 * Representa un nivel de dificultad media
 *
 */
public class NivelMedio extends Nivel{
	
	@Override
	public void init() {
		
		logicaJuego.setVidas(5);
		
		listaLava=new LinkedList<Lava>();
		
		LinkedList<Enemigo> lista1 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista2 = new LinkedList<Enemigo>();
		LinkedList<Enemigo> lista3 = new LinkedList<Enemigo>();
		
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(15);
			int esc = r.nextInt(10);
			if(e<3)
				lista1.addLast(new Goblin());
			else
				if(e<8)
					lista1.addLast(new Grunt());
				else
					if(e<12)
						lista1.addLast(new Brujo());
					else
						lista1.addLast(new Golem());
			if(esc<1)
				lista1.getLast().crearEscudo();
		}
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(15);
			int esc = r.nextInt(10);
			if(e<3)
				lista2.addLast(new Goblin());
			else
				if(e<8)
					lista2.addLast(new Grunt());
				else
					if(e<12)
						lista2.addLast(new Brujo());
					else
						lista2.addLast(new Golem());
			if(esc<1)
				lista2.getLast().crearEscudo();
		}
		for (int i=0; i<7; i++){
			Random r = new Random();
			int e = r.nextInt(15);
			int esc = r.nextInt(10);
			if(e<3)
				lista3.addLast(new Goblin());
			else
				if(e<8)
					lista3.addLast(new Grunt());
				else
					if(e<12)
						lista3.addLast(new Brujo());
					else
						lista3.addLast(new Golem());
			if(esc<1)
				lista3.getLast().crearEscudo();
		}
		
		oleada1 = new Oleada(lista1);
		oleada2 = new Oleada(lista2);
		oleada3 = new Oleada(lista3);
	}
	

}
