package logica;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.atravesable.*;
import objeto.noAtravesable.ObjetoNoAtravesable;

/**
 * Clase Tile
 * Representa un Tile del tablero (mapa)
 *
 */
public class Tile {
	//atributos
	protected ObjetoNoAtravesable componente;
	protected ObjetoAtravesable componenteAtravesable;
	protected Logica miJuego;
	protected int fila, columna;
	
	
	//constructor
	public Tile(Logica j,int f, int c){
		componente=null;
		componenteAtravesable=null;
		fila=f;
		columna=c;
		miJuego=j;
	}
	
	//metodos
	/**
	 * Consulta el componente no atravesable que tiene encima
	 * @return componente no atravesable
	 */
	public ObjetoNoAtravesable getComponente(){
		return componente;
	}
	
	/**
	 * Consulta el componente atravesable que tiene encima
	 * @return componente atravesable
	 */
	public ObjetoAtravesable getComponenteAtravesable(){
		return componenteAtravesable;
	}
	
	/**
	 * Le setea un componente no atravesable encima
	 * @param o objeto no atravesable
	 */
	public void setComponente(ObjetoNoAtravesable o){
		componente=o;
	}

	/**
	 * Le setea un componente atravesable encima
	 * @param o objeto atravesable
	 */
	public void setComponenteAtravesable(ObjetoAtravesable o){
		componenteAtravesable=o;
	}
	
	/**
	 * Consulta la fila del tile
	 * @return fila
	 */
	public int getFila(){
		return fila;
	}
	
	/**
	 * Consulta la columna del tile
	 * @return columna
	 */
	public int getColumna(){
		return columna;
	}
	
	/**
	 * Consulta el tile a la derecha
	 * @return tile derecho
	 */
	public Tile getRight(){
		return miJuego.getTile(fila, columna+1);
	}
	
	/**
	 * Consulta el tile a la izquierda
	 * @return tile izquierdo
	 */
	public Tile getLeft(){
		return miJuego.getTile(fila, columna-1);
	}
	
	/**
	 * Consulta el tile de abajo
	 * @return tile de abajo
	 */
	public Tile getAbajo(){
		return miJuego.getTile(fila+1, columna);
	}
	
	/**
	 * Consulta el tile de arriba
	 * @return tile de arriba
	 */
	public Tile getArriba() {
		return miJuego.getTile(fila-1, columna);
	}
	
	/**
	 * Destruye un aliado que tenia encima
	 * @param a aliado
	 */
	public void destruirAliado(Aliado a){
		componente = null;
		miJuego.agregarAliadoABorrar(a);
	}
	
	/**
	 * Agrega un aliado a la logica
	 * @param a aliado
	 */
	public void agregarAliado(Aliado a){
		miJuego.agregarAliado(a);
	}
	
	/**
	 * Destruye un enemigo que tenia encima
	 * @param e enemigo
	 */
	public void destruirEnemigo(Enemigo e){
		componente = null;
		e.dropear();
		miJuego.agregarEnemigoABorrar(e);
		miJuego.agregarMonedas(e.getCoins());
		miJuego.agregarPuntos(e.getPuntaje());
	}
	
	/**
	 * Destruye un objeto de mapa que tenia encima
	 * @param ocv objeto de mapa
	 */
	public void destruirObjeto(OMConVida ocv){
		componente=null;
	}
	
	/**
	 * Destruye un objeto atravesable que tenia encima
	 * @param o objeto atravesable
	 */
	public void destruirAtravesable(ObjetoAtravesable o) {
		o.setTile(null);
		componenteAtravesable=null;
		miJuego.agregarAtravesableABorrar(o);
	}

}
