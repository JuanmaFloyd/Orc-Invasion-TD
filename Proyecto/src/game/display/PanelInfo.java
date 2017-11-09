package game.display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import objeto.noAtravesable.objetoConVida.ObjetoConVida;

@SuppressWarnings("serial")
public class PanelInfo extends JPanel {
	//atributos
	protected GridBagConstraints c;
	protected JPanel info;
	
	//constructor
		public PanelInfo(ObjetoConVida a){
			setLayout(new GridBagLayout());
			
			c = new GridBagConstraints();
			c.gridx=0;
			c.gridy=0;
			c.weighty=0;
			
			JLabel imagen = new JLabel(new ImageIcon(a.getImage()));
			
			add(imagen, c);
			
			c.gridy=1;
			c.weighty=1;
			
			info = new JPanel(new GridLayout(1, 2));
			JLabel vidaMax = new JLabel("Vida maxima: "+a.getMaxVida());
			JLabel vida = new JLabel("Vida: "+a.getVida());
			info.add(vidaMax);
			info.add(vida);
			
			add(info, c);
			

			setVisible(true);
			setOpaque(true);
		}
}
