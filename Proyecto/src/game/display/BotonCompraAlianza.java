package game.display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;

import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public class BotonCompraAlianza extends BotonCompra{
	//atributos
		protected String alianza;
		
		
		public BotonCompraAlianza(PanelTienda pan, int valor, String al){
			super(pan, valor);
			setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianza.png")));
			setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianzaAnulado.png")));
			alianza=al;
			addMouseListener(new OyenteCompra());
			setearTexto("Comprar alianza con "+al);
		}
		
		private class OyenteCompra implements MouseListener{
			public void mouseClicked(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianzaPresionado.png")));
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
					setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianza.png")));
					p.comprarAlianza(alianza, valor);
				}
			}
		}
}
