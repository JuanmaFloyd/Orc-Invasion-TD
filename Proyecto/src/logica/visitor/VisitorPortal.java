package logica.visitor;

import objeto.atravesable.PortalIn;
import objeto.atravesable.PortalOut;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorPortal extends Visitor{
	protected PortalOut po;
	protected PortalIn pi;
	
	public VisitorPortal(PortalOut o, PortalIn i){
		po = o;
		pi = i;
	}

	@Override
	public void afectar(Aliado a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo e) {
		if(po.getTile().getComponente()==null){
			pi.getTile().setComponente(null);
			po.getTile().setComponente(e);
			e.setTile(po.getTile());
		}
	}

	@Override
	public void afectar(OMConVida omcv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Premio p) {
		// TODO Auto-generated method stub
		
	} 
}