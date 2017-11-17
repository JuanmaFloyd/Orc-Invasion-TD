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
import logica.NivelInfinito;
import logica.NivelMedio;

/**
 * Clase Menu
 * Extiende a la clase JPanel de Java
 * Representa la grafica del menu principal
 *
 */
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
		
		Nivel n1 = new NivelFacil();
		Nivel n2 = new NivelFacil();
		Nivel n3 = new NivelFacil();
		Nivel n4 = new NivelMedio();
		Nivel n5 = new NivelMedio();
		Nivel n6 = new NivelMedio();
		Nivel n7 = new NivelDificil();
		Nivel n8 = new NivelDificil();
		Nivel n9 = new NivelDificil();
		Nivel nInf = new NivelInfinito();
		
		n1.setSiguiente(n2);
		n1.setMonedasInicio(500);
		n2.setSiguiente(n3);
		n2.setMonedasInicio(500);
		n3.setSiguiente(n4);
		n3.setMonedasInicio(500);
		n4.setSiguiente(n5);
		n4.setMonedasInicio(500);
		n5.setSiguiente(n6);
		n5.setMonedasInicio(500);
		n6.setSiguiente(n7);
		n6.setMonedasInicio(500);
		n7.setSiguiente(n8);
		n7.setMonedasInicio(500);
		n8.setSiguiente(n9);
		n8.setMonedasInicio(500);
		n9.setSiguiente(nInf);
		n9.setMonedasInicio(500);
		nInf.setMonedasInicio(500);
		
		
		
		panelPrincipal.add( new BotonNivel(g, n1, "1"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n2, "2"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n3, "3"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n4, "4"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n5, "5"), c);
		c.gridx=0;
		c.gridy++;
		panelPrincipal.add( new BotonNivel(g, n6, "6"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n7, "7"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n8, "8"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, n9, "9"), c);
		c.gridx++;
		panelPrincipal.add( new BotonNivel(g, nInf, "infinito"), c);
		c.gridx++;
		
		labelFondo.add(panelPrincipal);
	}
}
