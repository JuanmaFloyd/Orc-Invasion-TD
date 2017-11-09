package game.display;

import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;

@SuppressWarnings("serial")
public class PanelInfoAliado extends PanelInfoPersonaje{
	
	//constructor
	public PanelInfoAliado(Aliado a){
		super(a);
		c.gridy=2;
		BotonVenta b = new BotonVenta(a);
		add(b, c);
	}

}
