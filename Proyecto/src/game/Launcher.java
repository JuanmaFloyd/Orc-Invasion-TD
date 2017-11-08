package game;

import java.io.*;
import sun.audio.*;

public class Launcher {

	public static void main(String[] args) throws Exception{
		String audio = "nix.wav";
		InputStream in = new FileInputStream(audio);
		AudioStream music = new AudioStream(in);
		Game game = new Game("Juegazo", 768 , 384);
		
		
		game.start();
		AudioPlayer.player.start(music);
	}
}
