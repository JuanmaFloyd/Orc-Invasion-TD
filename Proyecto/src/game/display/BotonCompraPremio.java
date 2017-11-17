package game.display;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.gfx.ImageLoader;
import logica.Objeto;
import objeto.noAtravesable.objetoConVida.Premios.Premio;

@SuppressWarnings("serial")
public class BotonCompraPremio extends BotonCompra {
	//atributos
	protected Premio o;
	protected int c;
	protected JLabel cant;
	
	//constructor
	public BotonCompraPremio(PanelTienda pan, BufferedImage i, Premio ob){
		super(pan, 0);
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		addMouseListener(new OyenteCompra());
		o=ob;
		setearIcono(i);
		c=0;
		JLabel v=new JLabel();
		v.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor=GridBagConstraints.NORTHEAST;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=95;
		c.ipady=45;
		cant=new JLabel();
		cant.setText("" + this.c);
		cant.setHorizontalAlignment(JLabel.RIGHT);
		cant.setVerticalAlignment(JLabel.TOP);
		cant.setPreferredSize(new Dimension(20,10));
		cant.setVisible(true);
		v.add(cant,c);
		v.setVisible(true);
		add(v);
	}
	public void sumarPremio(){
		c++;
		cant.setText(""+c);
		p.agregarPremio(this);
	}
	public void restarPremio(){
		c--;
		cant.setText(""+c);
		if(c<=0)
			p.eliminarPremio(this);
	}
	public int cantidad(){
		return c;
	}
	
	private class OyenteCompra implements MouseListener{
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
			if(((BotonCompraPremio)arg0.getSource()).isEnabled()){
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
				if(c>0){
					Objeto aux=o.clone();
					p.setPrototype(aux);
				}
			}
		}
	}
}
