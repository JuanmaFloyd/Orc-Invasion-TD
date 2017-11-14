package logica;

import game.display.PanelTienda;
import objeto.atravesable.ObjetoAtravesable;
import objeto.noAtravesable.objetoConVida.ObjetoConVida;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;

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
	
	public void setPanel(PanelTienda p){
		miPanel=p;
	}
	
	public static Tienda getTienda(Logica l){
		if (instance == null)
			instance = new Tienda(l);
		
		return instance;
	}
	
	public void sumarMonedas(int m){
		monedas+=m;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	public void comprarAlianza(int val){
		//asumo que no se puede comprar la alianza si no se tiene el dinero
		monedas-=val;
	}
	
	public void comprar(Aliado a){
		monedas -= a.getPrecio();
		juego.agregarAliado(a);
		
	}
	
	public void comprar(Comprable otcv){
		monedas-=otcv.getPrecio();
	}
	
	public void agregar(ObjetoAtravesable a){
		juego.agregarAtravesable(a);
	}
	
	public void vender(Comprable otcv){
		monedas+=otcv.getPrecioVenta();
		otcv.remover();
	}
	
	public PanelTienda getPanel(){
		return miPanel;
	}
}
