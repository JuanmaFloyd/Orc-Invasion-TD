package game.display;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public class PanelPerder extends JPanel{
	public PanelPerder(){
		JLabel fondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/FondoNivelTerminado.png")));
		add(fondo);
		setOpaque(true);
	}
}
