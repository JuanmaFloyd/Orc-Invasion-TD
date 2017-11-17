package game.gfx;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase SoundLoader
 * Carga el audio del juego
 *
 */
public class SoundLoader {
	//atributos
	
	//metodos
	/**
	 * Carga un audio a partir de un path
	 * @param path
	 * @return audio
	 */
	public static AudioInputStream loadSound(String path){
		try{
			return AudioSystem.getAudioInputStream(SoundLoader.class.getResource(path));
		}
		catch(IOException | UnsupportedAudioFileException e){
			e.printStackTrace();
		}
		return null;
	}
}
