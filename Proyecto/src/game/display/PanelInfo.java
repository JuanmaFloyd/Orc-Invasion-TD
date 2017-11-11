package game.display;

import java.awt.Dimension;
import java.awt.Font;
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
			
			this.setPreferredSize(new Dimension(50,20));
			this.setSize(new Dimension(50,20));
			
			c = new GridBagConstraints();
			c.fill=GridBagConstraints.BOTH;
			c.gridx=0;
			c.gridy=0;
			c.gridheight=2;
			
			JLabel imagen = new JLabel(new ImageIcon(a.getImage()));
			imagen.setHorizontalAlignment(JLabel.CENTER);
			imagen.setVerticalAlignment(JLabel.CENTER);
			
			add(imagen, c);
			
			c.gridx=1;
			c.gridheight=1;
			
			info = new JPanel(new GridLayout(2, 1));
			JLabel vidaMax = new JLabel("Vida maxima: "+a.getMaxVida());
			vidaMax.setHorizontalAlignment(JLabel.LEFT);
			JLabel vida = new JLabel("Vida: "+a.getVida());
			vida.setHorizontalAlignment(JLabel.LEFT);
			info.add(vidaMax);
			info.add(vida);
			
			add(info, c);
			

			setVisible(true);
			setOpaque(true);
		}
}
