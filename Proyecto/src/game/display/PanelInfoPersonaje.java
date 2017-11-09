package game.display;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objeto.noAtravesable.objetoConVida.personaje.Personaje;

@SuppressWarnings("serial")
public class PanelInfoPersonaje extends PanelInfo{
	//constructor
		public PanelInfoPersonaje(Personaje a){
			super(a);
			info = new JPanel(new GridLayout(2, 2));
			JLabel vidaMax = new JLabel("Vida maxima: "+a.getMaxVida());
			JLabel vida = new JLabel("Vida: "+a.getVida());
			JLabel impacto = new JLabel("Impacto: "+a.getImpacto());
			info.add(vidaMax);
			info.add(vida);
			info.add(impacto);
		}
}
