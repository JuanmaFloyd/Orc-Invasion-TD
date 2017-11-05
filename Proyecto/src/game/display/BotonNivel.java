package game.display;

import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import game.gfx.ImageLoader;
import logica.Nivel;

@SuppressWarnings("serial")
public class BotonNivel extends JLabel{
	//atributos
	private Nivel nivel;
	
	public BotonNivel(Nivel n, int i){
		
		nivel = n;
		
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonNivel.png")));
		setLayout(new CardLayout());
		addMouseListener(new OyenteNivel());
		
		JLabel nivel = new JLabel("nivel"+i);
		nivel.setHorizontalAlignment(CENTER);
		nivel.setVerticalAlignment(CENTER);
		add(nivel);
		
	}
	
	private class OyenteNivel implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
			setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonNivelPresionado.png")));
		}
		public void mouseReleased(MouseEvent arg0) {
			if(((BotonCompra)arg0.getSource()).isEnabled()){
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonNivel.png")));
			}
		}
	}
}
