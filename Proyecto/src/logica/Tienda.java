package logica;

import game.display.PanelTienda;
import objeto.atravesable.ObjetoAtravesable;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;

/**
 * Clase Tienda
 * Representa la tienda del juego
 *
 */
public class Tienda {
	
	//atributos
	protected int monedas;
	protected Logica juego;
	protected PanelTienda miPanel;
	protected static Tienda instance = null;

	//constructor
	private Tienda(Logica l){
		juego=l;
	}
	
	/**
	 * Setea un panel de la tienda
	 * @param p panel
	 */
	public void setPanel(PanelTienda p){
		miPanel=p;
	}
	
	public static Tienda getTienda(Logica l){
		if (instance == null)
			instance = new Tienda(l);
		
		return instance;
	}
	
	/**
	 * Suma una cierta cantidad de monedas a la tienda
	 * @param m monedas a sumar
	 */
	public void sumarMonedas(int m){
		monedas+=m;
	}
	
	/**
	 * Consulta la cantidad de monedas de la tienda
	 * @return monedas
	 */
	public int getMonedas(){
		return monedas;
	}
	
	/**
	 * Setea una cantidad de monedas en la tienda
	 * @param m nueva cantidad de monedas
	 */
	public void setMonedas(int m){
		monedas=m;
	}
	
	/**
	 * Compra una alianza
	 * @param val valor de la compra
	 */
	public void comprarAlianza(int val){
		//asumo que no se puede comprar la alianza si no se tiene el dinero
		monedas-=val;
	}
	
	/**
	 * Compra un aliado
	 * @param a aliado
	 */
	public void comprar(Aliado a){
		monedas -= a.getPrecio();
		juego.agregarAliado(a);
		
	}
	
	/**
	 * Compra un objeto comprable
	 * @param otcv comprable
	 */
	public void comprar(Comprable otcv){
		monedas-=otcv.getPrecio();
	}
	
	/**
	 * Agrega un objeto atravesable a la logica
	 * @param a objeto atravesable
	 */
	public void agregar(ObjetoAtravesable a){
		juego.agregarAtravesable(a);
	}
	
	/**
	 * Vende un objeto comprable
	 * @param otcv objeto comprable
	 */
	public void vender(Comprable otcv){
		monedas+=otcv.getPrecioVenta();
		otcv.remover();
	}
	
	/**
	 * Retorna el panel de la tienda
	 * @return panel
	 */
	public PanelTienda getPanel(){
		return miPanel;
	}
}
