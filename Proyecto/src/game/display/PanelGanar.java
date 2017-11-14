package game.display;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public class PanelGanar extends JPanel {
	public PanelGanar(){
		setLayout(new CardLayout());
		
		JLabel fondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/FondoNivelTerminado.png")));
		add(fondo);
		setOpaque(true);
		setVisible(true);
	}
}
