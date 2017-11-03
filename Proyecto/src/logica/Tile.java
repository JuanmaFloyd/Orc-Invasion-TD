package logica;

import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;
import objeto.atravesable.*;
import objeto.noAtravesable.ObjetoNoAtravesable;

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
	public ObjetoNoAtravesable getComponente(){
		return componente;
	}
	public ObjetoAtravesable getComponenteAtravesable(){
		return componenteAtravesable;
	}
	public void setComponente(ObjetoNoAtravesable o){
		componente=o;
	}
	public void setComponenteAtravesable(ObjetoAtravesable o){
		componenteAtravesable=o;
	}
	public int getFila(){
		return fila;
	}
	public int getColumna(){
		return columna;
	}
	public Tile getRight(){
		return miJuego.getTile(fila, columna+1);
	}
	public Tile getLeft(){
		return miJuego.getTile(fila, columna-1);
	}
	public Tile getAbajo(){
		return miJuego.getTile(fila+1, columna);
	}
	public Tile getArriba() {
		return miJuego.getTile(fila-1, columna);
	}
	public void destruirAliado(Aliado a){
		componente = null;
		miJuego.agregarAliadoABorrar(a);
	}
	public void agregarAliado(Aliado a){
		miJuego.agregarAliado(a);
	}
	public void destruirEnemigo(Enemigo e){
		componente = null;
		e.dropear();
		miJuego.agregarEnemigoABorrar(e);
		miJuego.agregarMonedas(e.getCoins());
	}
	public void destruirObjeto(OMConVida ocv){
		componente=null;
	}
	public Logica getLogica(){
		return miJuego;
	}

}
