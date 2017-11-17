package game.display;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.Launcher;
import game.gfx.ImageLoader;
import logica.Comprable;
import logica.Tienda;

/**
 * Clase BotonVenta
 * Extiende a la clase JLabel de Java
 * Representa un boton para vender un Comprable
 *
 */
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
		per.setFont(Launcher.fuente(20));
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
		val.setFont(Launcher.fuente(20));
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
			try{
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("hit.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl = 
				(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-15.0f); 
				clip.start();
			} catch(Exception e){}
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
