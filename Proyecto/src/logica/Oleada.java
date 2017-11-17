package logica;

import java.util.LinkedList;

import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class Oleada {

	private LinkedList<Enemigo> enemigos;
	
	public Oleada(LinkedList<Enemigo> enem){
		enemigos = enem;
	}
	
	public Enemigo liberarEnemigo(){	
			return enemigos.removeFirst();
	}
	
	public boolean oleadaFinalizada(){
		return enemigos.isEmpty();
	}
	
}
