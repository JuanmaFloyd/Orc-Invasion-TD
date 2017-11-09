package game;

import java.io.*;

import javax.sound.sampled.*;

import sun.audio.*;

public class Launcher {

	public static void main(String[] args) throws Exception{

		Game game = new Game("Juegazo", 768 , 384);
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
		new File("nix.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-45.0f); 
		clip.start();
		
		game.start();

	}
}
