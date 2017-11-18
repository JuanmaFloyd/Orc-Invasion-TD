package logica;

import logica.visitor.VisitorPortal;
import objeto.atravesable.PortalIn;
import objeto.atravesable.PortalOut;

/**
 * Clase Portal
 * Extiende a la clase Objeto
 * Implementa a la interfaz Comprable
 * Representa un portal del juego (con sus resprectivos portales de entrada y salida)
 *
 */
public class Portal extends Objeto implements Comprable{
	protected PortalIn pi;
	protected PortalOut po;
	
	
	public Portal(){
	}
	
	/**
	 * Retorna el portal de salida
	 * @return portal de salida
	 */
	public PortalOut getOut(){
		return po;
	}
	
	/**
	 * Retorna el portal de entrada
	 * @return portal de entrada
	 */
	public PortalIn getIn(){
		return pi;
	}

	public Objeto clone() {
		return new Portal();
	}
	public void agregar(Tienda tien, Tile t){
		if(pi==null && t.getComponenteAtravesable()==null){
			pi=new PortalIn(null, t);
			tien.comprar(this);
			tien.getPanel().setPrototype(this);
		}
		else{
			if(po==null && t.getComponenteAtravesable()==null){
				po=new PortalOut(t);
				VisitorPortal v = new VisitorPortal(po, pi);
				pi.setVP(v);
				tien.agregar(pi);
				tien.agregar(po);
			}
			else 
				if(po!=null)
					tien.getPanel().setPrototype(this);
		}
	}
	
	@Override
	public int getPrecio() {
		return 150;
	}

	@Override
	public int getPrecioVenta() {
		return 150;
	}

	public void remover() {
		pi.getTile().setComponenteAtravesable(null);
		pi.setTile(null);
		po.getTile().setComponenteAtravesable(null);
		po.setTile(null);
	}
}

