package game.display;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.Launcher;
import game.gfx.ImageLoader;
import logica.Nivel;

/**
 * Clase PanelGanar
 * Extiende a la clase JPanel de Java
 * Representa la pantalla que se muestra cuando se gana un nivel
 *
 */
@SuppressWarnings("serial")
public class PanelGanar extends JPanel {
	//atributos
	private Game g;
	
	public PanelGanar(Game ga, Nivel n){
		g=ga;
		setLayout(new CardLayout());
		
		JLabel fondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/ScreenVictory.png")));
		add(fondo);
		fondo.setLayout(new CardLayout());
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		
		BotonNivel siguiente = new BotonNivel(g, n.getSiguiente(), "siguiente");
		panel.add(siguiente, c);
		
		c.gridx=1;
		
		BotonMenu volver = new BotonMenu(g.getDisplay());
		panel.add(volver, c);
		
		panel.setVisible(true);
		panel.setOpaque(false);
		fondo.add(panel);
		
		setOpaque(true);
		setVisible(true);
	}
	private class BotonMenu extends JLabel{
		//atributos
		private Display d;
		
		public BotonMenu(Display dis){
			
			d=dis;
			
			setVisible(true);
			setOpaque(true);
			setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
			setLayout(new CardLayout());
			setOpaque(false);
			addMouseListener(new OyenteNivel());
			
			JLabel nivel = new JLabel("volver al menu principal");
			nivel.setFont(Launcher.fuente(20));
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
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonPresionado.png")));
			}
			public void mouseReleased(MouseEvent arg0) {
				if(((JLabel)arg0.getSource()).isEnabled()){
					setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
					d.setMenu(g);
				}
			}
		}
	}
}
