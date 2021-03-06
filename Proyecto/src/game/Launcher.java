package game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.*;

import javax.sound.sampled.*;

/**
 * 
 * Clase Launcher
 * Se encarga de ejecutar el programa
 *
 */

public class Launcher {

	public static void main(String[] args) throws Exception{

		Game game = new Game("Orc - Invasion", 768 , 384);
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
		new File("nix.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-30.0f); 
		clip.start();
		
		game.start();

	}
	/**
	 * Retorna la fuente 8-bit usada en la mayoria del juego
	 * @param size tama�o de fuente
	 * @return fuente
	 */
	public static Font fuente(int size){
		try{
			return Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("8-Bit.TTF"))).deriveFont(Font.PLAIN, size);
		}
		catch(IOException | FontFormatException e){
			e.printStackTrace();
		}
		return null;
	}
}
