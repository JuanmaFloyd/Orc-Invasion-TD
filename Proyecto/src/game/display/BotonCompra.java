package game.display;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.Launcher;
import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public abstract class BotonCompra extends JLabel{
	//atributos
	protected int valor;
	protected PanelTienda p;
	protected JLabel l;
	
	//constructor
	public BotonCompra(PanelTienda pan, int value){
		valor=value;
		setLayout(new CardLayout());
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		p=pan;
		setOpaque(true);
		JLabel per=new JLabel();
		l=per;
		per.setFont(Launcher.fuente(20));
		per.setHorizontalAlignment(CENTER);
		per.setLayout(new CardLayout());
		if(value>0){
			JLabel v=new JLabel();
			v.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.anchor=GridBagConstraints.SOUTHEAST;
			c.gridx=0;
			c.gridy=0;
			c.ipadx=95;
			c.ipady=45;
			JLabel val=new JLabel();
			val.setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Coin.png")));
			val.setText("" + valor);
			val.setFont(Launcher.fuente(20));
			val.setHorizontalAlignment(JLabel.RIGHT);
			val.setVerticalAlignment(JLabel.BOTTOM);
			val.setPreferredSize(new Dimension(20,10));
			v.add(val,c);
			v.setVisible(true);
			per.add(v);
		}
		add(per);
		setHorizontalAlignment(JLabel.CENTER);
	}
	protected void setearIcono(BufferedImage bi){
		l.setIcon(new ImageIcon(bi));
	}
	protected void setearTexto(String s){
		l.setText(s);
	}
	
	
	public void setearComprable(int v){
		if(valor>v){
			setEnabled(false);
		}
		else
			setEnabled(true);
	}
}
