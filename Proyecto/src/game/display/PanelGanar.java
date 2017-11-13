package game.display;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public class PanelGanar extends JPanel {
	public PanelGanar(){
		JLabel fondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/FondoNivelTerminado.png")));
		add(fondo);
	}
}
