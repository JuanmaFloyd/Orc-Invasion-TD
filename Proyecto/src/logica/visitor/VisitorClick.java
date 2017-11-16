package logica.visitor;

import game.display.PanelTienda;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.enemigo.Enemigo;

public class VisitorClick extends Visitor{
	//atributos
	protected PanelTienda panel;
	
	//metodos
	public void afectar(Aliado a) {
		panel.mostrarInfoAliado(a);
	}
	public void afectar(Enemigo e) {
		panel.mostrarInfoEnemigo(e);
	}
	public void afectar(OMConVida omcv) {
		panel.mostrtarInfoOM(omcv);
	}
	public void afectar(Premio p) {
		panel.removerInfo();
		p.serClickeado();
		p.eliminar();
	}
	public void clickearNulo(){
		panel.removerInfo();
	}
	public void setPanel(PanelTienda pan){
		panel=pan;
	}

}
