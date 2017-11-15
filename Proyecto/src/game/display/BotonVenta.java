package game.display;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.gfx.ImageLoader;
import logica.Comprable;
import logica.Objeto;
import logica.Tienda;

@SuppressWarnings("serial")
public class BotonVenta extends JLabel{
	//atributos
	protected Comprable c;
	protected Tienda tien;
	
	//constructor
	public BotonVenta(Comprable c, Tienda t){
		this.c = c;
		tien=t;
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setLayout(new CardLayout());
		addMouseListener(new OyenteVenta());
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		setOpaque(true);
		JLabel per=new JLabel("vender");
		per.setFont(new Font("8-Bit Madness", Font.PLAIN, 20));
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
		val.setVisible(true);
		val.setText("+" + c.getPrecioVenta());
		val.setFont(new Font("8-Bit Madness", Font.PLAIN, 20));
		val.setHorizontalAlignment(JLabel.RIGHT);
		val.setVerticalAlignment(JLabel.BOTTOM);
		val.setPreferredSize(new Dimension(20,10));
		v.add(val,con);
		v.setVisible(true);
		per.add(v);
		add(per);
	}
	
	private class OyenteVenta implements MouseListener{
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
			if(((BotonVenta)arg0.getSource()).isEnabled()){
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
				tien.vender(c);
				((BotonVenta)arg0.getSource()).setEnabled(false);
			}
		}
	}
}