package game.display;

import logica.Tienda;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;

@SuppressWarnings("serial")
public class PanelInfoAliado extends PanelInfoPersonaje{
	
	//constructor
	public PanelInfoAliado(Aliado a, Tienda t){
		super(a);
		c.gridy=1;
		c.gridx=1;
		BotonVenta b = new BotonVenta(a, t);
		add(b, c);
	}

}
