package game.display;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.gfx.ImageLoader;
import logica.Logica;
import logica.Nivel;
import logica.NivelDificil;
import logica.NivelFacil;
import logica.NivelVacio;

@SuppressWarnings("serial")
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
		
		
		Nivel n0 = new NivelVacio();
		Nivel n1 = new NivelFacil();
		Nivel n2 = new NivelFacil();
		Nivel n3 = new NivelFacil();
		Nivel n4 = new NivelFacil();
		Nivel n5 = new NivelDificil();
		Nivel n6 = new NivelDificil();
		Nivel n7 = new NivelDificil();
		Nivel n8 = new NivelDificil();
		Nivel n9 = new NivelDificil();
		
		n0.setSiguiente(n1);
		n1.setSiguiente(n2);
		n2.setSiguiente(n3);
		n3.setSiguiente(n4);
		n4.setSiguiente(n5);
		n5.setSiguiente(n6);
		n6.setSiguiente(n7);
		n7.setSiguiente(n8);
		n8.setSiguiente(n9);
		
		panelPrincipal.add( new BotonNivel(g, n0, "0"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n1, "1"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n2, "2"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n3, "3"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n4, "4"), c);
		c.gridx=0;
		c.gridy++;
		panelPrincipal.add( new BotonNivel(g, n5, "5"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n6, "6"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n7, "7"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n8, "8"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n9, "9"), c);
		c.gridx++;
		
		labelFondo.add(panelPrincipal);
	}
}
