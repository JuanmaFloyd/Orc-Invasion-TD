package game.display;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.gfx.ImageLoader;
import logica.Comprable;

@SuppressWarnings("serial")
public class BotonVenta extends JLabel{
	//atributos
	protected Comprable c;
	
	//constructor
	public BotonVenta(Comprable c){
		this.c = c;
		setLayout(new CardLayout());
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		setOpaque(true);
		JLabel per=new JLabel("vender");
		per.setHorizontalAlignment(CENTER);
		per.setLayout(new CardLayout());
		JLabel v=new JLabel();
		v.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		con.anchor=GridBagConstraints.SOUTHEAST;
		con.gridx=0;
		con.gridy=0;
		con.ipadx=95;
		con.ipady=45;
		JLabel val=new JLabel();
		val.setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Coin.png")));
		val.setText("+" + c.getPrecioVenta());
		val.setHorizontalAlignment(JLabel.RIGHT);
		val.setVerticalAlignment(JLabel.BOTTOM);
		val.setLocation(val.getX()-10, val.getY()-10);
		v.add(val,con);
		v.setVisible(true);
		per.add(v);
	}
}
