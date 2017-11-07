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
import logica.NivelDificil;
import logica.NivelFacil;

public class Menu extends JPanel{
	//atributos
	private Game g;
	
	//constructor
	public Menu(Game ga){
		g=ga;
		setLayout(new CardLayout());
		
		JLabel labelFondo = new JLabel(new ImageIcon(ImageLoader.loadImage("/Textures/Fondo Menu.png")));
		
		add(labelFondo);
		
		labelFondo.setLayout(new CardLayout());
		
		JPanel panelPrincipal = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		
		panelPrincipal.setOpaque(false);
		
		BotonNivel n1 = new BotonNivel(this, new NivelFacil(), 1);
		panelPrincipal.add(n1, c);

		c.gridx=1;
		
		BotonNivel n2 = new BotonNivel(this, new NivelDificil(), 2);
		panelPrincipal.add(n2, c);
		
		
		labelFondo.add(panelPrincipal);
	}
	
	public void empezarNivel(Nivel n){
		g.empezarNivel(n);
	}
}
