package logica.visitor;

import logica.Logica;
import objeto.atravesable.PortalIn;
import objeto.atravesable.PortalOut;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorPortal extends Visitor{
	protected PortalOut po;
	protected PortalIn pi;
	protected int cant;
	
	public VisitorPortal(PortalOut o, PortalIn i){
		po = o;
		pi = i;
		cant = 0;
	}

	public void afectar(Aliado a) {}
	public void afectar(Enemigo e) {
		if(po.getTile().getComponente()==null){
			pi.getTile().setComponente(null);
			po.getTile().setComponente(e);
			e.setTile(po.getTile());
			cant++;
		}
		
		if (cant == 5){
			Logica.getLogica().agregarAtravesableABorrar(pi);
			pi.setVP(null);
			Logica.getLogica().agregarAtravesableABorrar(po);
			pi.getTile().setComponenteAtravesable(null);
			po.getTile().setComponenteAtravesable(null);
			pi.setTile(null);
			po.setTile(null);
		}
	}
	public void afectar(OMConVida omcv) {}
	public void afectar(Premio p) {} 
}