package game.display;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.gfx.ImageLoader;

public class Menu extends JPanel{
	
	public Menu(){
		setLayout(new CardLayout());
		
		JLabel labelFondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/Fondo Menu")));
		
		add(labelFondo);
		
		JPanel panelPrincipal = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		
		
		
		add(panelPrincipal);
	}
}
