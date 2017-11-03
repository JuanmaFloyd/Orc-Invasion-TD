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
		monedas=1000;
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
		monedas-=a.getValor();
		juego.agregarAliado(a);
		
	}
	public void comprar(OMConVida otcv){
		monedas-=otcv.getValor();
	}
	public void agregar(ObjetoAtravesable a){
		juego.agregarAtravesable(a);
	}
	//agregar comprar para temporales
	
	public void vender(ObjetoConVida a){
		if(a.fullVida()){
			a.getTile().setComponente(null);
			monedas+=a.getValor();
		}
		else{
			a.getTile().setComponente(null);
			monedas+=a.getValor()/2;
		}
	}
	
	//agregar vender para temporales
	
	public PanelTienda getPanel(){
		return miPanel;
	}
}
