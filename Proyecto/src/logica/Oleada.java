package logica;

import java.util.LinkedList;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

/**
 * Clase Oleada
 * Representa una oleada de un nivel
 *
 */
public class Oleada {

	private LinkedList<Enemigo> enemigos;
	
	public Oleada(LinkedList<Enemigo> enem){
		enemigos = enem;
	}
	
	/**
	 * Libera un enemigo de la oleada
	 * @return enemigo
	 */
	public Enemigo liberarEnemigo(){	
			return enemigos.removeFirst();
	}
	
	/**
	 * Consulta si finalizo la oleada
	 * @return finalizada
	 */
	public boolean oleadaFinalizada(){
		return enemigos.isEmpty();
	}
	
}
