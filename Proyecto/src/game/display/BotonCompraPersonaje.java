package game.display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;

import game.gfx.ImageLoader;
import logica.Comprable;
import logica.Objeto;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.personaje.aliado.Aliado;

@SuppressWarnings("serial")
public class BotonCompraPersonaje extends BotonCompra{
	//atributos
	protected Comprable o;
	
	public BotonCompraPersonaje(PanelTienda pan, BufferedImage i, Comprable ob){
		super(pan, ob.getPrecio());
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		addMouseListener(new OyenteCompra());
		o=ob;
		setearIcono(i);
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
			if(((BotonCompra)arg0.getSource()).isEnabled()){
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
				Objeto aux=o.clone();
				p.setPrototype(aux);
			}
		}
	}
}
