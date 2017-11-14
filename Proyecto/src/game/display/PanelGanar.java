package game.display;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.gfx.ImageLoader;
import logica.Nivel;

@SuppressWarnings("serial")
public class PanelGanar extends JPanel {
	//atributos
	private Game g;
	
	public PanelGanar(Game ga, Nivel n){
		g=ga;
		setLayout(new CardLayout());
		
		JLabel fondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/FondoNivelTerminado.png")));
		add(fondo);
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		
		BotonNivel siguiente = new BotonNivel(g, n.getSiguiente(), "siguiente");
		panel.add(siguiente, c);
		
		add(panel);
		
		setOpaque(true);
		setVisible(true);
	}
}
